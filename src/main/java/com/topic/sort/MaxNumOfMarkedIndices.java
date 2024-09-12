package com.topic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2576. 求出最多标记下标 排序 + 二分 解答错误
 * @create 2024-09-12 07:52
 */
public class MaxNumOfMarkedIndices {
  @Test
  void testFun() {
    int[] arr = {9,2,5,4};
    System.out.println(maxNumOfMarkedIndices(arr));
  }
  public int maxNumOfMarkedIndices(int[] nums) {
    int cnts = 0;
    int n = nums.length;
    //数字是否被标记
    boolean[] flag = new boolean[n];
    int left = 1;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (flag[i]) {
        continue;
      }
      left = Math.max(left, i + 1);
      int cur = nums[i];
      int target = 2 * cur;
      if (target > nums[n - 1] || left >= n) {
        break;
      }
      //寻找左边界 找到最小的>= target的索引
      int index = leftBoundary(nums, target, left);
      cnts += 2;
      flag[index] = true;
      left = index + 1;
    }
    return cnts;
  }

  private int leftBoundary(int[] nums, int target, int l) {
    int r = nums.length - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (checkMed(nums[med], target)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }

  private boolean checkMed(int num, int tar) {
    if (num >= tar) {
      return true;
    }
    return false;
  }
}
