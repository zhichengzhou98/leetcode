package com.zzc.template;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-28 12:18
 */
public class IsPrime {
  @Test
  void testFun() {
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i < 100; i++) {
      if (isPrime(i)) {
        res.add(i);
      }
    }
    System.out.println(res);
  }
  public static boolean isPrime(int num) {
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
