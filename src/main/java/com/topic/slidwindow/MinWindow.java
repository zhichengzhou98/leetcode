package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 76最小覆盖字串 求最短
 * @create 2024-08-30 17:11
 */
public class MinWindow {
  //

  @Test
  void testFun() {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }

  public String minWindow(String s, String t) {
    //统计t每个字符出现的次数
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }
    int len = Integer.MAX_VALUE;
    String res = "";
    //滑动窗口
    int left = 0;
    int right = 0;
    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
    while (left <= right) {
      while (!checkCnts(map)) {
        if (right + 1 < s.length()) {
          //如果不满足 right右移
          right++;
          map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
        } else {
          return res;
        }
      }

      while (checkCnts(map) && left <= right) {
        //满足条件时更新res
        if (right - left + 1 < len) {
          //求最小值
          len = right - left + 1;
          res = s.substring(left, right + 1);
        }
        //left左移直到不满足条件
        map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
        left++;
      }
    }
    return res;
  }

  //判断cnts是否全为0 没有大于0 -> true
  private boolean checkCnts(Map<Character, Integer> cnts) {
    return !cnts.values().stream().anyMatch(n -> n > 0);
  }
}
