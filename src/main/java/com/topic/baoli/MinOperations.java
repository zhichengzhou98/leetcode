package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3191
 * @create 2024-10-18 11:23
 */
public class MinOperations {
  public int minOperations(int[] nums) {
    int res =0;
    int left = 0;
    while (true) {
      while ( left < nums.length && nums[left] == 1) {
        left++;
      }
      if (left == nums.length) {
        return res;
      }
      if (left + 2 >= nums.length) {
        return -1;
      }
      res++;
      nums[left + 1] = (1 - nums[left + 1]);
      nums[left + 2] = (1 - nums[left + 2]);
      left++;
    }
  }
}
