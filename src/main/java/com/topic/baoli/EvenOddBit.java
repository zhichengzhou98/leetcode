package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description [2595]奇偶位数
 * @create 2025-02-20 14:16
 */
public class EvenOddBit {
  // answer = [even, odd] even: 值为1的偶数下标的个数
  public int[] evenOddBit(int n) {
    int[] res = new int[2];
    //当前索引
    int index = 0;
    while (n > 0) {
      int cur = n % 2;
      if (cur == 1) {
        if ((index % 2) == 0) {
          res[0]++;
        } else {
          res[1]++;
        }
      }
      n = (n >> 1);
      index++;
    }
    return res;
  }
}
