package com.sxctc.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * ClassName:RedisUtil</br>
 * Function: 提供redis的操作工具类</br>
 *
 * @author liuzc</br>
 * @version 1.1</br>
 * @Date 2015-7-22 下午2:31:53</br>
 */
public class RedisUtil {

    private static Logger log = Logger.getLogger(RedisUtil.class);

    private ThreadLocal<OP> current = new ThreadLocal<OP>();

    private static JedisPool writePool;

    private static JedisPool readPool;

    private static int RETRY = 10;

    enum OP {
        write, read
    }


    private RedisUtil() {
    }

    private static class StaticHolder {
        static final RedisUtil instance = new RedisUtil();
    }

    public static RedisUtil getInstance() {
        return StaticHolder.instance;
    }

    /**
     * 获取Redis实例.
     *
     * @return Redis工具类实例
     */
    private Jedis getJedis() {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                if (current.get() == OP.write && writePool != null) {
                    jedis = writePool.getResource();
                }
                if (current.get() == OP.read && readPool != null) {
                    jedis = readPool.getResource();
                }
            } catch (Exception e) {
                log.error("" + (count + 1) + " times get redis connect fail，OP=" + current.get() + "，trying...", e);
                closeJedis(jedis, (e instanceof JedisConnectionException));
            }
            count++;
        } while (jedis == null && count < RETRY);

        if (jedis == null) {
            log.error("can not get redis connect，OP=" + current.get() + "，please check config");
            return null;
        } else {
            return jedis;
        }
    }

    /**
     * 将jedis放回连接池
     *
     * @param jedis
     */
    private void closeJedis(Jedis jedis, boolean isBroken) {
        if (current.get() == OP.write && writePool != null) {
            if (isBroken) {
                writePool.returnBrokenResource(jedis);
            } else {
                writePool.returnResourceObject(jedis);
            }
        }
        if (current.get() == OP.read && readPool != null) {
            if (isBroken) {
                readPool.returnBrokenResource(jedis);
            } else {
                readPool.returnResourceObject(jedis);
            }
        }
        //删除变量 防止内存泄漏
        current.remove();
    }

    /**
     * 存放值
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        if (value == null) {
            throw new Exception("value is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            log.error("redis write data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }

    /**
     * 获取值
     *
     * @param key
     * @return
     */
    public String get(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        String value = null;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            value = jedis.get(key);
        } catch (Exception e) {
            log.error("redis read data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return value;
    }


    /**
     * 判断 key是否存在
     *
     * @param key
     * @return
     */
    public boolean existsKey(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        boolean value = false;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            value = jedis.exists(key);
        } catch (Exception e) {
            log.error("redis read data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return value;
    }

    /**
     * 删除（用于所有数据类型）
     *
     * @param key
     * @return 返回删除数量
     */
    public long del(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        long result = 0;
        // ！当前设为写模式
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("redis delete data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }


    /**
     * 递减 （如果key不存在返回-1，如果存在并且为数字的话就减一
     * 如果不是纯数字的话则会抛出不是纯数字的异常）
     *
     * @param key
     * @return 操作后key的值
     * @throws Exception
     */
    public long decrease(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        long result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.decr(key);
        } catch (Exception e) {
            log.error("redis decrease data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * 按num减少
     *
     * @param key
     * @param num
     * @return 操作后key对应的值
     * @throws Exception
     */
    public long decrease(String key, int num) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        long result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.decrBy(key, num);
        } catch (Exception e) {
            log.error("redis decrease data by number fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * 递增，如果key不存在则初始化0后，进行递增
     * （如果不是纯数字的话则会抛出不是纯数字的异常）
     *
     * @param key
     * @return 操作后key对应的值
     * @throws Exception
     */
    public long increase(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        long result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.incr(key);
        } catch (Exception e) {
            log.error("redis increase data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * 按num 整数增加
     *
     * @param key
     * @param num 整数类型
     * @return 操作后key对应的值
     * @throws Exception
     */
    public long increase(String key, int num) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        long result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.incrBy(key, num);
        } catch (Exception e) {
            log.error("redis crease data by number fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }


    /**
     * 按num float增加
     *
     * @param key
     * @param value float类型
     * @return 操作后key对应的值
     * @throws Exception
     */
    public double increaseFloat(String key, float value) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        double result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.incrByFloat(key, value);
        } catch (Exception e) {
            log.error("redis crease data by number fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * 存放map结构
     *
     * @param key
     * @param map
     */
    public void setMap(String key, Map<String, String> map) throws Exception {
        if (key == null) {
            throw new Exception("key is null");
        }
        if (map == null) {
            throw new Exception("map is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.hmset(key, map);

        } catch (Exception e) {
            log.error("redis save map fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }

    /**
     * 清空list
     *
     * @param key
     */
    public void clearList(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.ltrim(key, 1, 0);
        } catch (Exception e) {
            log.error("redis clear list fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }

    /**
     * 存放list结构(先进先出模式)
     *
     * @param key
     * @param list
     */
    public void setList(String key, List<String> list) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        if (null == list || list.size() == 0) {
            throw new Exception("list is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            String[] strings = new String[list.size()];
            jedis.rpush(key, list.toArray(strings));
        } catch (Exception e) {
            log.error("redis save list fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }


    /**
     * 存放值(当key不存在的时候，才进行存储操作)
     *
     * @param key
     * @param value 1:成功  0:失败
     */
    public long setNX(String key, String value) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        if (value == null) {
            throw new Exception("value is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            long result = jedis.setnx(key, value);
            return result;
        } catch (Exception e) {
            log.error("redis write data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }


    /**
     * 分页获取list
     *
     * @param key
     * @return
     */
    public List<String> getList(String key, long start, long end) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        List<String> list = null;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                list = jedis.lrange(key, start, end - 1);
            }
        } catch (Exception e) {
            log.error("redis get list fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return list;
    }

    /**
     * 分页获取list
     *
     * @param key
     * @return
     */
    public long getListLenght(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        long size = 0;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                size = jedis.llen(key);
            }
        } catch (Exception e) {
            log.error("redis get list fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return size;
    }


    /**
     * 获取list
     *
     * @param key
     * @return
     */
    public List<String> getList(String key) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        List<String> list = null;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                list = jedis.lrange(key, 0, -1);
            }
        } catch (Exception e) {
            log.error("redis get list fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return list;
    }

    /**
     * 模糊查询keys列表
     *
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) throws Exception {
        if (null == pattern || pattern.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        Set<String> keys = null;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            keys = jedis.keys(pattern);
        } catch (Exception e) {
            log.error("redis getKeys fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return keys;
    }

    /**
     * 获取key对应的map数据
     *
     * @param key
     * @return
     */
    public Map<String, String> getMap(String key) throws Exception {

        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        current.set(OP.read);
        Map<String, String> map = null;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error("redis getMap fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return map;
    }

    /**
     * 关闭redis的 读、写连接池(主要在应用关闭的时候)
     */
    public void closeRedisPool() {

        // 关闭读连接池
        if (null != readPool && !readPool.isClosed()) {
            readPool.close();
        }
        // 关闭写连接池
        if (null != writePool && !writePool.isClosed()) {
            writePool.close();
        }
    }

    /**
     * 存放值(存放值,并设置超时时间)
     *
     * @param key
     * @param value
     */
    public String setEX(String key, String value, int seconds) throws Exception {
        if (null == key || key.length() == 0) {
            throw new Exception("key is null");
        }
        if (value == null) {
            throw new Exception("value is null");
        }
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            String result = jedis.setex(key, seconds, value);
            return result;
        } catch (Exception e) {
            log.error("redis write data fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
    }

    /**
     * hash类型 根据key field 添加value
     *
     * @param key
     * @param field
     * @param value
     * @return
     * @throws Exception
     */
    public long hset(String key, String field, String value) throws Exception {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field) || StringUtils.isEmpty(value)) {
            throw new Exception("key or field or value is null");
        }
        current.set(OP.write);
        long result;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error("redis hset data by key and field fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * hash类型 根据key 获取所有field value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Map<String, String> hgetall(String key) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key is null");
        }
        current.set(OP.write);
        Map<String, String> result;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error("redis hgetall data by key fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }


    /**
     * hash类型 根据key field 对value 增加
     *
     * @param key
     * @param field
     * @param num
     * @return
     * @throws Exception
     */
    public long hincrby(String key, String field, int num) throws Exception {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
            throw new Exception("key or field is null");
        }
        long result = 0;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.hincrBy(key, field, num);
        } catch (Exception e) {
            log.error("redis hincrby data by key and field fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * hash类型 根据key field 对value 增加
     *
     * @param keys
     * @return
     * @throws Exception
     */
    public List<String> mget(String... keys) throws Exception {
        if (0 == keys.length) {
            throw new Exception("keys is empty");
        }
        List<String> result = null;
        current.set(OP.write);
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.mget(keys);
        } catch (Exception e) {
            log.error("redis mget data by keys fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * hash类型 根据key 获取所有field value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String hget(String key, String field) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key is null");
        }
        current.set(OP.write);
        String result;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.hget(key, field);
        } catch (Exception e) {
            log.error("redis hget data by key and field fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * set类型 根据key 添加 value
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Long sadd(String key, String... value) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key is null");
        }
        current.set(OP.write);
        Long result;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.sadd(key, value);
        } catch (Exception e) {
            log.error("redis sadd data by key fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
     * set类型 根据key 取值
     *
     * @param key
     * @return
     * @throws Exception
     */
    public Set<String> smembers(String key) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key is null");
        }
        current.set(OP.write);
        Set<String> result;
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            result = jedis.smembers(key);
        } catch (Exception e) {
            log.error("redis smembers data by key fail !", e);
            if (e instanceof JedisConnectionException) {
                isBroken = true;
            }
            throw e;
        } finally {
            closeJedis(jedis, isBroken);
        }
        return result;
    }

    /**
	 * 给一个键设置一个指定的过期时间
	 * @param key 
	 * @param time 过期时间(s)
	 * @return 成功返回1,失败返回-1
	 * @throws Exception 
	 */
	public long expire(String key,int time) throws Exception{
		if (null == key || key.length() == 0) {
			throw new Exception("key is null");
		}
		long result = 0;
		current.set(OP.write);
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			result = jedis.expire(key, time);
		} catch (Exception e) {
			log.error("redis expire data fail !", e);
			if(e instanceof JedisConnectionException){
				isBroken = true;
			}
			throw e;
		} finally {
			closeJedis(jedis,isBroken);
		}
		return result;
	}
    
	/**
	 * 存储REDIS队列 顺序存储
	 * 
	 * @param byte[]
	 *            key reids键名
	 * @param byte[]
	 *            value 键值
	 * @throws Exception
	 */
	public void lpush(String key,String value) throws Exception {
		if (null == key || key.length() == 0) {
			throw new Exception("key is null");
		}
		boolean isBroken = false;
		current.set(OP.write);
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.lpush(key, value);
		} catch (Exception e) {
			log.error("redis lpush data fail !", e);
			if (e instanceof JedisConnectionException) {
				isBroken = true;
			}
			throw e;
		} finally {
			closeJedis(jedis, isBroken);
		}
	}

	/**
	 * 获取队列数据
	 * 
	 * @param key
	 *            键名
	 * @return
	 * @throws Exception 
	 */
	public String rpop(String key) throws Exception {
		if (null == key || key.length() == 0) {
			throw new Exception("key is null");
		}
		String result = null;
		current.set(OP.write);
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			result = jedis.rpop(key);

		} catch (Exception e) {
			log.error("redis rpop data fail !", e);
			if (e instanceof JedisConnectionException) {
				isBroken = true;
			}
			throw e;
		} finally {
			closeJedis(jedis, isBroken);
		}
		return result;
	}

}
