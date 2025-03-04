package com.topic.dfs;

/**
 * @author zc.zhou
 * @Description [1745]分割回文串 IV
 * @create 2025-03-04 17:44
 */
public class CheckPartitioning {
  public static void main(String[] args) {
    CheckPartitioning cp = new CheckPartitioning();
    System.out.println(cp.checkPartitioning("bcbddxy"));
  }
  // [i, j] -> 把[i, j] 是否是回文串
  boolean[][] isPalindrome;
  // 缓存
  int[][] memo;

  public boolean checkPartitioning(String s) {
    isPalindrome = new boolean[s.length()][s.length()];
    // init isPalindrome
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < s.length() - i + 1; j++) {
        // 起始坐标 j, 结束： j + i - 1
        int end = j + i - 1;
        if (s.charAt(j) == s.charAt(end)) {
          if (end - 1 <= j + 1) {
            isPalindrome[j][end] = true;
          } else {
            isPalindrome[j][end] = isPalindrome[j + 1][end - 1];
          }
        } else {
          isPalindrome[j][end] = false;
        }
      }
    }
    // -1: 未遍历 1: true 0: false
    memo = new int[s.length()][4];
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[0].length; j++) {
        if (j == 0) {
          // false
        } else if (j == 1){
          memo[i][j] = isPalindrome[0][i] ? 1 : 0;
        } else {
          memo[i][j] = -1;
        }
      }
    }
    return dfs(s.length() - 1, 3);
  }

  /**
   * [0, index] 能否分割成k个回文串
   *
   * @param index
   * @param k
   * @return
   */
  private boolean dfs(int index, int k) {
    if (k > index + 1) {
      return false;
    }
    if (index == -1) {
      return true;
    }
    if (memo[index][k] != -1) {
      return memo[index][k] == 1;
    }
    boolean res = false;
    for (int i = 0; i <= index ; i++) {
      if (isPalindrome[i][index]) {
        res = res || dfs(i-1, k-1);
      }
    }
    memo[index][k] = res ? 1 : 0;
    return res;
  }
}
