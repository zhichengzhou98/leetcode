package com.topic.twopointer;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 80. 删除有序数组中的重复项 II 双指针
 * @create 2025-02-09 11:27
 */
public class RemoveDuplicates {
  @Test
  void testFun() {
    int[] arr = {1, 1, 1, 2, 2, 3};
    System.out.println(removeDuplicates(arr));
  }

  public int removeDuplicates(int[] nums) {
    int left = 0;
    int right = 0;
    // 当前数字出现的次数
    int cnts = 0;
    int curNum = Integer.MIN_VALUE;
    while (right < nums.length) {
      if (nums[right] == curNum) {
        cnts++;
      } else {
        cnts = 1;
        curNum = nums[right];
      }
      if (cnts <= 2) {
        nums[left] = nums[right];
        left++;
      }
      right++;
    }
    return left;
  }
}
