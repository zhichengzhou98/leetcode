package com.zzc.template;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 1.判断质数 2.埃氏筛 3.欧氏筛
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

  @Test
  void testSieveOfEratosthenes() {
    List<Integer> res = sieveOfEratosthenes(100);
    System.out.println(res);
  }


  //埃氏筛，求小于等于n的所有质数
  public List<Integer> sieveOfEratosthenes(int n) {
    assert n >= 1;
    //质数数组，false: 是质数
    boolean[] primeFlag = new boolean[n];
    //从2开始筛选
    for (int i = 2; i * i < primeFlag.length; i++) {
      //当前数是质数
      if (!primeFlag[i]) {
        //标记 i的倍数为非质数
        for (int j = i * i; j < primeFlag.length; j+= i) {
          primeFlag[j] = true;
        }
      }
    }
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < primeFlag.length; i++) {
      if (!primeFlag[i]) {
        primes.add(i);
      }
    }
    return primes;
  }
}
