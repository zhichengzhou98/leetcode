package com.zzc.leetcode_sep;

import com.zzc.leetcode_aug.FindKthLargest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author zc.zhou
 * @Description 2594. 修车的最少时间
 * @create 2023-09-07 11:57
 */
public class RepairCars {
    public static void main(String[] args) {
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
        //System.out.println(repairCars(array, 292126));
        System.out.println(repairCars(new int[]{4,2,3,1}, 10));
    }

    public static long repairCars(int[] ranks, int cars) {
        int maxRank = Integer.MIN_VALUE;
        int minRank = Integer.MAX_VALUE;
        for (int i = 0; i < ranks.length; i++) {
            maxRank = Math.max(maxRank, ranks[i]);
            minRank = Math.min(minRank, ranks[i]);
        }
        //double r = Math.min(minRank * (double)cars * cars, Long.MAX_VALUE);
        int a = cars % ranks.length == 0 ?cars / ranks.length :cars / ranks.length +1;

        double r = (a) * ((double) (a) * maxRank);
        double l = 1;
        double med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, cars, ranks)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return (long) med;
    }

    public static boolean checkMed(double med, int cars, int[] ranks) {
        long car = 0;
        for (int i = 0; i < ranks.length; i++) {
            car = car + (long) Math.sqrt((med / ranks[i]));
        }
        return car >= cars;
    }


}
