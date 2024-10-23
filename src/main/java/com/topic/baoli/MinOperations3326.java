package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3326. 使数组非递减的最少除法操作次数 nsqrt(n)
 * @create 2024-10-22 20:56
 */
public class MinOperations3326 {
  @Test
  void testFun() {
    int[] nums = {9, 2};
    System.out.println(minOperations(nums));
  }

  public int minOperations(int[] nums) {
    int res = 0;
    if (nums.length == 1) {
      return res;
    }
    int size = nums.length;
    for (int i = size - 2; i >= 0; i--) {
      if (nums[i] > nums[i + 1]) {
        //需要处理nums[i]
        //判断nums[i]是否是质数
        if (getNum(nums[i]) == nums[i]) {
          return -1;
        } else {
          nums[i] = getNum(nums[i]);
          if (nums[i] > nums[i + 1]) {
            return -1;
          }
          res++;
        }
      }
    }
    return res;
  }

  public int getNum(int num) {
    int maxNum = (int) (Math.sqrt(num) + 1);
    for (int i = 2; i <= maxNum; i++) {
      if (num % i == 0) {
        return i;
      }
    }
    return num;
  }

  public boolean isPrime(int n) {
    if (n <= 3) {
      return true;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
