package com.topic.baoli;

import com.zzc.utils.MathUtils;

import static com.zzc.utils.MathUtils.matrixTranspose;

/**
 * @author zc.zhou
 * @Description 3239 最少翻转次数使二进制矩阵回文 I
 * @create 2024-11-15 9:12
 */
public class MinFlips {
  public int minFlipsV1(int[][] grid) {
    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    // 按行统计
    for (int i = 0; i < m; i++) {
      int left = 0;
      int right = n - 1;
      while (right > left) {
        if (grid[i][left] != grid[i][right]) {
          res++;
        }
        left++;
        right--;
      }
    }
    int res1 = 0;
    // 按列统计
    for (int i = 0; i < n; i++) {
      int top = 0;
      int down = m - 1;
      while (down > top) {
        if (grid[down][i] != grid[top][i]) {
          res1++;
        }
        top++;
        down--;

      }
    }
    return Math.min(res, res1);
  }

  public int minFlips(int[][] grid) {
    return Math.min(getMin(grid), getMin(matrixTranspose(grid)));
  }

  public int getMin(int[][] grid) {
    int res = 0;
    int n = grid[0].length;
    // 按行统计
    for (int[] ints : grid) {
      int left = 0;
      int right = n - 1;
      while (right > left) {
        if (ints[left] != ints[right]) {
          res++;
        }
        left++;
        right--;
      }
    }
    return res;
  }
}
