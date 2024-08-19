package com.topic.dp;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 552学生出勤记录2
 * @create 2024-08-19 16:35
 */

public class CheckRecord {
  @Test
  void testFun() {
    System.out.println(checkRecord(2));
  }

  private static final int MOD = (int) Math.pow(10, 9) + 7;

  public int checkRecord(int n) {
    if (n == 1) {
      return 3;
    }
    //A L P
    //dp[i][j][k]: i 字符串的长度 j: 字符A的个数 取值0，1 k: 末尾连续L的个数 0，1，2
    //初始化
    long[][][] dp = new long[n + 1][2][3];
    dp[1][0][0] = 1;// P
    dp[1][0][1] = 1;// L
    dp[1][0][2] = 0;//
    dp[1][1][0] = 1;// A
    dp[1][1][1] = 0;//
    dp[1][1][2] = 0;//
   /* if (n == 2) {
      return 8;
    }
    dp[2][0][0] = 2;// PP LP
    dp[2][0][1] = 1;// PL
    dp[2][0][2] = 1;// LL
    dp[2][1][0] = 3;// AP PA LA
    dp[2][1][1] = 1;// AL
    dp[2][1][2] = 0;//*/
    for (int i = 2; i < n + 1; i++) {
      dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;//dp[i - 1][0][0]
      // + P
      dp[i][0][1] = dp[i - 1][0][0];//dp[i - 1][0][0] + L
      dp[i][0][2] = dp[i - 1][0][1];//dp[i - 1][0][1] + L

      //前面i-1个没有A + 前面i-1个有A
      dp[i][1][0] =
          (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
      //前面i-1个没有A + 前面i-1个有A
      //前面i-1个没有A => 不可能 因为最后一个是L 不是A
      dp[i][1][1] = dp[i - 1][1][0];
      //前面i-1个没有A => 不可能 因为最后一个是L 不是A
      dp[i][1][2] = dp[i - 1][1][1];
    }
    long res = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        res = (res + dp[n][i][j]) % MOD;
      }
    }
    return (int) res;
  }
}
