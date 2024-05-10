package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-10 22:42
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }
}
