package com.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-04 10:31
 */
public class neighborSum {
  int[][] grid;
  //记录每个值的坐标
  Map<Integer, int[]> map;
  public neighborSum(int[][] grid) {
    this.grid = grid;
    map = new HashMap<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        map.put(grid[i][j], new int[]{i, j});
      }
    }
  }

  public int adjacentSum(int value) {
    int res = 0;
    int[] point = map.get(value);
    int x = point[0];
    int y = point[1];
    if (x -1 >= 0) {
      res += grid[x - 1][y];
    }
    if (x + 1 <= grid.length -1) {
      res += grid[x + 1][y];
    }
    if (y - 1 >= 0) {
      res += grid[x][y - 1];
    }
    if (y + 1 <= grid[0].length -1) {
      res += grid[x][y + 1];
    }
    return res;
  }

  public int diagonalSum(int value) {
    int res = 0;
    int[] point = map.get(value);
    int x = point[0];
    int y = point[1];
    if (x >= 1) {
      if (y >= 1) {
        res += grid[x - 1][y - 1];
      }
      if (y + 1 <= grid[0].length -1) {
        res += grid[x - 1][y + 1];
      }
    }
    if (x + 1 <= grid.length - 1) {
      if (y >= 1) {
        res += grid[x + 1][y - 1];
      }
      if (y + 1 <= grid[0].length -1) {
        res += grid[x + 1][y + 1];
      }
    }
    return res;
  }
}
