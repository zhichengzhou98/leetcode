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

  public String minWindowV1(String s, String t) {
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

  public String minWindowV2(String s, String t) {
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
    return res;
  }

  public String minWindowV3(String s, String t) {
    //统计t每个字符出现的次数
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }
    int len = Integer.MAX_VALUE;
    String res = "";
    //滑动窗口
    int left = 0;
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      boolean flag = false;
      map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
      //当满足条件时 左端点左移 直到不满足条件
      while (checkCnts(map)) {
        map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
        left++;
        flag = true;
      }
      //不满足条件 left - 1时 是满足条件的
      if (flag && right - (left - 1) + 1 < len) {
        //求最小值
        len = right - (left - 1) + 1;
        res = s.substring(left - 1, right + 1);
      }
    }
    return res;
  }

  public String minWindowV4(String s, String t) {
    //统计t每个字符出现的次数
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }
    int len = Integer.MAX_VALUE;
    int leftRes = -1;
    int rightRes = -1;
    //滑动窗口
    int left = 0;
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
      //当满足条件时 左端点左移 直到不满足条件
      while (checkCnts(map)) {
        //满足条件
        if (right - (left) + 1 < len) {
          //求最小值
          len = right - (left) + 1;
          leftRes = left;
          rightRes = right + 1;
        }
        //左端点左移 直到不满足条件
        map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
        left++;

      }
    }
    return leftRes == -1 ? "" : s.substring(leftRes, rightRes);
  }

  //map => 数组
  public String minWindow(String s, String t) {
    //统计t每个字符出现的次数
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }
    int cnts = map.keySet().size();
    int len = Integer.MAX_VALUE;
    int leftRes = -1;
    int rightRes = -1;
    //滑动窗口
    int left = 0;
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      int curCnt = map.getOrDefault(s.charAt(right), 0) - 1;
      if (curCnt == 0) {
        cnts--;
      }
      map.put(s.charAt(right), curCnt);
      //当满足条件时 左端点左移 直到不满足条件
      while (cnts == 0) {
        //满足条件
        if (right - (left) + 1 < len) {
          //求最小值
          len = right - (left) + 1;
          leftRes = left;
          rightRes = right + 1;
        }
        //左端点左移 直到不满足条件
        curCnt = map.getOrDefault(s.charAt(left), 0) + 1;
        if (curCnt == 1) {
          cnts++;
        }
        map.put(s.charAt(left), curCnt);
        left++;
      }
    }
    return leftRes == -1 ? "" : s.substring(leftRes, rightRes);
  }

  //判断cnts是否全为0 没有大于0 -> true
  private boolean checkCnts(Map<Character, Integer> cnts) {
    return cnts.values().stream().noneMatch(n -> n > 0);
  }
}
