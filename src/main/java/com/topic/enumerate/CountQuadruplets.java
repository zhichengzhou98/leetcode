package com.topic.enumerate;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2552 枚举中间值 1 3 2 4
 * @create 2024-09-10 10:19
 */
public class CountQuadruplets {
  @Test
  void testFun() {
    int[] arr ={1,3,2,4,5};
    System.out.println(countQuadruplets(arr));
  }
  public long countQuadruplets(int[] nums) {
    long res = 0L;
    int size = nums.length;
    int[][] preSuf = new int[size][size];
    //分别计算前后缀小于/大于当前数的个数
    for (int i = 1; i < preSuf.length - 1; i++) {
      int[] tmp = preSuf[i];
      int cur = nums[i];
      int lessCnts = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < cur) {
          lessCnts++;
        }
        tmp[j] = lessCnts;
      }
      int greaterCnts = 0;
      for (int j = size - 1; j > i; j--) {
        if (nums[j] > cur) {
          greaterCnts++;
        }
        tmp[j] = greaterCnts;
      }
    }
    //枚举中间两个数
    for (int i = 1; i < size - 2; i++) {
      int sec = nums[i];
      for (int j = i + 1; j < size - 1; j++) {
        int third = nums[j];
        if (third < sec) {
          res += (long) preSuf[i][j] * preSuf[j][i];
        }
      }
    }
    return res;
  }
}
