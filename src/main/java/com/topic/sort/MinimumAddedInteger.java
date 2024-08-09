package com.topic.sort;

import java.util.Arrays;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3132 排序+暴力 o(n³)
 * @create 2024-08-09 9:55
 */
public class MinimumAddedInteger {
  public int minimumAddedInteger(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = i + 1; j < nums1.length; j++) {
        //移除i j
        res = Math.min(res, getRes(nums1, nums2, Set.of(i, j)));
      }
    }
    return res;
  }

  private int getRes(int[] nums1, int[] nums2, Set<Integer> set) {
    int res = 0;
    if (set.contains(0) && set.contains(1)) {
      res = nums2[0] - nums1[2];
    } else if (set.contains(0)) {
      res = nums2[0] - nums1[1];
    } else {
      res = nums2[0] - nums1[0];
    }
    int left = 0;
    int right = 0;
    while (left < nums1.length && right < nums2.length) {
      while (set.contains(left)) {
        left++;
      }
      if (nums2[right] - nums1[left] != res) {
        return Integer.MAX_VALUE;
      }
      left++;
      right++;
    }
    return res;
  }
}
