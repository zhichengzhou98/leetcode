package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2320 DP 一条街道有 n 个地块，左右两侧独立计算方案数，然后乘积即可。
 * @create 2024-07-30 18:27
 */
public class CountHousePlacements {
  @Test
  void testFun() {
    System.out.println(getSingleTotal(2));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);
  public int countHousePlacements(int n) {
    long total = getSingleTotal(n);
    return (int) (total * total % MOD);
  }

  //n块地 房子不相邻 方案数
  private long getSingleTotal(int n) {
    //0: 表示不放置房子
    //1: 表示放置房子
    long[][] dp = new long[n][2];
    dp[0][0] = 1L;
    dp[0][1] = 1L;
    for (int i = 1; i < n; i++) {
      dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
      dp[i][1] = dp[i-1][0];
    }
    return (dp[n-1][0] + dp[n-1][1]) % MOD;
  }
}
