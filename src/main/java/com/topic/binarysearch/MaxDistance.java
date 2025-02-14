package com.topic.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description [1552]两球之间的磁力
 * @create 2025-02-14 17:25
 */
public class MaxDistance {
  @Test
  void testFun() {
    int[] p = {5,4,3,2,1,1000000000};
    System.out.println(maxDistance(p,2));
  }
  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    // 二分查找右边界
    return rightBoundary(position, m);
  }

  public int rightBoundary(int[] nums, int target) {
    int l = 1;
    int r = nums[nums.length - 1] - nums[0];
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(nums, med, target)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return med;
  }

  /**
   *
   * @param p 球的位置
   * @param med 距离
   * @param target 剩下的球的个数
   * @return
   */
  public boolean checkMedRight(int[] p, int med, int target) {
    // 上次球的位置
    long lastIndex = Integer.MIN_VALUE;
    for (int cur : p) {
      if (cur - lastIndex >= med) {
        target--;
        lastIndex = cur;
      }
      if (target <= 0) {
        return true;
      }
    }
    return false;
  }
}
