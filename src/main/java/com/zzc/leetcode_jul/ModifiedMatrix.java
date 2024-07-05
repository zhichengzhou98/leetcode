package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-05 14:48
 */
public class ModifiedMatrix {
  public int[][] modifiedMatrix(int[][] matrix) {
    int[][] res = new int[matrix.length][matrix[0].length];
    int[] columMax = new int[matrix[0].length];
    for (int i = 0; i < matrix[0].length; i++) {
      // i 列
      columMax[i] = Integer.MIN_VALUE;
      for (int j = 0; j < matrix.length; j++) {
        // j 行
        columMax[i] = Math.max(columMax[i], matrix[j][i]);
        res[j][i] = matrix[j][i];
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      // i 行
      for (int j = 0; j < matrix[0].length; j++) {
        // j 列
        if (res[i][j] == -1) {
          res[i][j] = columMax[j];
        }
      }
    }
    return res;
  }
}
