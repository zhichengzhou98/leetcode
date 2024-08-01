package com.zzc.leetcode_jul;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2567 修改两个元素的最小分数 o(n) 记录最小和最大的3个数
 * @create 2024-08-01 17:10
 */
public class MinimizeSum {
  public int minimizeSum(int[] nums) {
    Arrays.sort(nums);
    //改最后两个数
    int temp1 = nums[nums.length - 3] - nums[0];
    //改最前面两个数
    int temp2 = nums[nums.length - 1] - nums[2];
    int res = Math.min(temp2, temp1);
    //改前后各一个数
    int temp3= nums[nums.length - 2] - nums[1];
    return Math.min(res, temp3);
  }
}
