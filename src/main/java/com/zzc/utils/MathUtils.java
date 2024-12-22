package com.zzc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-12 9:32
 */
public class MathUtils {
  private MathUtils(){}

  /**
   *
   * @param n 求正整数所有的因子
   * @return
   */
  public static List<Integer> getFactors(int n) {
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i * i <= n ; i++) {
      if (n % i == 0) {
        res.add(i);
        if (n != i * i) {
          res.add(n / i);
        }
      }
    }
    return res;
  }

  //多个int的最大/最小值
  public static int max(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.max(res, num);
    }
    return res;
  }

  public static long max(long... nums) {
    long res = nums[0];
    for (long num : nums) {
      res = Math.max(res, num);
    }
    return res;
  }

  public static int min(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.min(res, num);
    }
    return res;
  }
  //进制转化
  //10进制数 -> 二进制字符串
  public static String parse10ToBinaryStr(long num) {
    return Long.toBinaryString(num);
  }

  //二进制字符串 -> 10进制数
  public static long parseBinaryStrTo10(String str) {
    return Long.parseLong(str, 2);
  }

  /**
   * 矩阵转置
   * @param grid m*n的矩阵
   * @return n*m的矩阵
   */
  public static int[][] matrixTranspose(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res[j][i] = grid[i][j];
      }
    }
    return res;
  }
}
