package com.topic.dp.knapsack;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 494 目标和
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * @create 2024-09-19 14:10
 */
public class FindTargetSumWays {
  @Test
  void testFun() {
    int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
    System.out.println(findTargetSumWays(nums, 1));
  }

  int n;
  int[] nums;
  int target;
  int sum = 0;

  Map<String, Integer> map;

  public int findTargetSumWays(int[] nums, int target) {
    this.n = nums.length;
    this.nums = nums;
    this.target = target;
    for (int num : nums) {
      sum += num;
    }
    map = new HashMap<>();
    return dfs(n - 1, target);
  }

  /**
   * @param i   第i个数
   * @param tar 能达到tar
   * @return 方案数
   */
  public int dfs(int i, int tar) {
    String key = i + "," + tar;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (i >= n || i < 0) {
      return 0;
    }
    if (tar > sum || tar < -sum) {
      return 0;
    }

    if (i == 0) {
      int res = 0;
      if (nums[i] == tar) {
        res++;
      }

      if (nums[i] == -tar) {
        res++;
      }
      return res;
    }

    //考虑当前数是正还是负数
    //正数
    //dfs(i - 1, tar - nums[i]);
    //负数
    //dfs(i - 1, tar + nums[i]);
    int res = dfs(i - 1, tar - nums[i]) + dfs(i - 1, tar + nums[i]);
    map.put(key, res);
    return res;
  }
}
