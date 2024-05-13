package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description 滑动窗口
 * @create 2024-05-13 14:40
 */
public class MinSubArrayLen {

    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int left = 0;
        int sum = 0;
        //枚举右端点
        for (int right = 0; right < nums.length; right++) {
            sum+= nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                res = Math.min(res, right -left + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
