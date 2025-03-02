package com.topic.dfs;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2025-03-02 17:26
 */
public class MinCutV1 {
  public static void main(String[] args) {
    MinCutV1 mc = new MinCutV1();
    long begin = System.currentTimeMillis();
    System.out.println(mc.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    System.out.println(System.currentTimeMillis() - begin);
  }
  // [i, j] 是否是回文字符串 0： 未遍历 1： 是 -1： 不是
  int[][] isPalindrome;
  int[] memo;
  String s;

  public int minCut(String s) {
    this.s = s;
    isPalindrome = new int[s.length()][s.length()];
    memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return dfs(s.length()-1);
  }

  private int dfs(int index) {
    if (index <= 0 || checkIsPalindrome(0, index)) {
      return 0;
    }
    if (memo[index] != -1) {
      return memo[index];
    }
    int res = Integer.MAX_VALUE;
    for (int i = 1; i <= index; i++) {
      if (checkIsPalindrome(i, index)) {
        res = Math.min(res, 1 + dfs(i-1));
      }
    }
    memo[index] = res;
    return res;
  }

  private boolean checkIsPalindrome(int l, int r) {
    if (isPalindrome[l][r] != 0) {
      return isPalindrome[l][r] == 1;
    }
    if (l >= r) {
      isPalindrome[l][r] = 1;
      return true;
    }
    if (s.charAt(l) == s.charAt(r)) {
      return checkIsPalindrome(l + 1, r - 1);
    } else {
      isPalindrome[l][r] = -1;
      return false;
    }
  }
}
