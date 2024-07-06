package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-06 20:06
 */
public class CountAlternatingSubarrays {
  @Test
  void testFun() {
    System.out.println(countAlternatingSubarrays(new int[]{0,1,1,1}));
  }

  public long countAlternatingSubarrays(int[] nums) {
    long res = 0L;
    int left = 0;
    int right = left + 1;
    while (right < nums.length) {
      if (nums[right] != nums[right - 1]) {
        right++;
      } else {
        long temp = (long)right - left;
        res += (1 + temp) * temp / 2;
        left = right;
        right = left + 1;
      }
    }
    long temp = (long) right - left;
    res += (1 + temp) * temp / 2;
    return res;
  }
}
