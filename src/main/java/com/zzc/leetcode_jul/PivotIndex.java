package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-08 13:20
 */
public class PivotIndex {
  @Test
  void testFun() {
    System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
  }

  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int leftSum = 0;
    int rightSum = sum;
    int res = 0;
    while (res < nums.length) {
      rightSum -= nums[res];
      if (leftSum == rightSum) {
        return res;
      } else {
        leftSum += nums[res];
        res++;
      }
    }
    return -1;
  }

}
