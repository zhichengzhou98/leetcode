package com.topic.dp.digital;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1012 至少有一位重复数字
 * @create 2024-09-20 11:07
 */
public class NumDupDigitsAtMostN {
  @Test
  void testFun() {
    System.out.println(numDupDigitsAtMostN(100));
  }

  String strN;
  int len;

  public int numDupDigitsAtMostN(int n) {
    this.strN = String.valueOf(n);
    //数值n的长度
    this.len = this.strN.length();
    int[][][][][] memo = new int[len][1 << 10][2][2][2];
    for (int[][][][] arr1 : memo) {
      for (int[][][] arr2 : arr1) {
        for (int[][] arr3 : arr2) {
          for (int[] arr4 : arr3) {
            Arrays.fill(arr4, -1);
          }
        }
      }
    }
    return dfs(0, 0, true, true, memo, false);
  }

  private int dfs(int curDigital, int usedNums, boolean skipped, boolean isLimited,
                  int[][][][][] memo, boolean isValid) {
    if (curDigital == len) {
      //从 0 到 len - 1 都已经选完, 如果一直都是跳过，则这次不是一次有效的值
      return skipped ? 0 : (isValid ? 1 : 0);
    }
    if (memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0][isValid ? 1 : 0] != -1) {
      return memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0][isValid ? 1 : 0];
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
      res = res + dfs(curDigital + 1, usedNums, true, false, memo, isValid);
    }
    //skipped：true, 且当前不跳过, 之前都跳过了, 既然当前不能跳过, 那么最小值应该从1开始
    //skipped：false, 当前不能选择跳过 之前填过数字, 当前可以填0
    for (int i = minDigital; i <= maxDigital; i++) {
      if (((1 << i) & usedNums) == 0) {
        //这次没有选到重复数字
        res += dfs(curDigital + 1,
            usedNums | (1 << i),
            false,
            isLimited && i == maxDigital, memo, isValid);
      } else {
        //选到重复数字
        res += dfs(curDigital + 1,
            usedNums,
            false,
            isLimited && i == maxDigital, memo, true);
      }
    }
    memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0][isValid ? 1 : 0] = res;
    return res;
  }
}
