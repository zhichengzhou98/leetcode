package com.topic.twopointer;

/**
 * @author zc.zhou
 * @Description 2414
 * @create 2024-09-19 9:54
 */
public class LongestContinuousSubstring {

  public int longestContinuousSubstring(String s) {
    int res = 1;
    int left = 0;
    int right = left + 1;
    while (right < s.length()) {
      while (right < s.length() && (s.charAt(right) - s.charAt(right - 1)) == 1) {
        right++;
      }
      res = Math.max(res, right - left);
      left = right;
      right = left + 1;
    }
    return res;
  }
}
