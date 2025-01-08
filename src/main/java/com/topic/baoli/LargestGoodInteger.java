package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2264.字符串中最大的 3位相同数字
 * @create 2025-01-08 8:57
 */
public class LargestGoodInteger {
  public String largestGoodInteger(String num) {
    String res = "";
    int max = Integer.MIN_VALUE;
    for (int i = 2; i < num.length(); i++) {
      char c1 = num.charAt(i);
      char c2 = num.charAt(i - 1);
      char c3 = num.charAt(i - 2);
      if (c1 == c2 && c2 == c3 && (c1 - '0') > max) {
        max = (c1 - '0');
        res = num.substring(i - 2, i + 1);
      }
    }
    return res;
  }
}
