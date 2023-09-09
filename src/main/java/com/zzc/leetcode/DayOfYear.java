package com.zzc.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-21 21:56
 */
public class DayOfYear {
    public static void main(String[] args) {
        System.out.println(new DayOfYear().dayOfYear("2019-01-09"));
    }

    public int dayOfYear(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return instance.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
