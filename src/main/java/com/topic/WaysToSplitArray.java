package com.topic;

/**
 * @author zc.zhou
 * @Description 2270.分割数组的方案数
 * @create 2025-01-13 16:25
 */
public class WaysToSplitArray {
  public int waysToSplitArray(int[] nums) {
    int res = 0;
    long sum = 0;
    for(int num : nums) {
      sum += num;
    }
    long tmpSum = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      tmpSum += nums[i];
      if (tmpSum >= sum - tmpSum) {
        res++;
      }
    }
    return res;
  }
}
