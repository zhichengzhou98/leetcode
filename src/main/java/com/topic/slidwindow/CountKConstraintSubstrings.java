package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3258. 统计满足 K 约束的子字符串数量 I
 * @create 2024-11-12 19:51
 */
public class CountKConstraintSubstrings {
  @Test
  void testFun() {
    System.out.println(countKConstraintSubstrings("10101", 1));
  }
  public int countKConstraintSubstrings(String s, int k) {
    // 滑动窗口
    int cnt0 = 0;
    int cnt1 = 0;
    int res = 0;
    int left = 0;
    // 枚举右端点 满足条件时 一直右移
    for (int right = 0; right < s.length(); right++) {
      char cR = s.charAt(right);
      if (cR == '0') {
        cnt0++;
      } else {
        cnt1++;
      }
      // 不满足条件时 左端点左移直到满足条件
      while (cnt0 > k && cnt1 > k) {
        char cL = s.charAt(left);
        if (cL == '0') {
          cnt0--;
        } else {
          cnt1--;
        }
        left++;
      }
      //满足条件
      res += right - left + 1;
    }
    return res;
  }
}
