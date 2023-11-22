package com.zzc.leetcode_nov;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-18 18:40
 */
public class MaximumStrongPairXor {
    public static void main(String[] args) {
        System.out.println(100 ^ 10);
    }
    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int y = nums[j];
                int minY = (x + 1) / 2;
                if (y < minY) {
                    break;
                }
                res = Math.max(res, x ^ y);
            }
        }
        return res;
    }
}
