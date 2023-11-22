package com.zzc.leetcode_nov;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-20 12:11
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //0: 不取， 1: 不取
        int[][] res = new int[nums.length][2];
        int len = nums.length-1;
        res[0][0] = Integer.MIN_VALUE;
        res[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i][0] = Math.max(res[i-1][0], res[i-1][1]);
            res[i][1] = Math.max(nums[i], res[i-1][1] + nums[i]);
        }
        return Math.max(res[len][0], res[len][1]);
    }
}
