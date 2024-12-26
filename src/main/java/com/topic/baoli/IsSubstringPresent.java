package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3083.字符串及其反转中是否存在同一子字符串
 * @create 2024-12-26 8:53
 */
public class IsSubstringPresent {
  public boolean isSubstringPresent(String s) {
    if (s.length() < 2) {
      return false;
    }
    for (int i = 1; i < s.length(); i++) {
      String reverse = String.valueOf(s.charAt(i)) + s.charAt(i - 1);
      if (s.contains(reverse)) {
        return true;
      }
    }
    return false;
  }
}
