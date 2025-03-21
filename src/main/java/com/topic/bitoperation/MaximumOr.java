package com.topic.bitoperation;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2025-03-21 21:16
 */
public class MaximumOr {
  @Test
  void testFun() {
    int[] arr = {8, 1, 2};
    for (int i : arr) {
      System.out.println(i + ": " + Integer.toBinaryString(i));
    }
    System.out.println(maximumOr(arr, 2));
  }

  public long maximumOr(int[] nums, int k) {
    int n = nums.length;
    long[] suf = new long[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      suf[i] = suf[i + 1] | nums[i];
    }
    long res = 0, pre = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, pre | ((long) nums[i] << k) | suf[i + 1]);
      pre |= nums[i];
    }
    return res;
  }

}
