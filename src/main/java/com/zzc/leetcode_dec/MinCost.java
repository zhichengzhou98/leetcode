package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-28 12:04
 */
public class MinCost {
    @Test
    public void test() {
        int[] arr = {31,25,18,59};
        System.out.println(minCost(arr, 27));
        int[] arr1 = {20, 1, 15};
        System.out.println(minCost(arr1, 5));
    }
    
    public long minCost(int[] nums, int x) {
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        long minRes = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            long temp = 0L;
            for (int j = 0; j < nums.length; j++) {
                copy[j] = Math.min(nums[(j + i) % len], copy[j]);
                temp += copy[j];
            }
            minRes = Math.min(temp + (long) x * i, minRes);
        }
        return minRes;
    }
}
