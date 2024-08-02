package com.topic.dp;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 1524
 * @create 2024-08-02 16:46
 */
public class NumOfSubarrays {
  @Test
  void testFun() {
    int[] arr = new int[]{1, 2};
    System.out.println(numOfSubarrays(arr));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);
  public int numOfSubarrays(int[] arr) {
    long[] res = new long[arr.length];
    if (arr[0] % 2 == 0) {
      res[0] = 0L;
    } else {
      res[0] = 1L;
    }
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] % 2 == 0) {
        //当前是偶数
      } else {
        //当前是奇数
      }
    }
    return (int) res[res.length - 1];
  }

}
