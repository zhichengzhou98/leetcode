package com.zzc.leetcode_jul;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-12 9:36
 */
public class NumberGame {
  public int[] numberGame(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ) {
      int temp = nums[i];
      nums[i] = nums[i + 1];
      nums[i + 1] = temp;
      i += 2;
    }
    return nums;
  }
}
