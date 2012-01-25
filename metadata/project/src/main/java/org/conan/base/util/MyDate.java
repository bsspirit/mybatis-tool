package org.conan.base.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class MyDate {
    
    /**
     * 格式: 20101212
     * 
     * @param day
     * @return
     */
    public static String dayString(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(day);
    }

    /**
     * 格式: 20101212
     * 
     * @param day
     * @return
     */
    public static int dayInt(Date day) {
        return Integer.parseInt(dayString(day));
    }

    /**
     * 格式: 20101212171700
     * 
     * @param day
     * @return
     */
    public static String datetimeString(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(day);
    }

    /**
     * 格式: 2010-12-12 10:10:10
     * 
     * @param day
     * @return
     */
    public static String datetimeString2(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(day);
    }

    /**
     * 格式: 2010.12.12 10:10:10
     * 
     * @param day
     * @return
     */
    public static String datetimeString3(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return df.format(day);
    }

    /**
     * 格式：12.12 10:10
     * 
     * @param day
     * @return
     */
    public static String datetimeString4(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("MM.dd HH:mm");
        return df.format(day);
    }
    
    /**
     * 格式：12月12日 10:10
     * 
     * @param day
     * @return
     */
    public static String datetimeString5(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
        return df.format(day);
    }

    /**
     * 今日0点时间
     * 
     * @param day
     * @return
     */
    public static Date dayMorning(Date day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date morning = null;
        try {
            morning = df.parse(df.format(day));
        } catch (ParseException e) {
        }
        return morning;
    }

    /**
     * 之前的X天
     * 
     * @param day
     * @param xday
     * @return
     */
    public static Date beforeDay(Date day, int xday) {
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, today - xday);
        return calendar.getTime();
    }
    
    /**
     * 之后的X天
     * 
     * @param day
     * @param xday
     * @return
     */
    public static Date nextDay(Date day, int xday) {
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, today + xday);
        return calendar.getTime();
    }

    /**
     * 转型Date -> Timestamp
     * 
     * @param date
     * @return
     */
    public static Timestamp date2Timestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * 比较d1,d2大小
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static boolean compare(Date d1, Date d2) {
        return d1.getTime() >= d2.getTime() ? true : false;
    }

    /**
     * 转型到数据库Date格式
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date setDBDate(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.parse(date);
    }

    /**
     * Date数据库格式转型到String
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getDBDate(Date date) {
        return datetimeString2(date);
    }

    /**
     * 转型到数据库Timestamp格式
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Timestamp setDBTimestamp(String date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date2Timestamp(df.parse(date));
    }

    /**
     * Timestamp数据库格式转型到String
     * 
     * @param time
     * @return
     * @throws ParseException
     */
    public static String getDBTimestamp(Timestamp time) {
        return datetimeString2(time);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(setDBTimestamp("2010-12-12 00:12:12"));
        System.out.println(getDBTimestamp(date2Timestamp(new Date())));
        System.out.println(setDBDate("2010-12-12 00:12:12"));
        System.out.println(getDBDate(new Date()));

        System.out.println(datetimeString2(beforeDay(new Date(), 7)));
        System.out.println(datetimeString2(nextDay(new Date(), 7)));
    }
}
