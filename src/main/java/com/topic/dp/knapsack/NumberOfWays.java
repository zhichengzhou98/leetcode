package com.topic.dp.knapsack;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2787
 * @create 2024-09-19 14:53
 */
public class NumberOfWays {
  @Test
  void testFun() {
    //System.out.println(numberOfWays(10,2));
    System.out.println(numberOfWays(213, 1));
  }

  private static int MOD = (int) (Math.pow(10, 9) + 7);

  public int numberOfWays(int n, int x) {
    //最大数为maxN
    int maxN = (int) Math.pow(n, 1.0 / x);
    //dp[i][j] 表示前1-i个数 能计算出j 的方案数
    long[][] dp = new long[maxN + 2][n + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        //当前数字为i
        //考虑当前数字选还是不选 i^x
        int current = (int) Math.pow(i, x);
        //选
        if (j > current) {
          dp[i][j] = dp[i - 1][j - current];
        } else if (j == current) {
          dp[i][j] = 1;
        }
        //不选
        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
      }
    }
    return (int) dp[maxN + 1][n];
  }
}
