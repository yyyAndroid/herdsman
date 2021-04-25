package com.arcfun.library.kotlin;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 2016/8/16.
 */
public class TimeUtils {
    /**
     * 某天开始时分秒字符串常量  00:00:00
     */
    public static final String DAY_BEGIN_STRING_HHMMSS = " 00:00:00";
    /**
     * 某天结束时分秒字符串常量  23:59:59
     */
    public static final String DAY_END_STRING_HHMMSS = " 23:59:59";
    static Calendar calendar = Calendar.getInstance();

    public static String compareDate(Date date1, Date date2) {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        df.format(date1);
//        df.format(date2);
        long l = date1.getTime() - date2.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        return day + "天" + hour + "小时" + min + "分" + s + "秒";
    }

    public static int getValidDay(Long timeStamp) {
        Date date1 = new Date(timeStamp * 1000);
        Date date2 = new Date();
        long l = date1.getTime() - date2.getTime();
        if (l <= 0) {
            return 0;
        }
        return (int) (l / (24 * 60 * 60 * 1000) + 1);
    }

    public static String getTodayTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar mOrderCalendar = (Calendar) calendar.clone();
        Date currentdate = mOrderCalendar.getTime();
        return df.format(currentdate);
    }

    public static String getTodayTimeAll() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar mOrderCalendar = (Calendar) calendar.clone();
        Date currentdate = mOrderCalendar.getTime();
        return df.format(currentdate);
    }

    public static String getTodayMouth() {
        DateFormat df = new SimpleDateFormat("MM/dd");
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar mOrderCalendar = (Calendar) calendar.clone();
        Date currentdate = mOrderCalendar.getTime();
        return "今天" + df.format(currentdate);
    }

    public static String getToday() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar mOrderCalendar = (Calendar) calendar.clone();
        Date currentdate = mOrderCalendar.getTime();
        return df.format(currentdate) + "(今天)";
    }

    public static String getTimeMinute(String time) {
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeAndMinute(String time) {
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeAndMinuteChinese(String time) {
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("MM月dd日 HH:mm");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeDate(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getTimeDateHourAndMin(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getTimeHour(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("HH");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return df.format(now);
    }

    public static String getTimeMin(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        time = time.replace("T", "");
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df2 = new SimpleDateFormat("mm");
        try {
            Date timeDate = df.parse(time);
            return df2.format(timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getTimeWhole(String date, String Hour, String Min) {
        try {
            return date + " " + Hour + ":" + Min + ":00";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static long getTimeCompareToDat(String dateTime) {
        String time = dateTime.replace("T", "");
        SimpleDateFormat SDF_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        try {
            Date chooseTime = SDF_DATE_FORMAT.parse(time);
            Date now = new Date(System.currentTimeMillis());
            long diff = now.getTime() - chooseTime.getTime();
            long minutes = diff / (1000 * 60);
            return minutes;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getTimeStamp(String dateTime) {
        String time = dateTime.replace("T", "");
        SimpleDateFormat SDF_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        try {
            Date chooseTime = SDF_DATE_FORMAT.parse(time);
            return chooseTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getMiuiRecordTimeStamp(String dateTime) {
        SimpleDateFormat SDF_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date chooseTime = SDF_DATE_FORMAT.parse(dateTime);
            return chooseTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDayCompareToDay(String dateTime) {
        SimpleDateFormat SDF_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date chooseTime = SDF_DATE_FORMAT.parse(dateTime);
            Date now = new Date(System.currentTimeMillis());
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(now);
            cal2.setTime(chooseTime);
            int day = (int) cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR);
            if (day == 0) {
//                SimpleDateFormat sdf = new SimpleDateFormat("(MM/dd)");
//                String time = sdf.format(chooseTime);
                return dateTime + "(今天)";
            } else if (day == 1) {
//                SimpleDateFormat sdf = new SimpleDateFormat("(MM/dd)");
//                String time = sdf.format(chooseTime);
                return dateTime + "(明天)";
            } else if (day == 2) {
//                SimpleDateFormat sdf = new SimpleDateFormat("(MM/dd)");
//                String time = sdf.format(chooseTime);
                return dateTime + "(后天)";
            } else {
//                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
//                String time = sdf.format(chooseTime);
                return dateTime;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return dateTime.substring(5).replace("-", "/");
        }
    }

    public static boolean isSameDay(Date date) {

        if (null == date) {

            return false;

        }

        Date now = new Date(System.currentTimeMillis());
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);
        Calendar dateCalendar = Calendar.getInstance();

        dateCalendar.setTime(date);

        if (nowCalendar.get(Calendar.YEAR) == dateCalendar.get(Calendar.YEAR)

                && nowCalendar.get(Calendar.MONTH) == dateCalendar.get(Calendar.MONTH)

                && nowCalendar.get(Calendar.DATE) == dateCalendar.get(Calendar.DATE)) {

            return true;

        }

        return false;

    }

    public static String timestampTodate(String timestamp) {
        Date date = new Date(Long.valueOf(timestamp + "000"));
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        return df.format(date);
    }

    public static String timestampTodate_(String timestamp) {
        Date date = new Date(Long.valueOf(timestamp + "000"));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static String timestampTodate_WithHour(String timestamp) {
        Date date = new Date(Long.valueOf(timestamp + "000"));
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");

        return df.format(date);
    }

    public static String timestampTodateAndWeek_(String timestanp) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Date date = new Date(Long.valueOf(timestanp + "000"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat df = new SimpleDateFormat("MM-dd");
        String s = df.format(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return s + "(" + weekDays[w] + ")";
    }

    public static String getNextDay(String day) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = dateFormat.parse(day);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            return dateFormat.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return day;
        }
    }


    public static int getCurrentHour() {

        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getCurrentMin() {

        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MINUTE);
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14  16:09:00"）
     *
     * @param time
     * @return
     */
    public static String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(lcc));
        return times;

    }

    /**
     * 根据开始结束时间 返回预约时间区间
     * 返回 某月某日 12:00～14:00
     */
    public static String arrivalTime(String startTime, String endTime) {
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        DateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
        DateFormat df1 = new SimpleDateFormat("HH:mm");

        try {
            if (!TextUtils.isEmpty(startTime) && !TextUtils.isEmpty(endTime)) {
                return df.format(df2.parse(startTime.replace("T", "")))
                        + "～" + df1.format(df2.parse(endTime.replace("T", "")));
            } else if (!TextUtils.isEmpty(startTime)) {
                return df.format(df2.parse(startTime.replace("T", "")));
            } else if (!TextUtils.isEmpty(endTime)) {
                return df.format(df2.parse(endTime.replace("T", "")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前时间 格式：yyyyMMddHHmmss
     */
    public static long getSystemTime() {
        //("yyyy年MM月dd日 HH时MM分ss秒"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        long times = System.currentTimeMillis();
        System.out.println(times);
        Date date = new Date(times);
        String time = sdf.format(date);
        System.out.println(time);
        long timeint = 0;
        try {
            timeint = Long.valueOf(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeint;
    }

    public static long compatibilityFormat(String timeString) {

        SimpleDateFormat simple3 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat simple2 = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        try {
            Date d1 = simple2.parse(timeString);
            date.setHours(d1.getHours());
            date.setMinutes(d1.getMinutes());
            date.setSeconds(d1.getSeconds());
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date d1 = simple3.parse(timeString);
            date.setHours(d1.getHours());
            date.setMinutes(d1.getMinutes());
            date.setSeconds(d1.getSeconds());
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
