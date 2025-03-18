package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description [2614]对角线上的质数
 * @create 2025-03-18 14:39
 */
public class DiagonalPrime {
  public int diagonalPrime(int[][] nums) {
    int res = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (isPrime(nums[i][i])) {
        res = Math.max(res, nums[i][i]);
      }
      if (isPrime(nums[i][size - i - 1])) {
        res = Math.max(res, nums[i][size - i - 1]);
      }
    }
    return res;
  }

  public boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
