package com.topic.pq;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 1845. 座位预约管理系统
 * @create 2024-09-30 08:28
 */
public class SeatManager {
  Queue<Integer> pq;
  public SeatManager(int n) {
    pq = new PriorityQueue<>(n);
    for (int i = 1; i <= n; i++) {
      pq.offer(i);
    }
  }

  public int reserve() {
    return pq.poll();
  }

  public void unreserve(int seatNumber) {
    pq.offer(seatNumber);
  }
}
