package com.topic.dp.knapsack;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 416 分割等和子集 0-1背包
 * @create 2024-09-19 11:05
 */
public class CanPartition {
  @Test
  void testFun() {
    int[] nums = {100};
    System.out.println(canPartition(nums));
  }
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) {
      return false;
    }
    int n = nums.length;
    int m = sum / 2;
    //dp[i][j]表示前i个物品 能否实现和为j
    boolean[][] dp = new boolean[n][m + 1];
    if (nums[0] > m) {
      return false;
    }
    dp[0][nums[0]] = true;
    // 考虑第i个物品 是否选择
    // 第i个物品重量为 nums[i]
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j == 0) {
          dp[i][j] = true;
        } else if (j <= m && j - nums[i] >= 0) {
          dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
        } else if (j <= m) {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n - 1][m];
  }
}
