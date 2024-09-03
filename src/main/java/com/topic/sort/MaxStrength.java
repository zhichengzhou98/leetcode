package com.topic.sort;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2708
 * @create 2024-09-03 9:20
 */
public class MaxStrength {
  @Test
  void testFun() {
    int[] nums = {-1, -1};
    System.out.println(maxStrength(nums));
  }

  public long maxStrength(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    long res = 1L;
    //负数的数量
    int cnt = 0;
    //最大的负数
    int maxVal = Integer.MIN_VALUE;
    //是否有1
    boolean oneFlag = false;

    //负1的数量
    int cntNegOne = 0;
    for (int num : nums) {
      if (num == 1) {
        oneFlag = true;
      } else if (num == -1) {
        cntNegOne++;
      }
      if (num != 0) {
        res = res * Math.abs(num);
      }
      if (num < 0) {
        cnt++;
        maxVal = Math.max(num, maxVal);
      }
    }
    oneFlag = oneFlag || (cntNegOne >= 2);
    if (cnt % 2 == 1) {
      //负数个数为奇数 除以绝对值最小的负数
      res = res / Math.abs(maxVal);
    }
    if (res == 1) {
      return oneFlag ? res : 0;
    } else {
      return res;
    }
  }
}
