package com.zzc.leetcode_sep;

import com.zzc.leetcode_aug.FindKthLargest;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 18:02
 */
public class MinimumTime {
    public static void main(String[] args) {
        FindKthLargest MinimumTime = new FindKthLargest();
        Properties properties = new Properties();
        InputStream stream = FindKthLargest.class.getClassLoader().getResourceAsStream("testCase.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String arrayStr = (String) properties.get("array");
        String[] split = arrayStr.split(",");
        int[] array = Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        System.out.println(minimumTime(array,9765277));
        //System.out.println(1L/2);
    }

    public static long minimumTime(int[] time, int totalTrips) {
        int maxTime = Integer.MIN_VALUE;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            maxTime = Math.max(maxTime, time[i]);
            minTime = Math.min(minTime, time[i]);
        }
        List<Long> list = new ArrayList<>();
        long maxTrips = (long) maxTime * totalTrips;
        long minTrips = minTime;
        while (maxTrips > minTrips) {
            long res = (minTrips + maxTrips) / 2;
            long sumTrips = 0;
            for (int j = 0; j < time.length; j++) {
                sumTrips = sumTrips + (long) (res / time[j]);
            }
            if (sumTrips >= totalTrips) {
                list.add(res);
                maxTrips = res;
            } else {
                minTrips = res + 1;
            }
        }
        return list.stream().min(Long::compareTo).orElse(minTrips);
    }
}
