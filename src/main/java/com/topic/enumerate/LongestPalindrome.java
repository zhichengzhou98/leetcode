package com.topic.enumerate;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 5最长回文子串 枚举中间字符
 * @create 2024-10-14 15:45
 */
public class LongestPalindrome {
  @Test
  void testFun() {
    System.out.println(longestPalindrome("cbbd"));
  }

  public String longestPalindrome(String s) {
    int len = s.length();
    int res = 1;
    String str = s.substring(0, 1);
    //枚举中间字符
    //回文字符串长度为奇数
    for (int i = 1; i < len - 1; i++) {
      int left = i - 1;
      int right = i + 1;
      while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (right - left - 1 > res) {
        str = s.substring(left + 1, right);
        res = right - left - 1;
      }
    }
    //字符串长度为偶数
    int r = 1;
    while (true) {
      while (r < len && s.charAt(r) != s.charAt(r - 1)) {
        r++;
      }
      if (r == len) {
        break;
      }
      int left = r - 2;
      int right = r + 1;
      while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (right - left - 1 > res) {
        str = s.substring(left + 1, right);
        res = right - left - 1;
      }
      r++;
    }
    return str;
  }
}
