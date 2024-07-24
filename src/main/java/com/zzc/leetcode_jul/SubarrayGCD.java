package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2447 TODO 优化
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], k <= 10⁹
 * @create 2024-07-24 10:23
 */
public class SubarrayGCD {
  @Test
  void testFun() {
    int[] nums = {3,12,9,6};
    System.out.println(subarrayGCD(nums, 3));
  }

  public int subarrayGCD(int[] nums, int k) {
    int res = 0;
    //两层循环
    for (int i = 0; i < nums.length; i++) {
      //判断当前数是否是k的倍数
      if (nums[i] % k != 0) {
        continue;
      }
      if (nums[i] == k) {
        res++;
      }
      int currentMaxCommonDivisors = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] % k != 0) {
          break;
        }
        currentMaxCommonDivisors = maxCommonDivisors(currentMaxCommonDivisors, nums[j]);
        if (currentMaxCommonDivisors == k) {
          res++;
        } else if (currentMaxCommonDivisors < k) {
          break;
        }
      }
    }
    return res;
  }

  //求两个数的最大公因数
  public int maxCommonDivisors(int a, int b) {
    while (b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
  }

  //Error {3,12,9,6};
  public int subarrayGCDV1(int[] nums, int k) {
    int res = 0;
    int currentIndex = 0;
    while (currentIndex < nums.length) {
      while (currentIndex < nums.length && nums[currentIndex] != k) {
        currentIndex++;
      }
      if (currentIndex >= nums.length) {
        break;
      }
      int left = currentIndex - 1;
      while (left >= 0 && nums[left] != k && nums[left] % k == 0) {
        left--;
      }
      int right = currentIndex + 1;
      while (right < nums.length && nums[right] % k == 0) {
        right++;
      }
      res += (currentIndex - left) * (right - currentIndex);
      currentIndex++;
    }
    return res;
  }
}
