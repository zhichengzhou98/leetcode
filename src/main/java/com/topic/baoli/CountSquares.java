package com.topic.baoli;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author zc.zhou
 * @Description 1277 暴力能过...
 * @create 2024-08-09 18:00
 */
public class CountSquares {
  @Test
  void testFun() throws IOException {
    int[][] matrix = ArrayUtils.generate("array", int[][].class);
    System.out.println(countSquares(matrix));
  }
  public int countSquares(int[][] matrix) {
    int res = 0;
    int row = matrix.length;
    int line = matrix[0].length;
    //正方行的最大变长
    int maxLen = Math.min(row, line);
    //枚举正方形边长
    for (int i = 1; i <= maxLen; i++) {
      //当前的边长为i
      for (int j = 0; j <= matrix.length - i; j++) {
        for (int k = 0; k <= matrix[0].length - i; k++) {
          if (checkSquare(new int[]{j, k}, i, matrix)) {
            res++;
          }
        }
      }
    }
    return res;
  }

  private boolean checkSquare(int[] begin, int len, int[][] matrix) {
    //检查起点为begin 边长为len是否是正方行
    int x = begin[0];
    int y = begin[1];
    for (int i = x; i < x + len; i++) {
      for (int j = y; j < y + len; j++) {
        if (matrix[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }
}
