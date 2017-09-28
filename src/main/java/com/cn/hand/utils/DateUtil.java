package com.cn.hand.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hand on 2017/9/7.
 */
public class DateUtil {

    /**
     * yyyyMMdd
     */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /**
     * 获取当天日期字符串
     *
     * @return
     */
    public static String getTodayStr(String format) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(dt);
    }

    /**
     * 获得当前日期的前一天 ,格式yyyyMMdd
     *
     * @param
     * @return
     * @throws Exception
     */
    public static String getBeforeDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return sdf.format(calendar.getTime());
    }

}
