package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3097. 或值至少为 K 的最短子数组 II 滑动窗口
 * @create 2025-01-17 19:43
 */
public class MinimumSubarrayLength {
  @Test
  void testFun() {
    int[] arr = {32, 97};
    System.out.println(minimumSubarrayLength(arr, 122));
    System.out.println(9 | 12);
    System.out.println(32 | 97);
  }

  public int minimumSubarrayLength(int[] nums, int k) {
    int res = Integer.MAX_VALUE;
    int[] cnts = new int[30];
    // 滑动窗口
    int right = 0;
    // 枚举左端点
    for (int left = 0; left < nums.length; left++) {
      while (!check(cnts, k) && right < nums.length) {
        // 不满足条件时right右移动
        this.handle(cnts, nums[right], true);
        right++;
      }
      // 满足条件
      if (check(cnts, k)) {
        res = Math.min(res, right - left);
      }
      // left右移动
      this.handle(cnts, nums[left], false);
    }
    return res == Integer.MAX_VALUE ? -1 : (Math.max(1, res));
  }

  private boolean check(int[] cnts, int k) {
    int res = 0;
    for (int i = 0; i < cnts.length; i++) {
      if (cnts[i] > 0) {
        res += (int) Math.pow(2, i);
      }
    }
    return res >= k;
  }

  private void handle(int[] cnts, int num, boolean flag) {
    int res = 0;
    while (num > 0) {
      if (flag) {
        cnts[res] += num % 2;
      } else {
        cnts[res] -= num % 2;
      }
      num = num / 2;
      res++;
    }
  }
}
