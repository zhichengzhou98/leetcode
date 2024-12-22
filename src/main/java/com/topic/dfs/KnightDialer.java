package com.topic.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 935.骑士拨号器 dfs
 * @create 2024-12-10 9:03
 */
public class KnightDialer {

  Map<Integer, List<Integer>> map;
  long[][] memo;
  private static final int MOD = (int) (1e9 + 7);

  public int knightDialer(int n) {
    // 每个点的下一个节点
    map = Map.of(0, List.of(4, 6),
        1, List.of(8, 6),
        2, List.of(7, 9),
        3, List.of(4, 8),
        4, List.of(9, 3, 0),
        5, List.of(),
        6, List.of(1, 7, 0),
        7, List.of(2, 6),
        8, List.of(1, 3),
        9, List.of(2, 4)
    );
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

  /**
   * @param cur 当前节点
   * @param n   剩余步数
   * @return 方案数
   */
  private long dfs(int cur, int n) {
    if (n == 1) {
      return 1;
    }
    if (memo[cur][n] != -1) {
      return memo[cur][n];
    }
    long res = 0L;
    List<Integer> list = map.get(cur);
    for (int next : list) {
      res = (res + dfs(next, n - 1)) % MOD;
    }
    memo[cur][n] = res;
    return res;
  }
}
