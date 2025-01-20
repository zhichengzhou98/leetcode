package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2239.找到最接近0的数字
 * @create 2025-01-20 8:52
 */
public class FindClosestNumber {
  public int findClosestNumber(int[] nums) {
    int res = nums[0];
    int num = Math.abs(res);
    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(nums[i]) < num) {
        num = Math.abs(nums[i]);
        res = nums[i];
      }else if (Math.abs(nums[i]) == num) {
        res = Math.max(res, nums[i]);
      }
    }
    return res;
  }
}
