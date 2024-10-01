package com.topic.twopointer;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2110 双指针
 * @create 2024-09-10 13:14
 */
public class GetDescentPeriods {
  @Test
  void testFun() {
    int[] p = {4,3,2,1,4};
    System.out.println(getDescentPeriods(p));
  }
  public long getDescentPeriods(int[] prices) {
    long res = 0;
    int size = prices.length;
    int l = 0;
    int r = 0;
    while (r < size) {
      while (r + 1 < size && prices[r + 1] + 1 == prices[r]) {
        r++;
      }
      res += sum(r -l + 1);
      if(r == size) {
        break;
      }
      r++;
      l = r;
    }
    return res;
  }

  /**
   *
   * @param n 求 1-n前n项和
   * @return
   */
  private long sum(int n) {
    return (1L + n) * n / 2;
  }
}
