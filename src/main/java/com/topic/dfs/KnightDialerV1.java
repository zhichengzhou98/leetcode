package com.topic.dfs;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 935.骑士拨号器 dp + 矩阵快速幂
 * @create 2024-12-10 20:39
 */
public class KnightDialerV1 {
  int[][] map;
  long[][] memo;
  private static final int MOD = (int) (1e9 + 7);

  public int knightDialer(int n) {
    // 每个点的下一个节点
    map = new int[][]{{4, 6}, {8, 6}, {7, 9}, {4, 8}, {9, 3, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3},
        {2, 4}};
    long[][] dp = new long[10][n + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][1] = 1;
    }
    for (int i = 2; i <= n ; i++) {
      for (int j = 0; j < dp.length; j++) {
        // [j ,i] 表示从第j个 点开始 走i步的方案数
        int[] nexts = map[j];
        for(int next:nexts) {
          dp[j][i] = (dp[j][i] + dp[next][i-1]) % MOD;
        }
      }
    }
    long res = 0L;
    for (int i = 0; i < 10; i++) {
      res = (res + dp[i][n]) % MOD;
    }
    return (int) res;
  }

  public int knightDialerV1(int n) {
    // 每个点的下一个节点
    map = new int[][]{{4, 6}, {8, 6}, {7, 9}, {4, 8}, {9, 3, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3},
        {2, 4}};
    memo = new long[10][n + 1];
    for (long[] tmp : memo) {
      Arrays.fill(tmp, -1);
    }
    // dfs
    long res = 0L;
    for (int i = 0; i < 10; i++) {
      res = (res + dfs(i, n)) % MOD;
    }
    return (int) res;
  }

  private long dfs(int cur, int n) {
    if (n == 1) {
      return 1;
    }
    if (memo[cur][n] != -1) {
      return memo[cur][n];
    }
    long res = 0L;
    int[] list = map[cur];
    for (int next : list) {
      res = (res + dfs(next, n - 1)) % MOD;
    }
    memo[cur][n] = res;
    return res;
  }
}
