package com.topic.binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 2398 二分答案 + 滑动窗口最大值 二分：logn 滑动窗口最大值: nlogn
 * @create 2024-09-13 9:37
 */
public class MaximumRobots {
  int[] c;
  int[] r;
  public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    this.c = chargeTimes;
    this.r = runningCosts;
    //max(chargeTimes) + k * sum(runningCosts) <= budget

    //寻找右边界
    int l = 0;
    int r = chargeTimes.length;
    return rightBoundary(l, r, budget);
  }

  //查找右边界 小于等于 target的最大值  checkMedRight 小于等于时为true！！！
  private int rightBoundary(int l, int r, long target) {
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(med, target)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return med;
  }

  private boolean checkMedRight(int k, long target) {
    long tmpSum = 0L;
    //队列中的元素为nums索引
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> c[b] - c[a]);
    for (int i = 0; i < k; i++) {
      pq.offer(i);
      tmpSum += r[i];
    }
    if (tmpSum * k + c[pq.peek()] <= target) {
      return true;
    }
    for (int i = k; i < c.length; i++) {
      //更新tmpSum
      tmpSum = tmpSum + r[i] - r[i-k];
      //当前窗口最后一个索引为i 第一个索引为 i-k + 1
      //当前元素放入队列
      pq.offer(i);
      //移除不在窗口中的元素
      while (!pq.isEmpty() && pq.peek() < i -k + 1) {
        pq.poll();
      }
      if (tmpSum * k + c[pq.peek()] <= target) {
        return true;
      }
    }
    return false;
  }
}
