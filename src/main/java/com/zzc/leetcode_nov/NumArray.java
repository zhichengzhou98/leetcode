package com.zzc.leetcode_nov;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-13 21:15
 */
public class NumArray {
    int[] nums;
    int[] preSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        int temp = this.nums[index];
        this.nums[index] = val;
        for (int i = index + 1; i < preSum.length; i++) {
            preSum[i] = preSum[i] + val - temp;
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
