package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1227. 飞机座位分配概率 TODO: dp + 前缀和优化
 * @create 2024-10-04 17:45
 */
public class NthPersonGetsNthSeat {
  @Test
  void testFun() {
    System.out.println(nthPersonGetsNthSeat(1));
    System.out.println(nthPersonGetsNthSeat(2));
    System.out.println(nthPersonGetsNthSeat(3));
    System.out.println(nthPersonGetsNthSeat(4));
  }
  double[] memo;
  public double nthPersonGetsNthSeat(int n) {
    memo = new double[n + 1];
    Arrays.fill(memo, -1);
    return dfs(n);
  }
  private double dfs(int n) {
    if (n == 1) {
      return 1;
    }
    if (memo[n] >= 0) {
      return memo[n];
    }
    double res = 0.0;
    int tmp = n -1;
    while (tmp >= 1) {
      res += dfs(tmp);
      tmp--;
    }
    res /= n;
    memo[n] = res;
    return res;
  }
}
