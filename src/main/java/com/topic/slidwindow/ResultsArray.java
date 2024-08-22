package com.topic.slidwindow;

/**
 * @author zc.zhou
 * @Description 3255
 * @create 2024-08-22 18:14
 */
public class ResultsArray {
  public int[] resultsArray(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    int left = 0;
    int right = k - 1;
    //[] 1 2 5 4 5
    while (right < nums.length) {
      //检查left right是否满足条件
      //连续 递增

      //
    }
    return res;
  }
}
