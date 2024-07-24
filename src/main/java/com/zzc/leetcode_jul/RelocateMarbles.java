package com.zzc.leetcode_jul;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-24 08:11
 */
public class RelocateMarbles {
  public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
    Set<Integer> set = new HashSet<>();
    for (int location : nums) {
      set.add(location);
    }
    for (int i = 0; i < moveFrom.length; i++) {
      int from = moveFrom[i];
      int to = moveTo[i];
      set.remove(from);
      set.add(to);
    }
    return set.stream().sorted().toList();
  }
}
