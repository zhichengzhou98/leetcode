package com.zzc.leetcode;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 11:31
 */
public class MinStartValue {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
    }

    public static int minStartValue(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int min = res[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
            min = Math.min(min,res[i]);
        }
        return Math.max(1 - min, 1);
    }
}
