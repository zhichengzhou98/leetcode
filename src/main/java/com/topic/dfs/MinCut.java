package com.topic.dfs;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 132. 分割回文串 II dfs
 * @create 2025-03-02 17:49
 */
public class MinCut {
  public static void main(String[] args) {
    MinCut mc = new MinCut();
    long begin = System.currentTimeMillis();
    System.out.println(mc.minCut("bb"));
    System.out.println(System.currentTimeMillis() - begin);
  }

  // [i, j] 是否是回文字符串 0： 未遍历 1： 是 -1： 不是
  int[][] isPalindrome;
  int[] memo;
  String s;

  public int minCut(String s) {
    this.s = s;
    isPalindrome = new int[s.length()][s.length()];
    // init isPalindrome
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < s.length() - i + 1; j++) {
        // 起始坐标 j, 结束： j + i - 1
        int end = j + i - 1;
        if (j == end) {
          isPalindrome[j][end] = 1;
          continue;
        }
        if (s.charAt(j) == s.charAt(end)) {
          if (end - 1 <= j + 1) {
            isPalindrome[j][end] = 1;
          } else {
            isPalindrome[j][end] = isPalindrome[j + 1][end - 1];
          }
        } else {
          isPalindrome[j][end] = -1;
        }
      }
    }
    memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return dfs(s.length() - 1);
  }

  private int dfs(int index) {
    if (index <= 0 || isPalindrome[0][index] == 1) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    int res = Integer.MAX_VALUE;
    for (int i = 1; i <= index; i++) {
      if (isPalindrome[i][index] == 1) {
        res = Math.min(res, 1 + dfs(i - 1));
      }
    }
    memo[index] = res;
    return res;
  }
}
