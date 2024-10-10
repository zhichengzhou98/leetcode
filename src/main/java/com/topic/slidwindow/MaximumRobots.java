package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zc.zhou
 * @Description 2398 滑动窗口 o(n) --> 求滑动窗口中的最大值 o(n) -> 求最长长度
 * 对比求最小长度 76最小覆盖字串 求最短长度
 * @create 2024-10-10 16:52
 */
public class MaximumRobots {
  @Test
  void testFun() {
    int[] c = {11,12,19};
    int[] r = {10,8,7};
    long b = 19;
    System.out.println(maximumRobots(c, r, b));
  }

  public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    //max(chargeTimes) + k * sum(runningCosts) <= budget
    int res = Integer.MIN_VALUE;
    int left = 0;

    //使用双端队列  队列从做到右依次递减 窗口中的最大值再最左侧
    //队列中存储nums索引
    Deque<Integer> deque = new ArrayDeque<>();

    //k * sum(runningCosts)
    long sum = 0;

    //枚举右端点
    //满足条件时一直右移 直到不满足
    for (int right = 0; right < chargeTimes.length; right++) {
      //将right放入队列
      //更新deque，求出此时队列窗口中的最大值
      int curRight = chargeTimes[right];
      while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= curRight) {
        deque.pollLast();
      }
      deque.offerLast(right);
      int maxChargeTime = chargeTimes[deque.peekFirst()];
      //更新sum
      sum += runningCosts[right];
      //k为区间中机器人个数
      int k = right - left + 1;
      //不满足条件时，左端点左移直到满足条件
      while (maxChargeTime + k * sum > budget) {
        sum -= runningCosts[left];
        k--;
        //区间左移
        left++;
        //更新deque
        while (!deque.isEmpty() && deque.peekFirst() < left) {
          deque.pollFirst();
        }
        if (deque.isEmpty()) {
          break;
        }
        maxChargeTime = chargeTimes[deque.peekFirst()];
      }
      //left位置满足条件
      res = Math.max(res, right - (left) + 1);
    }
    return res;
  }
}
