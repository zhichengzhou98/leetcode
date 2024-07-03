package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-03 17:03
 */
public class SumOfTheDigitsOfHarshadNumber {
  @Test
  void testFun() {
    System.out.println(sumOfTheDigitsOfHarshadNumber(23));
  }
  public int sumOfTheDigitsOfHarshadNumber(int x) {
    int copyX = x;
    int sum = 0;
    while (x >= 1) {
      sum += x % 10;
      x /= 10;
    }
    if (copyX % sum == 0) {
      return sum;
    }
    return -1;
  }
}
