package com.topic.pq;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 239 滑动窗口最大值
 * @create 2024-09-13 9:13
 */
public class MaxSlidingWindow {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    //使用双端队列  队列从做到右依次递减 窗口中的最大值再最左侧
    //队列中存储nums索引
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      while (!deque.isEmpty() && nums[deque.peekLast()] < current) {
        deque.pollLast();
      }
      deque.offer(i);
      //移除不在窗口中的元素
      while (!deque.isEmpty() && deque.peek() < i - k + 1) {
        deque.pollFirst();
      }
      if (i >= k - 1) {
        res[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return res;
  }

  //合并两个for
  public int[] maxSlidingWindowV2(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    //使用双端队列  队列从做到右依次递减 窗口中的最大值再最左侧
    //队列中存储nums索引
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      int current = nums[i];
      //队列中的索引小于当前索引，如果当前值大于队列中对于的值，那么滑窗最大值一定不可能在队列中
      while (!deque.isEmpty() && nums[deque.peekLast()] < current) {
        deque.pollLast();
      }
      deque.offer(i);
    }
    res[0] = nums[deque.peekFirst()];

    for (int i = k; i < nums.length; i++) {
      int current = nums[i];
      while (!deque.isEmpty() && nums[deque.peekLast()] < current) {
        deque.pollLast();
      }
      deque.offer(i);

      //移除不在窗口中的元素
      while (!deque.isEmpty() && deque.peek() < i - k + 1) {
        deque.pollFirst();
      }
      res[i - k + 1] = nums[deque.peekFirst()];
    }
    return res;
  }


  //优先队列 nlog(n)
  public int[] maxSlidingWindowV1(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    //队列中的元素为nums索引
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
    for (int i = 0; i < k; i++) {
      pq.offer(i);
    }
    res[0] = nums[pq.peek()];

    for (int i = k; i < nums.length; i++) {
      //当前窗口最后一个索引为i 第一个索引为 i-k + 1
      //当前元素放入队列
      pq.offer(i);
      //移除不在窗口中的元素
      while (!pq.isEmpty() && pq.peek() < i - k + 1) {
        pq.poll();
      }
      res[i - k + 1] = nums[pq.peek()];
    }
    return res;
  }
}
