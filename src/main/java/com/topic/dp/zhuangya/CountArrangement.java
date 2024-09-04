package com.topic.dp.zhuangya;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 526 n [1, 15]
 * @create 2024-09-04 17:15
 */
public class CountArrangement {

  @Test
  void testFun() {
    System.out.println(countArrangement(6));
  }

  int max;

  public int countArrangement(int n) {
    max = n;
    int[][] memo = new int[16][1 << n];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfs(n, 0, memo);
  }


  /**
   * 复杂度：n * 2^n * n
   * @param n    还剩 1-n个数字没填
   * @param j    当前已经填过的位
   * @param memo 缓存
   * @return 一共有多少可能结果
   */
  public int dfs(int n, int j, int[][] memo) {
    if (memo[n][j] != -1) {
      return memo[n][j];
    }
    if (n == 1) {
      memo[n][j] = 1;
      return 1;
    }
    //当前数字n: 判断n能填哪些位置
    //n的因子
    int res = 0;
    for (int i = 1; i <= n - 1; i++) {
      if (n % i == 0) {
        //n能填到下标为 i - 1的位置
        //判断 i - 1位置是否有数
        if ((j & (1 << (i - 1))) == 0) {
          res = res + dfs(n - 1, j | (1 << (i - 1)), memo);
        }
      }
    }
    //n的倍数
    for (int i = 1; i * n <= max; i++) {
      //n能填到下标为 i * n - 1的位置
      //判断 i * n - 1位置是否有数
      if ((j & (1 << (i * n - 1))) == 0) {
        res = res + dfs(n - 1, j | (1 << (i * n - 1)), memo);
      }
    }
    memo[n][j] = res;
    return res;
  }
}
