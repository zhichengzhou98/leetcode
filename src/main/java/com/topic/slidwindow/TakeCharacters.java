package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2516 1.不定长滑动窗口o(n) 2.二分+定长滑窗o(nlogn)
 * @create 2024-09-27 9:04
 */
public class TakeCharacters {
  @Test
  void testFun() {
    System.out.println(takeCharacters("aabaaaacaabc", 2));
  }

  //不定长滑窗
  public int takeCharacters(String s, int k) {
    //统计a b c字符个数
    int cntA = 0;
    int cntB = 0;
    int cntC = 0;
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'a':
          cntA++;
          break;
        case 'b':
          cntB++;
          break;
        default:
          cntC++;
      }
    }
    if (cntA < k || cntB < k || cntC < k) {
      return -1;
    }
    int res = s.length();
    int maxLength = Integer.MIN_VALUE;
    int left = 0;
    int[] window = new int[]{cntA, cntB, cntC};
    //保证窗口中的字符个数大于等于k
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      window[s.charAt(right) - 'a']--;
      //当不满足条件时 左端点左移 直到满足条件
      while (!check(window, k)) {
        //不满足条件
        //左端点左移 直到满足条件
        window[s.charAt(left) - 'a']++;
        left++;
      }
      //满足条件
      //if (check(window, k)) {
      //统计窗口的长度
      maxLength = Math.max(maxLength, right - left + 1);
      //}
    }
    return res - maxLength;
  }

  private boolean check(int[] window, int k) {
    for (int cnt : window) {
      if (cnt < k) {
        return false;
      }
    }
    return true;
  }
}
