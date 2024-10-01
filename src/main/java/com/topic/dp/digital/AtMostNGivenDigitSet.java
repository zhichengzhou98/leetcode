package com.topic.dp.digital;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 902 最大位N的数字组合
 * @create 2024-09-20 16:49
 */
public class AtMostNGivenDigitSet {
  @Test
  void testFun() {
    String[] digits = {"1","3","5","7"};
    System.out.println(atMostNGivenDigitSet(digits, 100));
  }

  int[] digitsNum;

  public int atMostNGivenDigitSet(String[] digits, int n) {
    digitsNum = new int[digits.length];
    for (int i = 0; i < digits.length; i++) {
      digitsNum[i] = digits[i].charAt(0) - '0';
    }
    this.strN = String.valueOf(n);
    //数值n的长度
    this.len = this.strN.length();

    int[][][] memo = new int[len][2][2];

    for (int[][] arr2 : memo) {
      for (int[] arr3 : arr2) {
        Arrays.fill(arr3, -1);
      }
    }

    return dfs(0, true, true, memo);
  }

  //首位数字
  String strN;
  int len;

  /**
   * 使用二进制数代替set
   *
   * @param curDigital 当前位，从第0位开始到len - 1
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private int dfs(int curDigital, boolean skipped, boolean isLimited,
                  int[][][] memo) {
    if (curDigital == len) {
      //从 0 到 len - 1 都已经选完, 如果一直都是跳过，则这次不是一次有效的值
      return skipped ? 0 : 1;
    }
    if (memo[curDigital][skipped ? 1 : 0][isLimited ? 1 : 0] != -1) {
      return memo[curDigital][skipped ? 1 : 0][isLimited ? 1 : 0];
    }
    int res = 0;
    //需要判断最后一位能否填0，如果前面全都跳过，如果继续跳过直接dfs到下一位
    //如果不跳过，则最小值从1开始
    //如果前面有没有跳过的，则最小值从0开始
    int minDigital = skipped ? 1 : 0;
    //能填的最大数值
    int maxDigital = isLimited ? (strN.charAt(curDigital) - '0') : 9;
    //可以选择跳过
    if (skipped) {
      //跳过
      res = res + dfs(curDigital + 1, true, false, memo);
    }
    //skipped：true, 且当前不跳过, 之前都跳过了, 既然当前不能跳过, 那么最小值应该从1开始
    //skipped：false, 当前不能选择跳过 之前填过数字, 当前可以填0
    for (int i : digitsNum) {
      if (i >= minDigital && i <= maxDigital) {
        res += dfs(curDigital + 1,
            false,
            isLimited && i == maxDigital, memo);
      }
    }
    memo[curDigital][skipped ? 1 : 0][isLimited ? 1 : 0] = res;
    return res;
  }
}
