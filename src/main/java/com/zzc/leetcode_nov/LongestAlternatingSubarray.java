package com.zzc.leetcode_nov;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-16 22:57
 */
public class LongestAlternatingSubarray {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int l = 0;
        int r = 0;
        while (l < nums.length && r < nums.length) {
            while (l < nums.length && !(nums[l] % 2 == 0 && nums[l] <= threshold)) {
                l++;
            }
            if (l == nums.length) {
                return res;
            }
            r = l + 1;
            while (r < nums.length && nums[r]%2 != nums[r-1]%2 && nums[r]<= threshold) {
                r++;
            }
            res = Math.max(res, r - l);
            l = r;
        }
        return res;
    }
}
