package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 位运算
 * @create 2024-07-26 15:30
 */
public class MinChanges {
  @Test
  void testFun() {
    System.out.println(minChanges(54, 4));
  }

  public int minChanges(int n, int k) {
    return (n & k) != k ? -1 : Integer.bitCount(n - k);
  }

  public int minChangesV2(int n, int k) {
    int res = 0;
    while (n > 0 && k > 0) {
      int temp1 = n % 2;
      int temp2 = k % 2;
      if (temp1 != temp2) {
        if (temp2 == 1) {
          return -1;
        } else {
          res++;
        }
      }
      n /= 2;
      k /= 2;
    }
    if (n == 0 && k > 0) {
      return -1;
    }

    while (n > 0) {
      int temp1 = n % 2;
      if (temp1 == 1) {
        res++;
      }
      n /= 2;
    }
    return res;
  }

  public int minChangesV1(int n, int k) {
    int res = 0;
    String str1 = Integer.toBinaryString(n);
    String str2 = Integer.toBinaryString(k);
    if (str2.length() > str1.length()) {
      return -1;
    }
    int i = str1.length() - 1;
    int j = str2.length() - 1;
    while (i >= 0 && j >= 0) {
      if (str1.charAt(i) != str2.charAt(j)) {
        if (str2.charAt(j) == '1') {
          return -1;
        } else {
          res++;
        }
      }
      i--;
      j--;
    }
    while (i >= 0) {
      if (str1.charAt(i) == '1') {
        res++;
      }
      i--;
    }
    return res;
  }
}
