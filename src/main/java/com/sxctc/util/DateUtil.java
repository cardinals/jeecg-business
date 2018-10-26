package com.sxctc.util;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: 时间工具类
 * @author liuzc
 * @date 2018/8/7 上午10:49
 * @version V1.0
 */
public class DateUtil {

    /**
     * @Title getWeekDays
     * @Description 获取当前(上，下)周的日期范围如：...,-1上一周，0本周，1下一周...
     * @Param [i]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author liuzc
     * @Date 2018/8/7 上午11:08
     **/
    public static JSONObject getWeekDays(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // getTimeInterval(sdf);

        Calendar calendar1 = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayOfWeek) {
            calendar1.add(Calendar.DAY_OF_MONTH, -1);
        }

        // 获得当前日期是一个星期的第几天
        int day = calendar1.get(Calendar.DAY_OF_WEEK);

        //获取当前日期前（下）x周同星几的日期
        calendar1.add(Calendar.DATE, 7*i);

        calendar1.add(Calendar.DATE, calendar1.getFirstDayOfWeek() - day);



        String beginDate = sdf.format(calendar1.getTime());
        calendar1.add(Calendar.DATE, 6);

        String endDate = sdf.format(calendar1.getTime());

        JSONObject result = new JSONObject();
        result.put("beginDate",beginDate);
        result.put("endDate",endDate);
        return result;
        //System.out.println(beginDate+" 到 "+endDate);
    }

    public static void getTimeInterval(SimpleDateFormat sdf) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //
        // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String imptimeBegin = sdf.format(cal.getTime());
        System.out.println("所在周星期一的日期：" + imptimeBegin);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        System.out.println(cal.getFirstDayOfWeek());
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        imptimeBegin = sdf.format(cal.getTime());
        System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        System.out.println("所在周星期日的日期：" + imptimeEnd);
    }


    /**
     * @Title getWeekDays
     * @Description 获取当前(上，下)月的日期范围如：...,-1上一周，0本周，1下一周...
     * @Param [i]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author liuzc
     * @Date 2018/8/7 上午11:08
     **/
    public static JSONObject getMonthDays(int i) {
        // 获取当前年份、月份、日期
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY);
        int minute = cale.get(Calendar.MINUTE);
        int second = cale.get(Calendar.SECOND);
        int dow = cale.get(Calendar.DAY_OF_WEEK);
        int dom = cale.get(Calendar.DAY_OF_MONTH);
        int doy = cale.get(Calendar.DAY_OF_YEAR);

        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday;
        String lastday;

        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());

        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());

        // 返回结果
        JSONObject result = new JSONObject();
        result.put("beginDate",firstday);
        result.put("endDate",lastday);
        return result;
    }

    /**
     * @Title getCurrentYear
     * @Description 获取当前年份
     * @Param []
     * @Return java.lang.String
     * @Author liuzc
     * @Date 2018/8/30 上午9:27
     **/
    public static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentYear());

    }

}
