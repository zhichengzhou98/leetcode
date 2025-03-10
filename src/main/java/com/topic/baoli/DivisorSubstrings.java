package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description [2269]找到一个数字的 K美丽值
 * @create 2025-03-10 15:41
 */
public class DivisorSubstrings {
  public int divisorSubstrings(int num, int k) {
    int res = 0;
    String string = String.valueOf(num);
    int left = 0;
    int right = left + k;
    while (right <= string.length()) {
      int num1 = Integer.parseInt(string.substring(left, right));
      if (num1 != 0 && num % num1 == 0) {
        res++;
      }
      left++;
      right++;
    }
    return res;
  }
}
