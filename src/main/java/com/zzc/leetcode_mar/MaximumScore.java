package com.zzc.leetcode_mar;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-19 21:27
 */
public class MaximumScore {
    public int maximumScore(int[] nums, int k) {
        int left = k;
        int right = k;
        int minNum = nums[k];
        int res = minNum;
        while (left > 0 || right < nums.length - 1) {
            int target = 0;
            if (left > 0 && right < nums.length - 1) {
                int pre = nums[left - 1];
                int next = nums[right + 1];
                target = Math.max(pre, next);
                if (next >= pre) {
                    right++;
                } else {
                    left--;
                }
            } else if (left > 0) {
                left--;
                target = nums[left];
            } else if (right < nums.length - 1){
                right++;
                target = nums[right];
            }

            minNum = Math.min(minNum, target);
            res = Math.max(res, minNum * (right - left + 1));
        }
        return res;
    }
}
