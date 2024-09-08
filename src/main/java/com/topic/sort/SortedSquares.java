package com.topic.sort;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-08 18:10
 */
public class SortedSquares {

  public int[] sortedSquares(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    int left = 0;
    if (nums[len - 1] <= 0) {
      left = len - 1;
    }
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < 0 && nums[i + 1] >= 0) {
        left = i;
      }
    }
    int right = left + 1;
    int i = 0;
    while (left >= 0 && right < len) {
      int tmpR = Math.abs(nums[right]);
      int tmpL = Math.abs(nums[left]);
      if (tmpL > tmpR) {
        res[i] = tmpR * tmpR;
        right++;
      } else {
        res[i] = tmpL * tmpL;
        left--;
      }
      i++;
    }
    while (left >= 0) {
      int tmpL = Math.abs(nums[left]);
      res[i] = tmpL * tmpL;
      left--;
      i++;
    }
    while (right < len) {
      int tmpR = Math.abs(nums[right]);
      res[i] = tmpR * tmpR;
      right++;
      i++;
    }
    return res;
  }

  public int[] sortedSquaresV1(int[] nums) {
    return Arrays.stream(nums).map(i -> i * i).sorted().toArray();
  }
}
