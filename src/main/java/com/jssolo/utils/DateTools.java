package com.jssolo.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 日期/时间处理工具
 */
public class DateTools {

    /** 一分钟的秒数 1000 */
    private static final long SECONDS_MS = 1000L;
    /** 一分钟的毫秒数 60 * 1000 */
    private static final long MINUTE_MS = 60000L;
    /** 一小时的毫秒数 60 * 60 * 1000 */
    private static final long HOUR_MS = 3600000L;
    /** 一天的毫秒数 24 * 60 * 60 * 1000 */
    private static final long DAY_MS = 86400000L;
    /** 时间格式化格式 */
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 分割时间方法，使用示例可访问:<a href="https://www.jssolo.com/java/9">https://www.jssolo.com/java/9</a>
     * @author ZYan
     * @param dateType 分割类型 M/D/H/N/S 对应月/天/小时/分钟/秒
     * @param begin 开始时间
     * @param end 结束时间
     * @param space 间隔长度
     * @param isAddEnd 最后一个是否添加end参数
     * @return 返回分割后的时间集合
     */
    public static List<String> splitTime(String dateType, String begin, String end, Integer space, boolean isAddEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date beginD = null;
        Date endD = null;
        try {
            beginD = sdf.parse(begin);
            endD = sdf.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<String> listDate = new ArrayList<>();
        listDate.add(new SimpleDateFormat(DATE_FORMAT).format(beginD));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(beginD);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endD);
        while (calEnd.after(calBegin)) {
            if ("M".equals(dateType)){
                calBegin.add(Calendar.MONTH, space);
            }
            if ("D".equals(dateType)){
                calBegin.add(Calendar.DATE, space);
            }
            if ("H".equals(dateType)){
                calBegin.add(Calendar.HOUR, space);
            }
            if ("N".equals(dateType)){
                calBegin.add(Calendar.MINUTE , space);
            }
            if ("S".equals(dateType)){
                calBegin.add(Calendar.SECOND , space);
            }
            if (calEnd.after(calBegin)){
                listDate.add(new SimpleDateFormat(DATE_FORMAT).format(calBegin.getTime()));
            }
            else{
                if(isAddEnd){
                    listDate.add(new SimpleDateFormat(DATE_FORMAT).format(calEnd.getTime()));
                }
            }
        }
        return listDate;
    }

    /**
     * 对指定日期偏移指定的天数
     * @author ZYan
     * @param date 日期参数
     * @param dayNum 天数的偏移量，正数为增加，负数为减去
     * @return 处理后的日期
     */
    public static Date dateAddDay(Date date, Integer dayNum){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,dayNum);
        return calendar.getTime();
    }

    /**
     * 对指定日期偏移指定的天数
     * @author ZYan
     * @param date 日期参数
     * @param dayNum 天数的偏移量，正数为增加，负数为减去
     * @return 处理后的日期
     */
    public static Date dateAddDay(Date date, Double dayNum){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int ms = (int) (dayNum * DAY_MS);
        calendar.add(Calendar.MILLISECOND, ms);
        return calendar.getTime();
    }


    /**
     * 对指定日期偏移指定的小时
     * @author ZYan
     * @param date 日期参数
     * @param hour 小时的偏移量，正数为增加，负数为减去
     * @return 处理后的时间
     */
    public static Date dateAddHour(Date date, Integer hour){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,hour);
        return calendar.getTime();
    }

    /**
     * 对指定日期偏移指定的小时
     * @author ZYan
     * @param date 日期参数
     * @param hour 小时的偏移量，正数为增加，负数为减去
     * @return 处理后的时间
     */
    public static Date dateAddHour(Date date, Double hour){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int ms = (int) (hour * HOUR_MS);
        calendar.add(Calendar.MILLISECOND, ms);
        return calendar.getTime();
    }

    /**
     * 判断时间大小，如果第一个时间大于第二个时间返回TRUE，当小于等于时返回FALSE
     * @author ZYan
     * @param first 第一个时间参数
     * @param last 第二个时间参数
     * @return java.lang.Boolean
     */
    public static Boolean firstIsBig(Date first, Date last){
        return first.after(last);
    }

    /**
     * 判断时间大小，参与判断的时间是第一个时间，与第二个时间加指定的偏移量(小时)，正数为加，负数为减
     * @author ZYan
     * @param first 第一个时间参数
     * @param last 第二个时间参数
     * @param hour 第二个时间偏移小时数
     * @return 如果第一个时间大于第二个时间加偏移量返回TRUE，当小于等于时返回FALSE
     */
    public static Boolean firstIsBigAddHour(Date first, Date last, Integer hour){
        Date temp = dateAddHour(last,hour);
        return firstIsBig(first,temp);
    }

    /**
     * 判断时间大小，参与判断的时间是第一个时间，与第二个时间加指定的偏移量(小时)，正数为加，负数为减
     * @author ZYan
     * @param first 第一个时间参数
     * @param last 第二个时间参数
     * @param hour 第二个时间偏移小时数
     * @return 如果第一个时间大于第二个时间加偏移量返回TRUE，当小于等于时返回FALSE
     */
    public static Boolean firstIsBigAddHour(Date first, Date last, Double hour){
        Date temp = dateAddHour(last,hour);
        return firstIsBig(first,temp);
    }

    /**
     * Date类型转String类型
     * @author ZYan
     * @param date Date类型的时间参数
     * @param format 转换格式，例如 yyyy-MM-dd HH:mm:ss
     * @return 处理后的String对象
     */
    public static String dateToString(Date date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * String类型转Date类型
     * @author ZYan
     * @param dateStr String类型的时间参数
     * @param format 转换格式，例如 yyyy-MM-dd HH:mm:ss
     * @return 处理后的Date对象
     */
    public static Date stringToDate(String dateStr, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeExceptionOnly("com.jssolo.utils.TimeTool.stringToDate()方法出现异常");
        }
    }

    /**
     * 计算两日期之间相差多少毫秒
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @return 两日期之间相差的毫秒数
     */
    public static BigDecimal dateDiffMs(Date d1, Date d2){
        return new BigDecimal(d1.getTime() - d2.getTime()).abs();
    }

    /**
     * 计算两日期之间相差多少秒
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @return 两日期之间相差的秒数，默认精确到两位，采用四舍五入
     */
    public static BigDecimal dateDiffSeconds(Date d1, Date d2){
        return dateDiff(d1,d2, SECONDS_MS,2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的分钟数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @return 两日期之间的分钟数，默认精确到两位，采用四舍五入
     */
    public static BigDecimal dateDiffMinutes(Date d1, Date d2){
        return dateDiff(d1,d2, MINUTE_MS,2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的分钟数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @param i 精确位数
     * @return 两日期之间的分钟数，采用四舍五入
     */
    public static BigDecimal dateDiffMinutes(Date d1, Date d2, int i){
        return dateDiff(d1,d2, MINUTE_MS, i, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的小时数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @return 两日期之间的小时差，默认精确到两位，采用四舍五入
     */
    public static BigDecimal dateDiffHours(Date d1, Date d2){
        return dateDiff(d1,d2, HOUR_MS,2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的小时数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @param i 精确位数
     * @return 两日期之间的小时差，采用四舍五入
     */
    public static BigDecimal dateDiffHours(Date d1, Date d2, int i){
        return dateDiff(d1,d2, HOUR_MS, i, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的天数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @return 两日期之间的天数，默认精确到两位，采用四舍五入
     */
    public static BigDecimal dateDiffDays(Date d1, Date d2){
        return dateDiff(d1,d2, DAY_MS,2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算两日期之间的天数
     * @author ZYan
     * @param d1 日期参数
     * @param d2 日期参数
     * @param i 精确位数
     * @return 两日期之间的天数，采用四舍五入
     */
    public static BigDecimal dateDiffDays(Date d1, Date d2, int i){
        return dateDiff(d1,d2, DAY_MS, i, BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal dateDiff(Date d1, Date d2, long l, int i1, int i2){
        BigDecimal b1 = new BigDecimal(d1.getTime() - d2.getTime()).abs();
        BigDecimal b2 = new BigDecimal(l);
        BigDecimal b3 = b1.divide(b2, i1, i2);
        return b3;
    }

    /**
     * 通过日期获取对应周几
     * @author ZYan
     * @param date 日期参数
     * @return 返回日期对应的周几
     */
    public static String dateToWeek(Date date) {
        String[] weekDays = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return dateToWeek(date,weekDays);
    }

    /**
     * 通过日期获取对应周几 可自定义星期的格式
     * @author ZYan
     * @param date 日期参数
     * @param weekDays 自定义星期的数组，长度必须是7，以星期天开头
     * @return 返回日期对应的周几 此处返回的为自定义的星期格式
     */
    public static String dateToWeek(Date date, String[] weekDays) {
        if(weekDays == null){
            throw new RuntimeExceptionOnly("com.jssolo.utils.TimeTool.dateToWeek() weekDays 是空的");
        }
        if(weekDays.length != 7){
            throw new RuntimeExceptionOnly("com.jssolo.utils.TimeTool.dateToWeek() weekDays 长度不为7");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            throw new RuntimeExceptionOnly("com.jssolo.utils.TimeTool.dateToWeek() 周号获取异常");
        }
        return weekDays[w];
    }

    /**
     * 通过时间转换成时间戳，使用系统默认时区
     * @author ZYan
     * @param dateStr 时间字符串
     * @return java.lang.Long
     */
    public static long toTimestamp(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());
        long timestamp = zonedDateTime.toInstant().toEpochMilli() / 1000;
        return timestamp;
    }

    /**
     * 通过时间转换成时间戳，使用UTC
     * @author ZYan
     * @param dateStr 时间字符串
     * @return java.lang.Long
     */
    public static long toUTCTimestamp(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
        ZonedDateTime utcZonedDateTime = dateTime.atZone(ZoneId.of("UTC"));
        long timestamp = utcZonedDateTime.toInstant().toEpochMilli() / 1000;
        return timestamp;
    }


}
