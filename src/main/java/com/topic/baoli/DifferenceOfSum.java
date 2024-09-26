package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-26 9:01
 */
public class DifferenceOfSum {
  @Test
  void testFun() {
    System.out.println(digitSum(25));
  }
  public int differenceOfSum(int[] nums) {
    int sum = 0;
    int digitSum = 0;
    for(int num : nums) {
      sum += num;
      digitSum += digitSum(num);
    }
    return Math.abs(sum - digitSum);
  }

  private int digitSum(int n) {
    int sum = 0;
    while (n >= 10) {
      sum += (n % 10);
      n /= 10;
    }
    sum += n;
    return sum;
  }

}
