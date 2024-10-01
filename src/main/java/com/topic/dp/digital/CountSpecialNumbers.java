package com.topic.dp.digital;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 2376 统计特殊整数 1 <= n <= 2 * 10^9
 * @create 2024-09-20 9:16
 */
public class CountSpecialNumbers {

  @Test
  void testFun() {
    System.out.println(1 << 10);
    System.out.println(countSpecialNumbers(135));
  }

  //首位数字
  String strN;
  int len;

  public int countSpecialNumbers(int n) {
    this.strN = String.valueOf(n);
    //数值n的长度
    this.len = this.strN.length();

    Set<Integer> set = new HashSet<>();
    int curDigital = 0;
    int[][][][] memo = new int[len][1 << 10][2][2];
    for (int[][][] arr1 : memo) {
      for (int[][] arr2 : arr1) {
        for (int[] arr3 : arr2) {
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
   * @param usedNums   已经填过的数值
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private int dfs(int curDigital, int usedNums, boolean skipped, boolean isLimited,
                    int[][][][] memo) {
    if (curDigital == len) {
      //从 0 到 len - 1 都已经选完, 如果一直都是跳过，则这次不是一次有效的值
      return skipped ? 0 : 1;
    }
    if (memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0] != -1) {
      return memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0];
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
      res = res + dfs(curDigital + 1, usedNums, true, false, memo);
    }
    //skipped：true, 且当前不跳过, 之前都跳过了, 既然当前不能跳过, 那么最小值应该从1开始
    //skipped：false, 当前不能选择跳过 之前填过数字, 当前可以填0
    for (int i = minDigital; i <= maxDigital; i++) {
      if (((1 << i) & usedNums) == 0) {
        res += dfs(curDigital + 1,
            usedNums | (1 << i),
            false,
            isLimited && i == maxDigital, memo);
      }
    }
    memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0] = res;
    return res;
  }

  /**
   * 使用二进制数代替set
   *
   * @param curDigital 当前位，从第0位开始到len - 1
   * @param usedNums   已经填过的数值
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private int dfsV3(int curDigital, int usedNums, boolean skipped, boolean isLimited,
                  int[][][][] memo) {
    if (curDigital >= len) {
      return 0;
    }
    if (memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0] != -1) {
      return memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0];
    }
    int res = 0;
    //需要判断最后一位能否填0，如果前面全都跳过，如果继续跳过直接dfs到下一位
    //如果不跳过，则最小值从1开始
    //如果前面有没有跳过的，则最小值从0开始
    int minDigital = skipped ? 1 : 0;
    //能填的最大数值
    int maxDigital = isLimited ? (strN.charAt(curDigital) - '0') : 9;
    if (curDigital == len - 1) {
      //最后一位
      for (int i = minDigital; i <= maxDigital; i++) {
        if (((1 << i) & usedNums) == 0) {
          res++;
        }
      }
      return res;
    }
    //可以选择跳过
    if (skipped) {
      //跳过
      res = res + dfsV3(curDigital + 1, usedNums, true, false, memo);
    }
    //skipped：true, 且当前不跳过, 之前都跳过了, 既然当前不能跳过, 那么最小值应该从1开始
    //skipped：false, 当前不能选择跳过 之前填过数字, 当前可以填0
    for (int i = minDigital; i <= maxDigital; i++) {
      if (((1 << i) & usedNums) == 0) {
        res += dfsV3(curDigital + 1,
            usedNums | (1 << i),
            false,
            isLimited && i == maxDigital, memo);
      }
    }
    memo[curDigital][usedNums][skipped ? 1 : 0][isLimited ? 1 : 0] = res;
    return res;
  }

  /**
   * @param curDigital 当前位，从第0位开始到len - 1
   * @param usedNums   已经填过的数值
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private int dfsV2(int curDigital, Set<Integer> usedNums, boolean skipped, boolean isLimited) {
    if (curDigital >= len) {
      return 0;
    }
    int res = 0;
    //需要判断最后一位能否填0，如果前面全都跳过，如果继续跳过直接dfs到下一位
    //如果不跳过，则最小值从1开始
    //如果前面有没有跳过的，则最小值从0开始
    int minDigital = skipped ? 1 : 0;
    //能填的最大数值
    int maxDigital = isLimited ? (strN.charAt(curDigital) - '0') : 9;
    if (curDigital == len - 1) {
      //最后一位
      for (int i = minDigital; i <= maxDigital; i++) {
        if (!usedNums.contains(i)) {
          res++;
        }
      }
      return res;
    }
    //可以选择跳过
    if (skipped) {
      //跳过
      res = res + dfsV2(curDigital + 1, new HashSet<>(usedNums),
          skipped,
          false);
    }
    //skipped：true, 且当前不跳过 之前都跳过了，既然当前不能跳过，那么最小值应该从1开始
    //skipped：false 当前不能选择跳过 之前填过数字，当前可以填0
    for (int i = minDigital; i <= maxDigital; i++) {
      if (!usedNums.contains(i)) {
        Set<Integer> newSet = new HashSet<>(usedNums);
        newSet.add(i);
        res += dfsV2(curDigital + 1, newSet, false, isLimited && i == maxDigital);
      }
    }
    return res;
  }

  /**
   * @param curDigital 当前位，从第0位开始到len - 1
   * @param usedNums   已经填过的数值
   * @param skipped    表示之前的位是否都跳过了。true -> 当前可以继续跳过（最后一位不能跳过，要统计1-n的数），
   *                   只能填过数字 不能跳过false
   * @param isLimited  当前位是否有限制，n = 231 -> 首位如果填1， 0，则后面位没有限制， 首位如果填2，
   *                   第二位不能超过3
   * @return 满足添加的数的个数
   */
  private int dfsV1(int curDigital, Set<Integer> usedNums, boolean skipped, boolean isLimited) {
    if (curDigital >= len) {
      return 0;
    }
    int res = 0;
    int maxDigital = isLimited ? (strN.charAt(curDigital) - '0') : 9;
    if (curDigital == len - 1) {
      //需要判断最后一位能否填0
      int minDigital = skipped ? 1 : 0;
      //最后一位
      for (int i = minDigital; i <= maxDigital; i++) {
        if (!usedNums.contains(i)) {
          res++;
        }
      }
      return res;
    }

    //可以选择跳过
    if (skipped) {
      //跳过
      res = res + dfsV1(curDigital + 1, new HashSet<>(usedNums),
          skipped,
          false);
      //不跳过 之前都跳过了，既然当前不能跳过，那么最小值应该从1开始
      for (int i = 1; i <= maxDigital; i++) {
        if (!usedNums.contains(i)) {
          Set<Integer> newSet = new HashSet<>(usedNums);
          newSet.add(i);
          res += dfsV1(curDigital + 1, newSet, false, isLimited && i == maxDigital);
        }
      }

    } else {
      //不能选择跳过 之前填过数字，当前可以填0
      for (int i = 0; i <= maxDigital; i++) {
        if (!usedNums.contains(i)) {
          Set<Integer> newSet = new HashSet<>(usedNums);
          newSet.add(i);
          res += dfsV1(curDigital + 1, newSet, false, isLimited && i == maxDigital);
        }
      }
    }
    return res;
  }
}
