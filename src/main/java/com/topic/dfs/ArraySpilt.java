package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-29 16:47
 */
public class ArraySpilt {
  @Test
  void testFun() {
    int[] nums = {1, 1, 4, 5, 1, 4};
    System.out.println(max(nums));
  }

  Map<Integer, Integer> map;

  public int max(int[] nums) {
    map = new HashMap<>();
    return dfs(nums.length - 1, nums);
  }

  private int dfs(int right, int[] nums) {
    if (right < 0) {
      return 0;
    }
    if (map.containsKey(right)) {
      return map.get(right);
    }
    int res = Integer.MIN_VALUE;
    int max = nums[right];
    int min = nums[right];
    for (int i = right; i >= 0; i--) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
      res = Math.max(res, dfs(i - 1, nums) + max - min);
    }
    map.put(right, res);
    return res;
  }
}
