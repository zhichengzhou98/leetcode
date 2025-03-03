package com.topic.dfs;

/**
 * @author zc.zhou
 * @Description 1278. 分割回文串 III
 * @create 2025-03-03 22:29
 */
public class PalindromePartition {
  public static void main(String[] args) {
    PalindromePartition pp = new PalindromePartition();
    System.out.println(pp.palindromePartition("aabbc", 3));
  }

  // [i, j] -> 把[i, j]子串变成回文串需要改变字符的个数
  int[][] isPalindrome;
  String s;
  int[][] memo;

  public int palindromePartition(String s, int k) {
    isPalindrome = new int[s.length()][s.length()];
    // init isPalindrome
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < s.length() - i + 1; j++) {
        // 起始坐标 j, 结束： j + i - 1
        int end = j + i - 1;
        if (s.charAt(j) == s.charAt(end)) {
          if (end - 1 <= j + 1) {
            isPalindrome[j][end] = 0;
          } else {
            isPalindrome[j][end] = isPalindrome[j + 1][end - 1];
          }
        } else {
          isPalindrome[j][end] = 1 + isPalindrome[j + 1][end - 1];
        }
      }
    }
    memo = new int[s.length()][k + 1];
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[0].length; j++) {
        if (j == 0) {
          memo[i][j] = Integer.MAX_VALUE;
        } else if (j == 1) {
          memo[i][j] = isPalindrome[0][i];
        } else {
          memo[i][j] = -1;
        }
      }
    }
    return dfs(s.length() - 1, k);
  }


  private int dfs(int index, int k) {
    if (k > index + 1) {
      // 不可能
      return Integer.MAX_VALUE;
    }
    if (index == -1) {
      return 0;
    }
    if (memo[index][k] != -1) {
      return memo[index][k];
    }
    long res = Integer.MAX_VALUE;
    for (int i = 0; i <= index; i++) {
      long num = isPalindrome[i][index];
      res = Math.min(res, num + dfs(i - 1, k - 1));
    }
    int tmp = (res >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) res;
    memo[index][k] = tmp;
    return tmp;
  }
}
