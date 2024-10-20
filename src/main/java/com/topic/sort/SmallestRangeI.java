package com.topic.sort;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 908. 最小差值 I
 * @create 2024-10-20 08:08
 */
public class SmallestRangeI {
  public int smallestRangeIV1(int[] nums, int k) {
    if (nums.length == 1) {
      return 0;
    }
    Arrays.sort(nums);
    int max = nums[nums.length - 1] - k;
    int min = nums[0] + k;
    return min >= max ? 0 : max - min;
  }

  public int smallestRangeI(int[] nums, int k) {
    if (nums.length == 1) {
      return 0;
    }
    int max = nums[0];
    int min = nums[0];
    for(int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    max -= k;
    min += k;
    return min >= max ? 0 : max - min;
  }
}
