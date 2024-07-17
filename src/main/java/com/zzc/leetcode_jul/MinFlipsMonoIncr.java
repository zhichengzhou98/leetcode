package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 926. 将字符串翻转到单调递增
 * @create 2024-07-17 9:15
 */
public class MinFlipsMonoIncr {

  @Test
  void testFun() {
    System.out.println(minFlipsMonoIncr("00110"));
  }
  public int minFlipsMonoIncr(String s) {
    //将字符串变成单调递增有两种方法：把某位变成0或变成1
    //dp
    char[] chars = s.toCharArray();
    int[][] res = new int[s.length()][2];
    //res[i][0] 把第i位变成0的最小操作次数
    //res[i][1] 把第i位变成1的最小操作次数
    if (chars[0] == '0') {
      res[0][0] = 0;
      res[0][1] = 1;
    } else {
      res[0][0] = 1;
      res[0][1] = 0;
    }
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == '0') {
        res[i][0] = res[i - 1][0];
        res[i][1] = Math.min(res[i - 1][0], res[i - 1][1]) + 1;
      } else {
        res[i][0] = res[i - 1][0] + 1;
        res[i][1] = Math.min(res[i - 1][0], res[i - 1][1]);
      }
    }
    return Math.min(res[s.length() -1][0], res[s.length() -1][1]);
  }
}
