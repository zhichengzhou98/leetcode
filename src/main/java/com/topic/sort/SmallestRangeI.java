package com.topic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 908. 最小差值 I / 910. 最小差值 II
 * @create 2024-10-20 08:08
 */
public class SmallestRangeI {
  @Test
  void testFun() {
    int[] nums = {3,1,10};
    System.out.println(smallestRangeII(nums, 4));
  }

  public int smallestRangeII(int[] nums, int k) {
    int size = nums.length;
    Arrays.sort(nums);
    int res = nums[size - 1] - nums[0];
    for (int i = 0; i < size - 1; i++) {
      //从小于等于i的索引位置的元素都增大k 大于等于i+1位置的元素的减小k
      //最大的元素
      int mx = Math.max(nums[i] + k, nums[size - 1] -k);
      //最小的元素
      int mi = Math.min(nums[0] + k, nums[i + 1] -k);
      res = Math.min(res, mx - mi);
    }
    return res;
  }

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
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    max -= k;
    min += k;
    return min >= max ? 0 : max - min;
  }
}
