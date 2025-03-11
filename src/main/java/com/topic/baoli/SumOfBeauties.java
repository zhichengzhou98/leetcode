package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2012. 数组美丽值求和
 * @create 2025-03-11 21:03
 */
public class SumOfBeauties {
  public int sumOfBeauties(int[] nums) {
    int[] preMax = new int[nums.length];
    int max = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      preMax[i] = max;
      max = Math.max(nums[i], max);
    }
    int[] sufMax = new int[nums.length];
    int min = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 1; i--) {
      sufMax[i] = min;
      min = Math.min(min, nums[i]);
    }
    int res = 0;
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i] > preMax[i] && nums[i] < sufMax[i]) {
        res += 2;
      } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
        res += 1;
      }
    }
    return res;
  }
}
