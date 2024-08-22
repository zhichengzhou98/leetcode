package com.topic.bitoperation;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3133
 * @create 2024-08-22 14:34
 */
public class MinEnd {
  @Test
  void testFun() {
    System.out.println(parseBitStrTo10("1011"));
    System.out.println(minEnd(1, 10));
  }
  // n = 3 x= 4 res = 6
  //x: 4 -> 100
  //n: 3 -> 11

  //x: 10 -> 1010
  //n: 1 -> 1
  public long minEnd(int n, int x) {
    StringBuilder sb = new StringBuilder();
    n--;
    while (n > 0) {
      //取x最后一位
      while (x % 2 == 1) {
        sb.append('1');
        x = x / 2;
      }
      //此时x的最后一位为0
      //取n的最后一位
      sb.append(n % 2);
      n = n / 2;
      x = x / 2;
    }
    if (x > 0) {
      sb.append(new StringBuilder(Integer.toBinaryString(x)).reverse());
    }
    return parseBitStrTo10(sb.reverse().toString());
  }

  private long parseBitStrTo10(String s) {
    //将s反转
    String revS = new StringBuilder(s).reverse().toString();
    long res = 0;
    for (int i = 0; i < revS.length(); i++) {
      res += (long) ((revS.charAt(i) - '0') * Math.pow(2, i));
    }
    return res;
  }
}
