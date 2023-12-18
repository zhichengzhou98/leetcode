package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-17 18:14
 */
public class MinimumCost {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            int leftIndex = nums.length / 2 -1;
            int rightIndex = nums.length / 2;
            Integer a = findPalindromeNumber(nums[leftIndex], nums[rightIndex], true);
            if (a != null) {
                return res(nums, a);
            }
            Integer b = findPalindromeNumber(1, nums[leftIndex], false);
            Integer c = findPalindromeNumber(nums[rightIndex], (int) Math.pow(10, 9), true);
            return Math.min(res(nums, b), res(nums, c));
        }
        int middleIndex = nums.length / 2;
        Integer b = findPalindromeNumber(1, nums[middleIndex], false);
        Integer c = findPalindromeNumber(nums[middleIndex], (int) Math.pow(10, 9), false);
        return Math.min(res(nums, b), res(nums, c));
    }
    
    public long res(int[] num, Integer target) {
        if (target == null) {
            return Long.MAX_VALUE;
        }
        long res = 0L;
        for (int i = 0; i < num.length; i++) {
            res += Math.abs(target - num[i]);
        }
        return res;
    }

    public Integer findPalindromeNumber (int left, int right, boolean flag) {
        if (flag) {
            for (int i = left; i <= right ; i++) {
                if (judgePalindromeNumber(i)) {
                    return i;
                }
            }
        }else {
            for (int i = right; i >= left ; i--) {
                if (judgePalindromeNumber(i)) {
                    return i;
                }
            }
        }
        return null;
    }

    public boolean judgePalindromeNumber(int num) {
        String s1 = new StringBuilder().append(num).reverse().toString();
        return s1.equals(String.valueOf(num));
    }

    @Test
    public void test() {
        int[] testArr = new int[]{301,309,312,322};
        System.out.println(minimumCost(testArr));
        System.out.println(judgePalindromeNumber(5));
    }
}
