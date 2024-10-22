package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3184/3185 构成整天的下标对数目 map
 * @create 2024-10-22 9:04
 */
public class CountCompleteDayPairs {
  @Test
  void testFun() {
    int[] h = {12,12,30,24,24};
    System.out.println(countCompleteDayPairs(h));
  }
  public int countCompleteDayPairsV1(int[] hours) {
    int[] cnts = new int[24];
    for(int num : hours) {
      cnts[num % 24]++;
    }
    int res = 0;
    for (int i = 0; i < cnts.length; i++) {
      if (i == 0 || i == 12) {
        res += cnts[i] * (cnts[i] - 1);
      }else {
        res += cnts[i] * cnts[(24-i)];
      }
    }
    return res/2;
  }

  public long countCompleteDayPairs(int[] hours) {
    long[] cnts = new long[24];
    for(int num : hours) {
      cnts[num % 24]++;
    }
    long res = 0;
    for (int i = 0; i < cnts.length; i++) {
      if (i == 0 || i == 12) {
        res += cnts[i] * (cnts[i] - 1);
      }else {
        res += cnts[i] * cnts[(24-i)];
      }
    }
    return res/2;
  }
}
