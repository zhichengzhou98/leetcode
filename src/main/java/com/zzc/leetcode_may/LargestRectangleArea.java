package com.zzc.leetcode_may;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zc.zhou
 * @Description 84柱状图中的最大的矩形 同接雨水42
 * @create 2024-05-22 21:35
 */
public class LargestRectangleArea {
  @Test
  void testFun() {
    int[] arr = {2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangleArea(arr));
  }

  //o(n)
  public int largestRectangleArea(int[] heights) {
    //矩阵的最大高度一定在heights中
    //枚举每一个高度 找到这个高度左右两边第一个比它小的位置
    //找第一个比它小的位置 => 单调栈
    //left[i]表示 heights[i]左边第一个小于heights[i]的位置 （严格小于）
    //单调递增栈
    int[] left = new int[heights.length];
    //记录索引的位置
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(0);
    for (int i = 0; i < heights.length; i++) {
      int curH = heights[i];
      while (!deque.isEmpty() && heights[deque.peekLast()] >= curH) {
        deque.pollLast();
      }
      if (deque.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = deque.peekLast();
      }
      deque.offerLast(i);
    }
    //right[i]表示 heights[i]右边第一个小于heights[i]的位置 （严格小于）
    int[] right = new int[heights.length];
    deque.clear();
    for (int i = heights.length - 1; i >= 0; i--) {
      int curH = heights[i];
      while (!deque.isEmpty() && heights[deque.peekLast()] >= curH) {
        deque.pollLast();
      }
      if (deque.isEmpty()) {
        right[i] = heights.length;
      } else {
        right[i] = deque.peekLast();
      }
      deque.offerLast(i);
    }
    int res = 0;
    for (int i = 0; i < heights.length; i++) {
      res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
    }
    return res;
  }

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
