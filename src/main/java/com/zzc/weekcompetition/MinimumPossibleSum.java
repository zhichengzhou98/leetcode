package com.zzc.weekcompetition;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 10:38
 */
public class MinimumPossibleSum {
    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(16, 6));
    }
    public static long minimumPossibleSum(int n, int target) {
        int[] res = new int[n];
        res[0] = 1;
        int min = 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(target - res[0]);
        for (int i = 1; i < res.length; i++) {
            while (set.contains(min)) {
                min++;
            }
            res[i] = min;
            set.add(target - min);
            min++;

        }
        long sum = 0L;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }
}
