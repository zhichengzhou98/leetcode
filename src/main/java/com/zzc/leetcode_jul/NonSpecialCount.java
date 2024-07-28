package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-28 13:38
 */
public class NonSpecialCount {
  public int nonSpecialCount(int l, int r) {
    //[l, r]区间总长度
    int len = r - l + 1;
    //统计区间中特殊的数字
    int count = 0;

    //求出[1, sqrt(r)]内所有的质数
    List<Integer> primes = new ArrayList<>();
    for (int i = 0; i <=  Math.sqrt(r); i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    //遍历所有的质数
    for(int num : primes) {
      if (num * num >= l && num * num <= r) {
        count++;
      }
    }
    return len - count;
  }

  private static boolean isPrime(int num) {
    // 1 is not a prime number
    if (num <= 1) {
      return false;
    }
    // 2 and 3 are prime numbers
    if (num <= 3) {
      return true;
    }
    // multiples of 2 and 3 are not primes
    if (num % 2 == 0 || num % 3 == 0) {
      return false;
    }
    // check from 5 to square root of num
    for (int i = 5; i * i <= num; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}
