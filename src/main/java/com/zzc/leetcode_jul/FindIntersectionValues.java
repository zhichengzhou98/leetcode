package com.zzc.leetcode_jul;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-16 08:29
 */
public class FindIntersectionValues {

  Set<Integer> set1 = new HashSet<>();
  Set<Integer> set2 = new HashSet<>();
  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    int[] res = new int[2];
    //把nums1放入set
    initMap(nums1, set1);
    initMap(nums2, set2);
    for(int num : nums1) {
      if (set2.contains(num)) {
        res[0]++;
      }
    }
    for(int num : nums2) {
      if (set1.contains(num)) {
        res[1]++;
      }
    }
    return res;
  }

  private void initMap(int[] nums, Set<Integer> set) {
    for (int num : nums) {
      set.add(num);
    }
  }
}
