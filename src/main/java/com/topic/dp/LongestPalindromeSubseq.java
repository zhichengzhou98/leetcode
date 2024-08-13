package com.topic.dp;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-13 13:29
 */
public class LongestPalindromeSubseq {
  @Test
  void testFun() {
    System.out.println(longestPalindromeSubseq("bbbab"));
  }

  public int longestPalindromeSubseq(String s) {
    int len = s.length();
    int[][] dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j + i < len; j++) {
        //j表示起点， i表示字符串的长度
        if (i == 0) {
          dp[j][j + i] = 1;
        } else {
          char left = s.charAt(j);
          char right = s.charAt(j + i);
          if (left == right) {
            //即使i + 1 == j, 此时dp[i + 1][j - 1] == 0(默认值)
            //怎么保证更新dp[i][j]时，dp[i + 1][j - 1]已经更新
            //更新顺序len = j-i -> [0, len]
            dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
          } else {
            dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
          }
        }

      }
    }
    return dp[0][len - 1];
  }

  //错误写法
  public int longestPalindromeSubseqV1(String s) {
    int len = s.length();
    int[][] dp = new int[len][len];
    //先初始化
    for (int i = 0; i < len; i++) {
      dp[i][i] = 1;
    }
    //dp[i][j]表示 [i,j]之间最长的回文字符串
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        if (i != j) {
          char left = s.charAt(i);
          char right = s.charAt(j);
          if (left == right) {
            //即使i + 1 == j, 此时dp[i + 1][j - 1] == 0(默认值)
            //怎么保证更新dp[i][j]时，dp[i + 1][j - 1]已经更新
            //更新顺序len = j-i -> [0, len]
            dp[i][j] = dp[i + 1][j - 1] + 2;
          } else {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
          }
        }
      }
    }
    return dp[0][len - 1];
  }
}
