package com.topic.presum;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 1524
 * @create 2024-08-02 16:46
 */
public class NumOfSubarrays {
  @Test
  void testFun() {
    int[] arr = new int[]{100, 100, 99, 99};
    System.out.println(numOfSubarrays(arr));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);

  //前缀和
  public int numOfSubarrays(int[] arr) {
    long[] sum = new long[arr.length + 1];
    long res = 0L;
    //统计前缀和中 和为奇数和偶数的个数
    int[] oddCnts = new int[arr.length + 1];
    int[] evenCnts = new int[arr.length + 1];
    evenCnts[0] = 1;
    for (int i = 1; i < sum.length; i++) {
      sum[i] = sum[i- 1] + arr[i - 1];
      oddCnts[i] = oddCnts[i - 1];
      evenCnts[i] = evenCnts[i - 1];
      if (sum[i] % 2 == 1) {
        oddCnts[i] += 1;
        res = (res + evenCnts[i - 1]) % MOD;
      } else {
        evenCnts[i] += 1;
        res = (res + oddCnts[i - 1]) % MOD;
      }
    }
    return (int)res;
  }
}
