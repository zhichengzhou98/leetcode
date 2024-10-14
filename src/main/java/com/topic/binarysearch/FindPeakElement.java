package com.topic.binarysearch;

/**
 * @author zc.zhou
 * @Description 162. 寻找峰值
 * @create 2024-10-14 20:40
 */
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1 || nums[0] > nums[1]) {
      return 0;
    }
    int size = nums.length;
    //检查边界
    if (nums[size - 1] > nums[size - 2]) {
      return size - 1;
    }
    //二分法
    int left = 0;
    int right = size - 1;
    int med = (right - left) / 2 + left;
    while (right > left) {
      if (nums[med + 1] > nums[med]) {
        left = med + 1;
      } else if (nums[med + 1] < nums[med]) {
        right = med;
      }
      med = (right - left) / 2 + left;
    }
    return med;
  }
}
