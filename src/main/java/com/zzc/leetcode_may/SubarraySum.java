package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description 滑动窗口，不定长滑窗
 * @create 2024-05-13 15:53
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //TODO
        }

        return 0;
    }
}
