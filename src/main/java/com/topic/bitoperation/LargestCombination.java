package com.topic.bitoperation;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2275. 按位与结果大于零的最长组合 位运算
 * @create 2025-01-12 18:46
 */
public class LargestCombination {
  @Test
  void test() {
    System.out.println(Math.pow(2,24));
  }
  public int largestCombination(int[] candidates) {
    int[] cnts = new int[24];
    for(int num : candidates) {
      // 统计num二进制表示中1的位置
      int res = 0;
      while (num > 0) {
        if (num % 2 == 1) {
          cnts[res]++;
        }
        res++;
        num = num >> 1;
      }
    }
    int res = 0;
    for(int num : cnts) {
      res = Math.max(res, num);
    }
    return res;
  }
}
