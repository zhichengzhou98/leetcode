package com.topic.bitoperation;

/**
 * @author zc.zhou
 * @Description 3171. 找到按位或最接近 K 的子数组
 * @create 2024-10-09 9:19
 */
public class MinimumDifference {

  //o(n²)
  public int minimumDifferenceV1(int[] nums, int k) {
    int res = Integer.MAX_VALUE;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int current = nums[i];
      for (int j = i; j < size; j++) {
        current |= nums[j];
        res = Math.min(res, Math.abs(k - current));
      }
    }
    return res;
  }

  //o(n²)
  public int minimumDifferenceV2(int[] nums, int k) {
    int res = Integer.MAX_VALUE;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int current = nums[i];
      res = Math.min(res, Math.abs(k - current));//单个元素
      for (int j = i - 1; j >= 0; j--) {
        //把nums[i]并入nums[j]中 并更新nums[j]
        nums[j] |= current;
        res = Math.min(res, Math.abs(k - nums[j]));
      }
    }
    return res;
  }

  //内层循环执行次数 lognums[i]
  public int minimumDifference(int[] nums, int k) {
    int res = Integer.MAX_VALUE;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int current = nums[i];
      res = Math.min(res, Math.abs(k - current));//单个元素
      //(nums[j] | current) != nums[j]: 如果等于, 说明current是num[j]的子集 nums[j]不会改变
      //nums[0]包含nums[1]...包含nums[j], 因此nums[0]~nums[j]都不需要更新 直接跳出循环
      for (int j = i - 1; j >= 0 && (nums[j] | current) != nums[j]; j--) {
        //把nums[i]并入nums[j]中 并更新nums[j]
        nums[j] |= current;
        res = Math.min(res, Math.abs(k - nums[j]));
      }
    }
    return res;
  }
}
