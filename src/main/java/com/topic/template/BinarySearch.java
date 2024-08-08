package com.topic.template;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 要求有序
 * @create 2023-09-03 17:25
 */
public class BinarySearch {

  @Test
  void testFindRight() {
    //[1, 2, 3, 4, 5, 8]
    int[] nums = {1, 2, 3, 4, 5, 8};
    //找到小于target的最大值
    System.out.println(rightBoundary(nums, 0));
  }

  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    int[] arr = {1, 2, 3, 4};
    int target = 5;
    System.out.println(binarySearch.specificTarget(arr, target));
  }

  public boolean checkMed(int med, int target) {
    if (med > target) {
      return true;
    }
    return false;
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  public int leftBoundary(int[] nums, int target) {
    int l = 0;
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
    return nums[med];
  }

  //查找右边界 小于等于 target的最大值  checkMedRight 小于等于时为true！！！
  public int rightBoundary(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(nums[med], target)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return nums[med];
  }

  public boolean checkMedRight(int med, int target) {
    //[1, 2, 3, 4, 5, 8] target => 8
    // √  √  √  √  √  √
    if (med > target) {
      return false;
    }
    //满足题目要求时 返回true
    //med <= target => 题目要求找 小于等于target的值
    return true;
  }

  //查找指定值
  public int specificTarget(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int res = -1;
    while (l <= r) {
      int med = (r - l) / 2 + l;
      if (target == nums[med]) {
        return med;
      } else if (target > med) {
        l = med + 1;
      } else {
        r = med - 1;
      }
    }
    return res;
  }
}
