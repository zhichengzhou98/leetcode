package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-10 11:28
 */
public class IncremovableSubarrayCount {
  @Test
  void testFun() {
    System.out.println(incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
  }


  //o(n³)
  public int incremovableSubarrayCount(int[] nums) {
    int res = 0;
    for (int i = 1; i <= nums.length; i++) {
      //移除元素的个数i
      for (int j = 0; j + i - 1 < nums.length; j++) {
        //从第j个元素开始移除
        // j, j + 1, ..., j + i - 1 被移除。
        if (checkNum(nums, j, j + i - 1)) {
          res++;
        }
      }
    }
    return res;
  }

  private boolean checkNum(int[] nums, int begin, int end) {
    for (int i = 1; i < begin; i++) {
      if (nums[i] <= nums[i - 1]) {
        return false;
      }
    }
    if (begin >= 1 && end + 1 < nums.length && nums[begin - 1] >= nums[end + 1]) {
      return false;
    }
    for (int i = end + 2; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        return false;
      }
    }
    return true;
  }
}
