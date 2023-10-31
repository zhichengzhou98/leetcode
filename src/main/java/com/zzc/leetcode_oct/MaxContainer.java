package com.zzc.leetcode_oct;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-30 17:56
 */
public class MaxContainer {
    @Test
    public void test() {
        System.out.println(maxContainer(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxContainer(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while (r > l) {
            int highL = nums[l];
            int highR = nums[r];
            max = Math.max(max, Math.min(highR, highL) * (r - l));
            if (highR >= highL) {
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
