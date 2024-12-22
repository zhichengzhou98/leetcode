package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3226. 使两个整数相等的位更改次数
 * @create 2024-11-02 11:13
 */
public class MinChanges {
  @Test
  void testFun() {
    System.out.println(minChanges(54,4));
  }

  public int minChangesV1(int n, int k) {
    String nStr = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
    String kStr = new StringBuilder(Integer.toBinaryString(k)).reverse().toString();
    int res = 0;
    if (kStr.length() > nStr.length()) {
      return -1;
    }
    int index = 0;
    while (index < nStr.length()) {
      if (index >= kStr.length()) {
        if (nStr.charAt(index) == '1') {
          res++;
        }
      } else {
        char c1 = nStr.charAt(index);
        char c2 = kStr.charAt(index);
        if (c1 != c2) {
          if (c1 == '1') {
            res++;
          }else {
            return -1;
          }
        }
      }
      index++;
    }
    return res;
  }
  public int minChanges(int n, int k) {
    int res = 0;
    while (n >= 1) {
       int t1 = n % 2;
       int t2 = k % 2;
       if (t1!= t2) {
         if(t1 == 1) {
           res++;
         } else {
           return -1;
         }
       }
       n = n >> 1;
       k = k >> 1;
    }
    if (k >=1) {
      return -1;
    }
    return res;
  }
}
