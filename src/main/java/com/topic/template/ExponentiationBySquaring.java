package com.topic.template;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 快速幂
 * @create 2024-03-27 22:20
 */
public class ExponentiationBySquaring {
  @Test
  public void test() {
    System.out.println(exponentiationBySquaring(2, 87));
  }

  public static int MOD = (int) (Math.pow(10, 9) + 7);


  public long exponentiationBySquaring(int a, int b) {
    //求a的b次幂
    if (b == 1) {
      return a % MOD;
    }

    if (b % 2 == 0) {
      long x = exponentiationBySquaring(a, b / 2) % MOD;
      return x * x % MOD;
    }
    long y = exponentiationBySquaring(a, (b - 1) / 2) % MOD;
    return y * y % MOD * a % MOD;
  }

  @Test
  void name() {
    int[][] matrix = {{2,1},{3,1}};
    System.out.println(Arrays.deepToString(matrixExponentiationBySquaring(matrix, 5, 1000000)));
  }

  //矩阵快速幂
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
}
