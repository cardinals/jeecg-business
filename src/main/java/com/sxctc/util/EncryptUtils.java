package com.sxctc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * ClassName:DigestUtil</br> Function: 数据加密工具类</br>
 * 
 * @author liuzc</br>
 * @version 1.0</br>
 * @Date 2015-8-31 下午4:40:54</br>
 * 
 */
public class EncryptUtils
{
	
	/**
	 * 百度价格加密算法使用 sha-1 hmac
	 */
	private static final String HMAC_SHA1 = "HmacSHA1";
	
	/**
	 * 数据编码utf8
	 */
	private static final String ENCODE = "UTF-8";
	
	/**
	 * MD5加密算法
	 */
	private static final String MD5 = "MD5";
	
	/**
	 * 3DES desede (算法名称)
	 */
	private static final String DES3_KEY_ALGORITHM = "desede";
	
	/**
	 * 3DES desede/CBC/NoPadding (算法名称/加密模式/填充方式 )
	 */
	public static final String DES3_CIPHER_ALGORITHM = "desede/ECB/PKCS5Padding";
	
	public static final String KEY_STRING = "9d5716ed2356ee0ea02d45f";
	
	/**
     * 3DES des (算法名称) 
     */
    private static final String DES_KEY_ALGORITHM = "DES";
    
    /**
     * 3DES des/CBC/NoPadding (算法名称/加密模式/填充方式 )
     */
    public static final String DES_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	
	/**
	 * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
	 * 
	 * @param encryptText
	 *            被签名的字符串
	 * @param encryptKey
	 *            密钥
	 * @return 签名byte[]
	 * @throws Exception
	 */
	public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey)
	        throws Exception
	{
	
		// 获取密钥的byte数组
		byte[] data = encryptKey.getBytes(ENCODE);
		
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法名称
		SecretKey secretKey = new SecretKeySpec(data, HMAC_SHA1);
		
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(HMAC_SHA1);
		
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		
		// 获取被加密串默认编码格式的byte
		byte[] text = encryptText.getBytes(ENCODE);
		
		// 完成 Mac 操作
		return mac.doFinal(text);
	}
	
	public static byte[] HmacSHA1Encrypt(byte[] encryptText, byte[] encryptKey)
	        throws Exception
	{
	
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法名称
		SecretKey secretKey = new SecretKeySpec(encryptKey, HMAC_SHA1);
		
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(HMAC_SHA1);
		
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		
		// 完成 Mac 操作
		return mac.doFinal(encryptText);
	}
	
	public static byte[] HmacSHA1Encrypt(byte[] encryptText,
	        byte[] encryptText2, byte[] encryptKey) throws Exception
	{
	
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法名称
		SecretKey secretKey = new SecretKeySpec(encryptKey, HMAC_SHA1);
		
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(HMAC_SHA1);
		
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		
		// 更新数据
		mac.update(encryptText);
		mac.update(encryptText2);
		
		// 完成 Mac 操作
		return mac.doFinal();
	}
	
	/**
	 * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
	 * 
	 * @param encryptText
	 *            被签名的字符串
	 * @param encryptKey
	 *            密钥
	 * @return 签名byte[]
	 * @throws Exception
	 */
	public static String HmacSHA1EncryptDefault(String encryptText) throws Exception
	{
	
		// 获取密钥的byte数组
		byte[] data = KEY_STRING.getBytes(ENCODE);
		
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法名称
		SecretKey secretKey = new SecretKeySpec(data, HMAC_SHA1);
		
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(HMAC_SHA1);
		
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		
		// 获取被加密串默认编码格式的byte
		byte[] text = encryptText.getBytes(ENCODE);
		
		// 完成 Mac 操作 并返回十六进制字符串
		return bytesToHexString(mac.doFinal(text));
	}
	
	/**
	 * 验证两个byte[] 是否一致
	 * 
	 * @param b1
	 *            数组1
	 * @param b2
	 *            数组2
	 * @return
	 */
	public static boolean verify(byte[] b1, byte[] b2)
	{
	
		return MessageDigest.isEqual(b1, b2);
	}
	
	/**
	 * byte[] 数组转16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src)
	{
	
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 16进制字符串转byte数组
	 * 
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexString)
	{
	
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	
	private static byte charToByte(char c)
	{
	
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	/**
	 * 将byte[]转为各种进制的字符串
	 * 
	 * @param bytes
	 *            byte[]
	 * @param radix
	 *            基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX， 超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	public static String binary(byte[] bytes, int radix)
	{
	
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}
	
	/**
	 * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
	 * 
	 * @param src
	 *            byte数组
	 * @param offset
	 *            从数组的第offset位开始
	 * @return int数值
	 */
	public static int bytesToInt(byte[] src, int offset)
	{
	
		int value;
		value = (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
		        | ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
		return value;
	}
	
	/**
	 * 将byte[2]转换成short
	 * 
	 * @param b
	 * @return
	 */
	public static short bytesToShort(byte[] b)
	{
	
		return (short) (((b[0] & 0xff) << 8) | (b[1] & 0xff));
	}
	
	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用
	 * 
	 * @param value
	 *            要转换的int值
	 * @return byte数组
	 */
	public static byte[] intToBytes(int value)
	{
	
		byte[] src = new byte[4];
		src[3] = (byte) ((value >> 24) & 0xFF);
		src[2] = (byte) ((value >> 16) & 0xFF);
		src[1] = (byte) ((value >> 8) & 0xFF);
		src[0] = (byte) (value & 0xFF);
		return src;
	}
	
	/**
	 * 异或操作(byte数组输入)
	 * 
	 * @param info
	 * @param key
	 * @return
	 */
	public static byte[] xorEncry(byte[] info, byte[] key)
	{
	
		byte[] result = new byte[info.length];
		for (int i = 0, j = 0; i < info.length; ++i) {
			result[i] = (byte) (info[i] ^ key[j]);
			j = (++j) % (key.length);
		}
		return result;
	}
	
	public static byte[] orEncry(byte[] info, byte[] key)
	{
	
		byte[] result = new byte[info.length];
		for (int i = 0, j = 0; i < info.length; ++i) {
			result[i] = (byte) (info[i] | key[j]);
			j = (++j) % (key.length);
		}
		return result;
	}
	
	/**
	 * 简单异或操作(字符串输入)
	 * 
	 * @param info
	 * @param key
	 * @return 返回结果 byte数组
	 */
	public static byte[] xorEncry(String info, String key)
	{
	
		byte[] result = new byte[info.length()];
		for (int i = 0, j = 0; i < info.length(); ++i) {
			result[i] = (byte) (info.charAt(i) ^ key.charAt(j));
			j = (++j) % (key.length());
		}
		return result;
	}
	
	/**
	 * 简单异或加密算法，并进行base64加密
	 * 
	 * @param info
	 *            需要加密的串
	 * @param key
	 *            加密key
	 * @return
	 */
	public static String xorEncryAndBase64(String info, String key)
	{
	
		byte[] result = new byte[info.length()];
		
		for (int i = 0, j = 0; i < info.length(); ++i) {
			result[i] = (byte) (info.charAt(i) ^ key.charAt(j));
			j = (++j) % (key.length());
		}
		return Base64.encodeBase64String(result);
	}
	
	/**
	 * 要将base64加密数据放在url中进行传输的话，需要进行url安全加密 但后续解析的时候，需要自己将特殊字符转一下
	 * 
	 * @param string
	 * @return
	 */
	public static String base64UrlSafeEncode(String string)
	{
	
		return Base64.encodeBase64URLSafeString(string.getBytes());
	}
	
	/**
	 * 反解析url安全的base64字符串
	 * 
	 * @param string
	 * @return
	 */
	public static String base64UrlSafeDecode(String string)
	{
	
		// 追加base64结尾符号
		if (string.length() % 4 == 3) {
			string = string + "=";
		} else if (string.length() % 4 == 2) {
			string = string + "==";
		}
		
		// 替换关键字符( web_safe_base64)
		return string.replaceAll("-", "+").replaceAll("_", "/");
	}
	
	/**
	 * 获取字符串的32位MD5值
	 * 
	 * @param text
	 * @return
	 */
	public static String md5Encrypt(String text)
	{
	
		try {
			// 使用指定字符集
			byte[] btInput = text.getBytes(ENCODE);
			// 获取算法
			MessageDigest mdInst = MessageDigest.getInstance(MD5);
			// 更新参数
			mdInst.update(btInput);
			// 生成byte数组
			byte[] md = mdInst.digest();
			// 返回经过加密后的字符串
			return bytesToHexString(md);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * keybyte为加密密钥，长度为24字节 src为被加密的数据缓冲区（源）
	 * 
	 * @param keybyte
	 * @param src
	 * @return
	 */
	public static byte[] DES3Encrypt(byte[] keybyte, byte[] src)
	{
	
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, DES3_KEY_ALGORITHM);
			// 加密
			Cipher c1 = Cipher.getInstance(DES3_CIPHER_ALGORITHM);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * keybyte为加密密钥，长度为24字节 src为加密后的缓冲区
	 * 
	 * @param keybyte
	 * @param src
	 * @return
	 */
	public static byte[] DES3Decrypt(byte[] keybyte, byte[] src)
	{
	
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, DES3_KEY_ALGORITHM);
			// 解密
			Cipher c1 = Cipher.getInstance(DES3_CIPHER_ALGORITHM);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	 /** 
     * DES加密数据
     * @param data 待加密数据
     * @param key 密钥 
     * @return 加密后的数据 
     */
    public static byte[] DESEncrypt(String key,String data) throws Exception {
    	
    	DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODE));
        // 获取密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 生成密钥
        SecretKey securekey = keyFactory.generateSecret(desKeySpec);
        // 随机
        SecureRandom random = new SecureRandom();
        // 实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(DES_KEY_ALGORITHM);
        // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        byte[] results = cipher.doFinal(data.getBytes(ENCODE));
        // 执行加密操作
        return results;
    }
	
	 /**
     * DES解密数据 
     * @param data 待解密数据 
     * @param key 密钥 
     * @return 解密后的数据 
     */
    public static byte[] DESDecrypt(String key,String data) throws Exception {
    	// 获取key bytes
    	DESKeySpec desKey = new DESKeySpec(key.getBytes(ENCODE));
    	// 获取密钥工厂
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    	// 生成密钥
    	SecretKey securekey = keyFactory.generateSecret(desKey);
    	//初始化Cipher对象，设置为解密模式
    	Cipher cipher = Cipher.getInstance(DES_KEY_ALGORITHM);
    	cipher.init(Cipher.DECRYPT_MODE, securekey);
    	// 执行解密操作
    	return cipher.doFinal(data.getBytes(ENCODE));
    }
    
	/**
	 * DES解密Base64字符串数据
	 * 
	 * @param key
	 *            密钥
	 * @param data
	 *            待解密Base64字符串数据
	 * @return 解密后的数据
	 */
    public static String DESDecryptBase64(String key,String data) throws Exception {
    	// 获取key bytes
    	DESKeySpec desKey = new DESKeySpec(key.getBytes(ENCODE));
    	// 获取密钥工厂
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    	// 生成密钥
    	SecretKey securekey = keyFactory.generateSecret(desKey);
    	//初始化Cipher对象，设置为解密模式
    	Cipher cipher = Cipher.getInstance(DES_CIPHER_ALGORITHM);
    	cipher.init(Cipher.DECRYPT_MODE, securekey);
    	// 执行解密操作
    	byte[] results =  cipher.doFinal(Base64.decodeBase64(data));
    	// 返回解析明文
    	return new String(results,ENCODE);
    }
    
	
    /** 
     * DES加密数据
     * @param data 待加密明文字符串数据
     * @param key 密钥 
     * @return 加密后的Base64字符串
     */
    public static String DESEncryptBase64(String key,String data) throws Exception {
    	
    	DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODE));
        // 获取密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 生成密钥
        SecretKey securekey = keyFactory.generateSecret(desKeySpec);
        // 随机
        SecureRandom random = new SecureRandom();
        // 实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(DES_CIPHER_ALGORITHM);
        // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        // 执行加密操作
        byte[] results = cipher.doFinal(data.getBytes(ENCODE));
        // 返回base64字符串
        return Base64.encodeBase64String(results);
    }
    
    
	public static void main(String[] args){
	
		try {
			System.out.println(md5Encrypt("361fda3f94690baceb01c5843b32af2e"));;
			String base64 = DESEncryptBase64("31f36cf2", "123");
			System.out.println(base64);
			String result = DESDecryptBase64("31f36cf2", base64);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
