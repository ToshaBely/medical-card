package com.bsu.bely.medical.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date addMonth(Date date, int monthCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthCount);
        return calendar.getTime();
    }

    public static Date getBeginOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.add(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }
}
