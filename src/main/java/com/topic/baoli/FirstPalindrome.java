package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2108
 * @create 2024-09-10 11:13
 */
public class FirstPalindrome {
  public String firstPalindrome(String[] words) {
    for (String str : words) {
      String newStr = new StringBuilder(str).reverse().toString();
      if (newStr.equals(str)) {
        return str;
      }
    }
    return "";
  }
}
