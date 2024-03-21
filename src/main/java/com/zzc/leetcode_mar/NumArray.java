package com.zzc.leetcode_mar;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-18 21:24
 */
public class NumArray {

    int[] nums;
    int[] preSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right] - preSum[left] + nums[left];
    }
}
