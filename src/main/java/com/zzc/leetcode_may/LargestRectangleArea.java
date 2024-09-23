package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description 84柱状图中的最大的矩形
 * @create 2024-05-22 21:35
 */
public class LargestRectangleArea {
  //o(n²)
  public int largestRectangleAreaV1(int[] heights) {
    int res = 0;
    for (int i = 0; i < heights.length; i++) {
      int currentMin = heights[i];
      for (int j = i; j < heights.length; j++) {
        currentMin = Math.min(currentMin, heights[j]);
        res = Math.max(res, currentMin * (j - i + 1));
      }
    }
    return res;
  }
}
