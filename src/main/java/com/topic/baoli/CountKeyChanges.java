package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3019.按键变更的次数
 * @create 2025-01-07 16:17
 */
public class CountKeyChanges {
  @Test
  void testFun() {
    String str = "aAbBcC";
    int i = countKeyChanges(str);
    System.out.println(i);
  }
  public int countKeyChanges(String s) {
    int size = s.length();
    int res = 0;
    for (int i = 1; i < size; i++) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(i-1);
      if (c1 != c2 && Math.abs(c1 - c2) != 32) {
        res++;
      }
    }
    return res;
  }
}
