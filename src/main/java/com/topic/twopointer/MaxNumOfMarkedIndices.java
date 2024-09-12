package com.topic.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2576. 求出最多标记下标 排序 + 双指针
 * @create 2024-09-12 07:52
 */
public class MaxNumOfMarkedIndices {
  @Test
  void testFun() {
    int[] arr = {57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92};
    System.out.println(maxNumOfMarkedIndices(arr));
  }
  //[2,4,5,9] 双指针
  public int maxNumOfMarkedIndices(int[] nums) {
    int cnts = 0;
    int n = nums.length;
    //数字是否被标记
    boolean[] flag = new boolean[n];
    int right = n / 2;
    int left = 0;
    Arrays.sort(nums);
    while (right < n) {
      int numL = nums[left];
      while (right < n && nums[right] < 2 * numL) {
        right++;
      }
      if (right < n) {
        flag[right] = true;
        flag[left] = true;
        cnts+=2;
      } else {
        break;
      }
      while (left < n && flag[left]) {
        left++;
      }
      right++;
    }
    return cnts;
  }

  //解答错误
  public int maxNumOfMarkedIndicesV1(int[] nums) {
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
