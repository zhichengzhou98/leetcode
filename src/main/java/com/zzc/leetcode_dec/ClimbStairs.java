package com.zzc.leetcode_dec;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-10 11:59
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i -1] + res[i-1];
        }
        return res[n];
    }
}
