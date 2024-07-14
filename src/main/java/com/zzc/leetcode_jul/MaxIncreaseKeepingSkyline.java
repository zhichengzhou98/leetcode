package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-14 07:49
 */
public class MaxIncreaseKeepingSkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMax = new int[grid.length];
    int[] columnMax = new int[grid[0].length];
    //按行遍历
    for (int i = 0; i < grid.length; i++) {
      rowMax[i] = grid[i][0];
      for (int j = 0; j < grid[0].length; j++) {
        rowMax[i] = Math.max(rowMax[i], grid[i][j]);
      }
    }
    //按列遍历
    for (int i = 0; i < grid[0].length; i++) {
      columnMax[i] = grid[0][i];
      for (int j = 0; j < grid.length; j++) {
        columnMax[i] = Math.max(columnMax[i], grid[j][i]);
      }
    }
    int res = 0;
    //再次遍历整个数组，求出每个元素可能得最大值 value = min(rowMax, columnMax)
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int current = grid[i][j];
        int row = rowMax[i];
        int column = columnMax[j];
        res += Math.min(column, row) - current;
      }
    }
    return res;
  }
}
