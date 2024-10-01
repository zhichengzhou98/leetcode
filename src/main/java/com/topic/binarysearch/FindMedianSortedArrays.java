package com.topic.binarysearch;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 4 寻找两个正序数组的中位数
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
  public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
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

  // o(log(m + n))
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // 确保 nums1 是较短的数组
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    int totalLeft = (m + n + 1) / 2;

    int left = 0, right = m;

    while (left < right) {
      int i = left + (right - left) / 2;
      int j = totalLeft - i;

      if (nums1[i] < nums2[j - 1]) {
        left = i + 1;
      } else {
        right = i;
      }
    }

    int i = left;
    int j = totalLeft - i;

    int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
    int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
    int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
    int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

    if ((m + n) % 2 == 1) {
      return Math.max(nums1LeftMax, nums2LeftMax);
    } else {
      return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }
  }
}
