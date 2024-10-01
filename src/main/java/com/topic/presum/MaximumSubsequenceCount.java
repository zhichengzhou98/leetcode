package com.topic.presum;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2207
 * @create 2024-09-24 9:03
 */
public class MaximumSubsequenceCount {
  @Test
  void testFun() {
    System.out.println(maximumSubsequenceCountV1("aaa", "aa"));
  }

  //两个字符相等
  public long maximumSubsequenceCount(String text, String pattern) {
    long res = 0L;
    int cnt0 = 0;
    int cnt1 = 0;
    char c0 = pattern.charAt(0);
    char c1 = pattern.charAt(1);
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == c0) {
        cnt0++;
      } else if (text.charAt(i) == c1) {
        cnt1++;
        res += cnt0;
      }
    }
    //两个字符相等
    if(c0 == c1) {
      res = (1L + cnt0) * cnt0 / 2;
      return res;
    }
    res = res + Math.max(cnt0, cnt1);
    return res;
  }
  public long maximumSubsequenceCountV1(String text, String pattern) {
    long res = 0L;
    int cnt0 = 0;
    int cnt1 = 0;
    StringBuilder sb = new StringBuilder();
    char c0 = pattern.charAt(0);
    char c1 = pattern.charAt(1);
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == c0) {
        cnt0++;
        sb.append(c0);
      } else if (text.charAt(i) == c1) {
        cnt1++;
        sb.append(c1);
      }
    }
    res = res + Math.max(cnt0, cnt1);
    String newText = sb.toString();
    //统计字符0 1 的个数
    int[] cnts = new int[newText.length()];
    //cnts[i]: 表示newText中前0-(i-1)个字符中c0的个数
    for (int i = 1; i < cnts.length; i++) {
      cnts[i] = cnts[i - 1];
      if (newText.charAt(i - 1) == c0) {
        cnts[i]++;
      }
    }
    //遍历newText
    for (int i = 0; i < newText.length(); i++) {
      if (newText.charAt(i) == c1) {
        res += cnts[i];
      }
    }
    return res;
  }
}
