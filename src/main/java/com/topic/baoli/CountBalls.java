package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 1742. 盒子中小球的最大数量
 * @create 2025-02-13 19:42
 */
public class CountBalls {
  public int countBalls(int lowLimit, int highLimit) {
    int[] cnts = new int[46];
    int max = Integer.MIN_VALUE;
    for (int i = lowLimit; i <= highLimit ; i++) {
      int index = getBitSum(i);
      cnts[index]++;
      max = Math.max(max, cnts[index]);
    }
    return max;
  }

  private int getBitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    sum += num;
    return sum;
  }
}
