package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2320 DP 一条街道有 n 个地块，左右两侧独立计算方案数，然后乘积即可。
 * @create 2024-07-30 18:27
 */
public class CountHousePlacements {
  @Test
  void testFun() {
    System.out.println(getSingleTotal(5));
  }

  public int[][] matrixExponentiationBySquaring(int[][] matrix, int n, int MOD) {
    if (n == 1) {
      return matrix;
    }
    if (n % 2 == 0) {
      int[][] tempMatrix = matrixExponentiationBySquaring(matrix, n / 2, MOD);
      return matrixMultiplication(tempMatrix, tempMatrix, MOD);
    }
    int[][] tempMatrix = matrixExponentiationBySquaring(matrix, (n - 1) / 2, MOD);
    tempMatrix = matrixMultiplication(tempMatrix, tempMatrix, MOD);
    return matrixMultiplication(tempMatrix, matrix, MOD);
  }

  private int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB, int MOD) {
    int[][] res = new int[matrixA.length][matrixA[0].length];
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        //tempMatrix 第i行 * 第j列
        int[] lineI = matrixA[i];
        int[] columJ = new int[res[i].length];
        for (int k = 0; k < columJ.length; k++) {
          columJ[k] = matrixB[k][j];
        }
        res[i][j] = 0;
        for (int k = 0; k < lineI.length; k++) {
          res[i][j] = (int) ((res[i][j] + ((long) lineI[k] * columJ[k]) % MOD) % MOD);
        }
      }
    }
    return res;
  }

  private long getSingleTotal(int n) {
    //0: 表示不放置房子
    //1: 表示放置房子
    long[][] dp = new long[n][2];
    dp[0][0] = 1L;
    dp[0][1] = 1L;
    if (n == 1) {
      return 2;
    }
    //使用矩阵快速幂 系数矩阵为 A: {{1, 1}, {1, 0}}
    int[][] matrix = {{1, 1}, {1, 0}};
    int[][] res = matrixExponentiationBySquaring(matrix, n - 1, MOD);
    for (int i = 0; i < res[0].length; i++) {
      dp[n-1][0] = (dp[n - 1][0] + res[0][i]) % MOD;
      dp[n-1][1] = (dp[n - 1][1] + res[1][i]) % MOD;
    }

    return (dp[n-1][0] + dp[n-1][1]) % MOD;
  }


  private static final int MOD = (int) (Math.pow(10, 9) + 7);
  public int countHousePlacements(int n) {
    long total = getSingleTotal(n);
    return (int) (total * total % MOD);
  }

  //n块地 房子不相邻 方案数
  private long getSingleTotalV1(int n) {
    //0: 表示不放置房子
    //1: 表示放置房子
    long[][] dp = new long[n][2];
    dp[0][0] = 1L;
    dp[0][1] = 1L;
    for (int i = 1; i < n; i++) {
      dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
      dp[i][1] = dp[i-1][0];
    }
    return (dp[n-1][0] + dp[n-1][1]) % MOD;
  }
}
