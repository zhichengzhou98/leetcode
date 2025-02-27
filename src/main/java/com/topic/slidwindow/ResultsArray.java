package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 3255
 * @create 2024-08-22 18:14
 */
public class ResultsArray {
  @Test
  void testFun() {
    System.out.println(Arrays.toString(resultsArray(new int[]{1,7,8}, 2)));
  }

  public int[] resultsArrayV1(int[] nums, int k) {
    if (k == 1) {
      return nums;
    }
    int[] res = new int[nums.length - k + 1];
    int right = 0;
    int cnt = 1;
    while (right < k - 1) {
      if (nums[right + 1] - nums[right] == 1) {
        cnt++;
      } else {
        cnt = 1;
      }
      right++;
    }
    if (cnt == k) {
      res[0] = nums[right];
    } else {
      res[0] = -1;
    }
    //[] 1 2 5 4 5
    for (int i = 1; i < res.length; i++) {
      if (nums[right + 1] - nums[right] == 1) {
        cnt++;
      } else {
        cnt = 1;
      }
      if (cnt >= k) {
        res[i] = nums[right + 1];
      } else {
        res[i] = -1;
      }
      right++;
    }
    return res;
  }


  public int[] resultsArray(int[] nums, int k) {
    if (k == 1) {
      return nums;
    }
    int size = nums.length;
    int[] res = new int[size - k + 1];
    int cnt = 1;
    //计算首个元素
    for (int i = 1; i < k; i++) {
      if (nums[i] - nums[i - 1] == 1) {
        cnt++;
      } else {
        cnt = 1;
      }
    }
    if (cnt == k) {
      res[0] = nums[k - 1];
    } else {
      res[0] = -1;
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == 1) {
        cnt++;
      } else {
        cnt = 1;
      }
      if (cnt >= k) {
        res[i -k + 1] = nums[i];
      } else {
        res[i -k + 1] = -1;
      }
    }
    return res;
  }
}
