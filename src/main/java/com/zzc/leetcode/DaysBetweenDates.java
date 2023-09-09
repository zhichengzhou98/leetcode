package com.zzc.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-22 17:09
 */
public class DaysBetweenDates {
    public static void main(String[] args) {

    }

    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long diff = 0;
        try {
            diff = dateFormat.parse(date1).getTime() - dateFormat.parse(date2).getTime();
            return (int) (Math.abs(diff) / 1000 / 3600 / 24);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
