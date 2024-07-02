package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-02 21:07
 */
public class MaximumPrimeDifference {
  public int maximumPrimeDifference(int[] nums) {
    Set<Integer> sets = Set.of(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (sets.contains(nums[i])) {
        indexes.add(i);
      }
    }
    if (indexes.isEmpty()) {
      return 0;
    }
    return indexes.get(indexes.size() - 1) - indexes.get(0);
  }
}
