package com.zzc.leetcode;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-21 22:17
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        String s = dayOfTheWeek.dayOfTheWeek(31, 8, 2019);
        String s1 = dayOfTheWeek.dayOfTheWeekByApi(31, 8, 2019);
        System.out.println(s+"===="+s1);
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        long time = new Date(2023-1900, 6 ,21).getTime();
        long time1 = new Date(year - 1900, month - 1, day).getTime();
        if (time1 > time) {
            long delt = time1 - time;
            int l = (int) (delt / 1000 / 3600 / 24);

            return weeks[(5 + (l%7) + 7)%7];
        }
        long delt = time - time1;
        int l = (int) (delt / 1000 / 3600 / 24);

        return weeks[(5 - (l%7) + 7)%7];
    }

    public String dayOfTheWeekByApi(int day, int month, int year) {
        String[] weeks = {"", "Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);// 0-11
        return weeks[calendar.get(Calendar.DAY_OF_WEEK)];
    }
}
