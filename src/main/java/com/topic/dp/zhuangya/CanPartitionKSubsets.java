package com.topic.dp.zhuangya;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 698 1 <= k <= len(nums) <= 16
 * @create 2024-09-05 17:17
 */
public class CanPartitionKSubsets {
  @Test
  void testFun() {
    int[] arr = {1,2,3,4};
    System.out.println(canPartitionKSubsets(arr, 2));
  }

  int len;
  int[] nums;
  int finalTarget;

  public boolean canPartitionKSubsets(int[] nums, int k) {
    len = nums.length;
    this.nums = nums;
    Set<Integer> set = new HashSet<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      set.add(i);
    }
    if (sum % k != 0) {
      return false;
    }
    finalTarget = sum / k;

    for (int num : nums) {
      if (num > finalTarget) {
        return false;
      }
    }
    int[][] memo = new int[len + 1][1 << len];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfs(len, 0, memo, finalTarget, set);
  }

  /**
   * @param n        数组中剩余还剩下n个数
   * @param j        已经使用过的数的index
   * @param memo     缓存
   * @param target   需要凑成的目标值
   * @param indexSet 剩余索引set
   * @return 能否划分
   */
  private boolean dfs(int n, int j, int[][] memo, int target, Set<Integer> indexSet) {
    if (n == 0) {
      return true;
    }
    if (memo[n][j] != -1) {
      return memo[n][j] == 1;
    }
    boolean res = false;
    for (int index : indexSet) {
      if ((j & (1 << index)) == 0) {
        //当前index的num还没被选
        int current = nums[index];
        Set<Integer> tmp = new HashSet<>(indexSet);
        tmp.remove(index);
        if (current == target) {
          res = res | (dfs(n - 1, j | (1 << index), memo, finalTarget, tmp));
        } else if (current < target) {
          res = res | (dfs(n - 1, j | (1 << index), memo, target - current, tmp));
        }
      }
    }
    memo[n][j] = res ? 1 : 0;
    return res;
  }
}
