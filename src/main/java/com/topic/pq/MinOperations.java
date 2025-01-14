package com.topic.pq;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 3066.超过阈值的最少操作数 II
 * @create 2025-01-14 08:00
 */
public class MinOperations {
  public int minOperations(int[] nums, int k) {
    // 小顶堆
    Queue<Long> pq = new PriorityQueue<>();
    for (long num : nums) {
      pq.offer(num);
    }
    int res = 0;
    while (pq.size() >= 2) {
      if (pq.peek() >= k) {
        return res;
      }
      Long num1 = pq.poll();
      Long num2 = pq.poll();
      pq.offer(num1 * 2 + num2);
      res++;
    }
    return res;
  }
}
