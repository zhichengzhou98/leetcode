package com.topic.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-08 21:43
 */
public class MaxPossibleScore {
  @Test
  void testFun() {
    int[] arr = {1000000000, 1000000000};
    System.out.println(maxPossibleScore(arr, 1000000000));
  }

  public int maxPossibleScore(int[] start, int d) {
    Arrays.sort(start);
    int len = start.length;
    long maxRes = (long) start[len - 1] + d;
    //二分找右边界
    return (int) rightBoundary(maxRes, start, d);
  }

  private long rightBoundary(long r, int[] start, int d) {
    long l = 0L;
    long med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(med, start, d)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return med;
  }

  private boolean checkMedRight(long med, int[] start, int d) {
    int len = start.length;
    //最后一个数
    long current = start[0];
    for (int i = 1; i < len; i++) {
      //判断后面的数有没有落到区间[start[i], start[i] + d]
      if (current + med > start[i] + d) {
        return false;
      } else {
        current = Math.max(start[i], current + med);
      }
    }
    return true;
  }
}
