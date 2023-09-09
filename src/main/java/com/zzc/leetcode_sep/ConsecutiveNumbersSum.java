package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-07 21:20
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(15));
    }

    public static int consecutiveNumbersSum(int n) {
        long max =(long) Math.sqrt(2 * n +1) +1;
        long min = 1;
        int res = 0;
        for (long i = min; i <= max; i++) {
            long fenZi = 2L * n + i - i * i;
            if (fenZi > 0 && fenZi % (2 * i) ==0) {
                res++;
            }
        }

        return res;
    }
}
