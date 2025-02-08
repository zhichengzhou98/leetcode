package com.topic.dp;

/**
 * @author zc.zhou
 * @Description [63]不同路径II
 * @create 2025-02-08 9:07
 */
public class UniquePathsWithObstacles {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
          continue;
        }
        if (i == 0 && j == 0) {
          obstacleGrid[i][j] = 1;
          continue;
        }
        obstacleGrid[i][j] = (i == 0 ? 0 : obstacleGrid[i - 1][j]) +
            (j == 0 ? 0 : obstacleGrid[i][j - 1]);
      }
    }
    return obstacleGrid[m - 1][n - 1];
  }
}
