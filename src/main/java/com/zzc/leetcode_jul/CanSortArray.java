package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-13 12:37
 */
public class CanSortArray {
  @Test
  void testFun() {
    System.out.println(canSortArray(new int[]{20, 16}));
  }
  public boolean canSortArray(int[] nums) {
    return canSortArrayAsc(nums);
  }

  //能否升序
  public boolean canSortArrayAsc(int[] nums) {
    int preMax = Integer.MIN_VALUE;
    int left = 0;
    while (left < nums.length) {
      int max = nums[left];
      int min = nums[left];
      int currentBitOne = Integer.bitCount(nums[left]);
      int right = left + 1;
      while (right < nums.length && Integer.bitCount(nums[right]) == currentBitOne) {
        max = Math.max(max, nums[right]);
        min = Math.min(min, nums[right]);
        right++;
      }
      //判断是否递增
      if (min < preMax) {
        return false;
      }
      preMax = max;
      if (right == nums.length) {
        return true;
      } else {
        left = right;
      }
    }
    return true;
  }

  //能否降序
  public boolean canSortArrayDesc(int[] nums) {
    int preMin = Integer.MAX_VALUE;
    int left = 0;
    while (left < nums.length) {
      int max = nums[left];
      int min = nums[left];
      int currentBitOne = Integer.bitCount(nums[left]);
      int right = left + 1;
      while (right < nums.length && Integer.bitCount(nums[right]) == currentBitOne) {
        max = Math.max(max, nums[right]);
        min = Math.min(min, nums[right]);
        right++;
      }
      //判断是否递增
      if (max > preMin) {
        return false;
      }
      preMin = min;
      if (right == nums.length) {
        return true;
      } else {
        left = right;
      }
    }
    return true;
  }
}
