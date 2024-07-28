package com.zzc.weekcompetition;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-28 10:29
 */
public class WeekCompetition408 {
  @Test
  void testFun() {
    int[] nums = {1,2,3,4,5,14};
    System.out.println(canAliceWin(nums));
    System.out.println(numberOfSubstrings("101101"));
    //System.out.println(nonSpecialCount(4,16));
    //System.out.println(isNumSpecialCount(7));
  }

  public int numberOfSubstrings(String s) {
    int n = s.length();
    int[] ones = new int[n + 1]; // 前缀和数组，记录到当前位置为止的 '1' 的数量
    for (int i = 1; i <= n; i++) {
      ones[i] = ones[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
    }

    Deque<Integer> stack = new ArrayDeque<>(); // 单调栈，存储可能的起始位置索引
    int count = 0;
    return count;
  }


  public int numberOfSubstringsV1(String s) {
    //o(n²)
    int[] numOne = new int[s.length() + 1];
    for (int i = 1; i < numOne.length; i++) {
      numOne[i] = numOne[i-1];
      if (s.charAt(i - 1) == '1') {
        numOne[i] += 1;
      }
    }
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        //[i, j] count(1)
        int count1 = numOne[j + 1] - numOne[i];
        int count0 = (j + 1 - i) - count1;
        if (count1 >= count0 * count0) {
          res++;
        }
      }
    }
    return res;
  }

  public boolean canAliceWin(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int sum1 = 0;
    for(int num : nums) {
      if (num <= 9) {
        sum1 += num;
      }
    }
    return sum1 != sum - sum1;
  }

  public int nonSpecialCount(int l, int r) {
    List<Integer> primes = sieveOfEratosthenes((int)Math.sqrt(r));
    int specialCount = 0;


    for (int prime : primes) {
      int square = prime * prime;
      if (square >= l && square <= r) {
        specialCount++;
      }
    }


    int totalNumbers = r - l + 1;


    return totalNumbers - specialCount;
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


  // Helper function to generate prime numbers up to a given limit using the Sieve of Eratosthenes
  public static List<Integer> sieveOfEratosthenes(int limit) {
    boolean[] isPrime = new boolean[limit + 1];
    for (int i = 2; i <= limit; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i * i <= limit; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isPrime[j] = false;
        }
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }

    return primes;
  }

  private boolean isNumSpecialCount(int a) {
    if (a == 1 || a == 2 || a == 3) {
      return false;
    }
    if (a == 4) {
      return true;
    }
    int num = 1;
    for (int i = 2; i <= Math.sqrt(a) ; i++) {
      if (a % i == 0) {
        num++;
      }
      if (num > 2) {
        return false;
      }
    }
    return num == 2;
  }


}
