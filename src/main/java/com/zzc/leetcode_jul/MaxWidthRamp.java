package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-31 20:59
 */
public class MaxWidthRamp {
  public int maxWidthRamp(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] >= nums[i]) {
          res = Math.max(res, j - i);
          break;
        }
      }
    }
    return res;
  }
}
