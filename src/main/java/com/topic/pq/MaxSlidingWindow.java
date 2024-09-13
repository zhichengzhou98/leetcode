package com.topic.pq;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 239 滑动窗口最大值
 * @create 2024-09-13 9:13
 */
public class MaxSlidingWindow {
  //优先队列 nlog(n)
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    //队列中的元素未nums索引
    Queue<Integer> pq = new PriorityQueue<>((a,b) -> nums[b] - nums[a]);
    for (int i = 0; i < k; i++) {
      pq.offer(i);
    }
    res[0] = nums[pq.peek()];

    for (int i = k; i < nums.length; i++) {
      //当前窗口最后一个索引为i 第一个索引为 i-k + 1
      //当前元素放入队列
      pq.offer(i);
      //移除不在窗口中的元素
      while (!pq.isEmpty() && pq.peek() < i -k + 1) {
        pq.poll();
      }
      res[i - k + 1] = nums[pq.peek()];
    }
    return res;
  }
}
