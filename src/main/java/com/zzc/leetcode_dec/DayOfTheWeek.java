package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-30 20:25
 */
public class DayOfTheWeek {
    @Test
    public void test() {
        System.out.println(dayOfTheWeek(1,1,2024));
        dayOfYear("1-1-1");

    }

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int[] months = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        if (month >= 3 && (year % 400 == 0 || (year % 4== 0 && year %100 != 0))) {
            return months[month] + day + 1;
        }
        return months[month] + day;
    }
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        LocalDate date = LocalDate.of(year, month, day);
        long milliseconds = date.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        long milli = LocalDate.of(2023, 12, 31).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        int deltDay = ((int) ((milliseconds - milli) / 1000 / 3600 / 24) % 7 + 7) % 7;
        return week[deltDay];
    }
}
