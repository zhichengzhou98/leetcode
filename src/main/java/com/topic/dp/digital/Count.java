package com.topic.dp.digital;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author zc.zhou
 * @Description 2719 统计整数数目 TODO
 * @create 2024-09-20 13:15
 */
public class Count {
  @Test
  void testFun() {
    System.out.println(Long.MAX_VALUE);
    System.out.println(count("4179205230", "7748704426", 8, 46));
  }

  private static final int MOD = (int) (1e9 + 7);

  public int count(String num1, String num2, int min_sum, int max_sum) {
    this.maxSum = max_sum;
    this.minSum = min_sum;
    return (int) ((countSpecialNumbers(num2) - countSpecialNumbers(sub(num1))) % MOD);
  }

  public String sub(String num) {
    char[] arr = num.toCharArray();
    int i = arr.length - 1;
    while (arr[i] == '0') {
      i--;
    }
    arr[i]--;
    i++;
    while (i < arr.length) {
      arr[i] = '9';
      i++;
    }
    return new String(arr);
  }

  String strN;
  int len;
  int maxSum;
  int minSum;

  public double countSpecialNumbers(String n) {
    if ("0".equals(n)) {
      return 0;
    }
    this.strN = n;
    //数值n的长度
    this.len = this.strN.length();
    int curDigital = 0;
    double[][][][] memo = new double[len][400][2][2];
    for (double[][][] arr1 : memo) {
      for (double[][] arr2 : arr1) {
        for (double[] arr3 : arr2) {
          Arrays.fill(arr3, -1);
        }
      }
    }
    return dfs(curDigital, 0, true, true, memo);
  }

  /**
   * 使用二进制数代替set
   *
   * @param curDigital 当前位，从第0位开始到len - 1
   * @param currentSum 已经填过的数值的各位之和
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private double dfs(int curDigital, int currentSum, boolean skipped, boolean isLimited,
                   double[][][][] memo) {
    if (curDigital == len) {
      //从 0 到 len - 1 都已经选完, 如果一直都是跳过，则这次不是一次有效的值
      if (skipped) {
        return 0;
      } else {
        if (currentSum >= minSum && currentSum <= maxSum) {
          return 1;
        }
        return 0;
      }
    }
    if (memo[curDigital][currentSum][skipped ? 1 : 0][isLimited ? 1 : 0] != -1) {
      return memo[curDigital][currentSum][skipped ? 1 : 0][isLimited ? 1 : 0];
    }
    double res = 0D;
    //需要判断最后一位能否填0，如果前面全都跳过，如果继续跳过直接dfs到下一位
    //如果不跳过，则最小值从1开始
    //如果前面有没有跳过的，则最小值从0开始
    int minDigital = skipped ? 1 : 0;
    //能填的最大数值
    int maxDigital = isLimited ? (strN.charAt(curDigital) - '0') : 9;
    //可以选择跳过
    if (skipped) {
      //跳过
      res = res + dfs(curDigital + 1, currentSum, true, false, memo);
    }
    //skipped：true, 且当前不跳过, 之前都跳过了, 既然当前不能跳过, 那么最小值应该从1开始
    //skipped：false, 当前不能选择跳过 之前填过数字, 当前可以填0
    for (int i = minDigital; i <= maxDigital; i++) {
      res = res + dfs(curDigital + 1,
          currentSum + i,
          false,
          isLimited && i == maxDigital, memo);
    }
    memo[curDigital][currentSum][skipped ? 1 : 0][isLimited ? 1 : 0] = res;
    return res;
  }
}
