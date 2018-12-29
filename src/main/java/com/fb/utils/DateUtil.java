package com.fb.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LYZ
 * @create 2018/12/29 14:11
 **/
public class DateUtil {

    public DateUtil() {
    }

    /**
     * 计算传入的时间与当前时间相差多少秒
     * @param startDate 时间
     * @return 多少秒
     */
    public static int calLastedTimeSeconds(Date startDate) {
        long a = System.currentTimeMillis();
        long b = startDate.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }

    /**
     * 计算俩个时间段相差多少秒
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 多少秒
     */
    public static int calLastedTimeSeconds(Date startDate,Date endDate) {
        long a = endDate.getTime();
        long b = startDate.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }


    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取当前时间 yyyy-MM-dd HH:mm:ss (24小时制)
     * @return String 当前时间
     */
    public static String getNowDateString(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 按照对应格式获取当前时间
     * @param formatStr 格式化规则 如：yyyy-MM-dd ，  HH:mm:ss
     * @return String 当前时间
     */
    public static String getNowDateString(String formatStr){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    /**
     * 将字符串时间格式化成
     *
     * @param strDate  格式必须是yyyy-MM-dd HH:mm:ss,否则会返回null
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将字符串时间格式化成
     *
     * @param strDate  格式必须是yyyy-MM-dd HH:mm:ss,否则会返回null
     * @param  formatStr  格式化规则 如：yyyy-MM-dd ，  HH:mm:ss
     * @return
     */
    public static Date strToDate(String strDate,String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将对应Date按照yyyy-MM-dd HH:mm:ss格式化成string
     * @param date 传入的日期
     * @return   string date
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        String strDate = formatter.format(date);
        return strDate;
    }

    /**
     * 将对应Date按照格式化规则格式化成string
     * @param date 传入的日期
     *  @param formatStr 格式化规则 如：yyyy-MM-dd ，  HH:mm:ss
     * @return   string date
     */
    public static String dateToStr(Date date, String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        ParsePosition pos = new ParsePosition(0);
        String strDate = formatter.format(date);
        return strDate;
    }

    /**
     * 获取无间隔的当前时间字符串
     * @return
     */
    public static String getDateString(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取30天后的日期
     * @return
     */
    /*public static String getMonthDate() {
        //获取当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String endDate = sdf.format(today);//当前日期
        //获取三十天前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        theCa.add(theCa.DATE, +30); // +30天
        Date start = theCa.getTime();
        String startDate = sdf.format(start);//三十天之后日期
        return startDate;
    }*/

    /**
     * 获取相加目标天数之后得到的日期
     * @param srtDate
     * @param addNum
     * @return
     */
    public static String getDateAddDay(String srtDate, Integer addNum) {
        Date date = DateUtil.strToDate(srtDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 今天+1天
        c.add(Calendar.DAY_OF_MONTH, addNum);
        date = c.getTime();
        return DateUtil.dateToStr(date,"yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 获取相加目标天数之后得到的日期
     * @param strDate
     * @param addNum
     * @return
     */
    public static String getDateAddHour(String strDate, Integer addNum) {
        Date date = DateUtil.strToDate(strDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, addNum);
        date = c.getTime();
        return DateUtil.dateToStr(date,"yyyy-MM-dd HH:mm:ss");
    }

    public static  void  main(String []args){
        Date nowDate = DateUtil.getNowDate();
        String date = DateUtil.getDateAddDay("2018-01-06 13:14:12",30);
        System.out.println(nowDate);
    }

}
