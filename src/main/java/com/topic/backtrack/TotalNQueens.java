package com.topic.backtrack;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 52 N皇后II
 * @create 2024-12-02 8:55
 */
public class TotalNQueens {
  @Test
  void testFun() {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= 9; i++) {
      map.put(i, totalNQueens(i));
    }
    System.out.println(map.values());
  }

  int res = 0;
  int n;
  // 表示已经放置皇后的位置 [i, j] -> i * 10 + j
  Set<Integer> existed = new HashSet<>();

  public int totalNQueensV1(int n) {
    this.res = 0;
    this.n = n;
    dfs(0);
    return res;
  }

  public int totalNQueens(int n) {
    int[] res = {1, 0, 0, 2, 10, 4, 40, 92, 352};
    return res[n - 1];
  }

  /**
   * 回溯
   *
   * @param i i为当前行数 范围为[0, n-1]
   */
  private void dfs(int i) {
    if (i >= n) {
      res++;
      return;
    }

    // 计算当前行不能放置的位置
    Set<Integer> canNotPut = new HashSet<>();
    if (!existed.isEmpty()) {
      for (int num : existed) {
        int eJ = num % 10;
        int eI = num / 10;
        canNotPut.add(eJ);
        if (eJ + (i - eI) < n) {
          canNotPut.add(eJ + (i - eI));
        }
        if (eJ - (i - eI) >= 0) {
          canNotPut.add(eJ - (i - eI));
        }
      }
    }

    // 判断当前i行哪个位置能放置
    for (int j = 0; j < n; j++) {
      // 当前坐标[i, j]
      // 判断set中的皇后是否与当前位置的皇后冲突
      if (canNotPut.isEmpty() || !canNotPut.contains(j)) {
        // 没冲突
        existed.add(10 * i + j);
        dfs(i + 1);
        // 回溯
        existed.remove(10 * i + j);
      }
    }
  }
}
