package com.topic.binarysearch;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-09 9:21
 */
public class FindMedianSortedArrays {
  //(m +n)log(m + n)
  public double findMedianSortedArraysV1(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] merge = new int[m + n];
    System.arraycopy(nums1, 0, merge, 0, m);
    System.arraycopy(nums2, 0, merge, 0 + m, n);
    Arrays.sort(merge);
    int mid = (m + n) / 2;
    if (merge.length % 2 == 0) {
      return ((double) merge[mid - 1] + merge[mid]) / 2;
    }
    return merge[mid];
  }

  // o(m + n)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] merge = new int[m + n];
    int left = m - 1;
    int right = n - 1;
    int lastIndex = m + n -1;
    while (left >= 0 && right >= 0) {
      if (nums1[left] >= nums2[right]) {
        merge[lastIndex] = nums1[left];
        left--;
      } else {
        merge[lastIndex] = nums2[right];
        right--;
      }
      lastIndex--;
    }
    while (left >= 0) {
      merge[lastIndex] = nums1[left];
      left--;
      lastIndex--;
    }
    while (right >= 0) {
      merge[lastIndex] = nums2[right];
      right--;
      lastIndex--;
    }

    int mid = (m + n) / 2;
    if (merge.length % 2 == 0) {
      return ((double) merge[mid - 1] + merge[mid]) / 2;
    }
    return merge[mid];
  }
}
