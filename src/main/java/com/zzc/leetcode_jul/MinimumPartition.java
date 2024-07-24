package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2522 贪心
 * @create 2024-07-24 17:13
 */
public class MinimumPartition {
  @Test
  void testFun() {
    System.out.println(minimumPartition("165462",60));
  }
  public int minimumPartition(String s, int k) {
    if (k < 9) {
      //统计s中最大的数值
      int maxValue = s.charAt(0) - '0';
      for (int i = 1; i < s.length(); i++) {
        maxValue = Math.max(maxValue, s.charAt(i) - '0');
      }
      if (maxValue > k) {
        return -1;
      }
    }
    int left = 0;
    int res = 0;
    while (true) {
      int right = left;
      while (right < s.length()) {
        String currentStr = s.substring(left, right + 1);
        if (Long.parseLong(currentStr) <= k) {
          right++;
        } else {
          res++;
          left = right;
          break;
        }
      }

      if (right >= s.length()) {
        res++;
        break;
      }
    }

    return res;
  }
}
