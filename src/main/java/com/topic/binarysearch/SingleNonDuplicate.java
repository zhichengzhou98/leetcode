package com.topic.binarysearch;

/**
 * @author zc.zhou
 * @Description 540. 有序数组中的单一元素 二分
 * @create 2024-11-10 07:53
 */
public class SingleNonDuplicate {
  public int singleNonDuplicate(int[] nums) {
    // nums的长度一定是个奇数
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int med = ((right - left) >> 1) + left;
      if (nums[med] == nums[med + 1]) {
        //右边数组的长度
        int len = (right - med) + 1;
        if (len % 2 == 0) {
          //右边数组是偶数 出现一次的数在左边
          right = med - 1;
        } else {
          //右边数组是奇数 出现一次的数在右边
          left = med + 2;
        }
      } else if (nums[med] == nums[med - 1]) {
        // 左边数组的长度
        int len = (med - left) + 1;
        if (len % 2 == 0) {
          //左边数组是偶数 出现一次的数在右边
          left = med + 1;
        } else {
          //左边数组是奇数 出现一次的数在左边
          right = med - 2;
        }
      } else {
        return nums[med];
      }
    }
    return nums[left];
  }
}
