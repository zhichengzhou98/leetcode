package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-21 11:36
 */
public class MaximumSum {
  @Test
  void testFun() {
    int[] res = {-50};
    System.out.println(maximumSum(res));
  }

  public int maximumSum(int[] arr) {
    int[][] res = new int[arr.length][2];
    //res[j][0]: 以j结尾 且一个元素都没有移除
    //res[j][1]: 以j结尾 且移除了一个元素
    res[0][0] = arr[0];
    res[0][1] = 0;
    int result = res[0][0];
    for (int i = 1; i < arr.length; i++) {
      res[i][0] = Math.max(res[i - 1][0] + arr[i], arr[i]);
      res[i][1] = Math.max(res[i - 1][1] + arr[i], res[i - 1][0]);
      result = Math.max(result, Math.max(res[i][0], res[i][1]));
    }
    return result;
  }
}
