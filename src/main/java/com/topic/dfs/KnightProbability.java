package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 688. 骑士在棋盘上的概率
 * @create 2024-12-07 12:07
 */
public class KnightProbability {
  @Test
  void testFun() {
    System.out.println(knightProbability(3,2,0,0));
  }
  // 移动方向
  private static final int[][] dirs = {
      {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
      {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
  };

  // 棋盘边界
  int n;

  // 缓存
  double[][][] memo;


  public double knightProbability(int n, int k, int row, int column) {
    this.n = n;
    memo = new double[n][n][k + 1];
    for (double[][] m : memo) {
      for(double[] t : m) {
        Arrays.fill(t, -1.0);
      }
    }
    return dfs(row, column, k);
  }

  /**
   * @param row    当前位置x
   * @param column 当前位置y
   * @param k      剩余移动次数
   * @return 留在棋盘的概率
   */
  public double dfs(int row, int column, int k) {
    if (k == 0) {
      return 1.0;
    }
    if (memo[row][column][k] != -1) {
      return memo[row][column][k];
    }
    double p = 0;
    for (int[] dir : dirs) {
      int nextX = row + dir[0];
      int nextY = column + dir[1];
      if (nextX < n && nextX >= 0 &&
          nextY < n && nextY >= 0) {
        p = 1.0 / 8 * dfs(nextX, nextY, k-1) + p;
      }
    }
    memo[row][column][k] = p;
    return p;
  }
}
