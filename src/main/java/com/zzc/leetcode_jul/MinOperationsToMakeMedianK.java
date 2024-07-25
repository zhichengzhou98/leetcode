package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-25 16:39
 */
public class MinOperationsToMakeMedianK {

  @Test
  void testFun() {
    int[] arr = {2,5,6,8,5};
    System.out.println(minOperationsToMakeMedianK(arr, 4));
  }
  public long minOperationsToMakeMedianK(int[] nums, int k) {
    long res = 0L;
    //升序排列
    Arrays.sort(nums);
    //数组长度为奇数
    //中位数所在的所有为
    int middleIndex = nums.length / 2;
    //中位数为
    int middle = nums[middleIndex];
    if (k == middle) {
      return res;
    } else if (k > middle) {
      //需要增幅数值
      for (int i = middleIndex; i < nums.length; i++) {
        if (k <= nums[i]) {
          return res;
        }
        res += Math.max(0, k - nums[i]);
      }
    } else {
      //需要增幅数值
      for (int i = middleIndex; i >= 0; i--) {
        if (nums[i] <= k) {
          return res;
        }
        res += Math.max(0, nums[i] - k);
      }
    }
    return res;
  }
}
