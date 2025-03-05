package com.topic.greedy;

/**
 * @author zc.zhou
 * @Description 1328. 破坏回文串 贪心
 * @create 2025-03-05 19:54
 */
public class BreakPalindrome {
  public String breakPalindrome(String palindrome) {
    int n = palindrome.length();
    if (n == 1) {
      return "";
    }
    char[] chars = palindrome.toCharArray();
    for (int i = 0; i <= n / 2 - 1; i++) {
      if (chars[i] != 'a') {
        chars[i] = 'a';
        return new String(chars);
      }
    }
    chars[chars.length - 1] = 'b';
    return new String(chars);
  }
}
