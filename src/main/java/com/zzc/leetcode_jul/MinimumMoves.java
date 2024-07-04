package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-04 18:22
 */
public class MinimumMoves {
  public long minimumMoves(int[] nums, int k, int maxChanges) {
    //统计1的位置
    List<Integer> oneIndex = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        oneIndex.add(i);
      }
    }
    if (oneIndex.isEmpty()) {
      return 2L * k;
    }
    long minRes = Long.MAX_VALUE;
    for (int i = 0; i < oneIndex.size(); i++) {
      int neededCount = k - 1;
      int changes = maxChanges;
      long temp = 0L;
      while (neededCount > 0) {
        //TODO
        neededCount--;
      }
      minRes = Math.min(temp, minRes);
    }
    return minRes;
  }
}
