package com.topic.pq;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 2931.购买物品的最大开销 优先队列
 * @create 2024-12-12 8:59
 */
public class MaxSpending {
  public long maxSpending(int[][] values) {
    long res = 0L;
    // 商店个数
    int m = values.length;
    // 每个商店商品个数
    int n = values[0].length;
    // int[]: {i, j}: i: 表示商店下标 j: 商品下标， 按values[i][j]升序
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> values[a[0]][a[1]]));
    // 初始化pq
    for (int i = 0; i < m; i++) {
      pq.offer(new int[]{i, n-1});
    }
    int curDay = 1;
    while (!pq.isEmpty()) {
      int[] arr = pq.poll();
      int curShop = arr[0];
      int curProduct = arr[1];
      res = res + (long) values[curShop][curProduct] * curDay;
      if (curProduct > 0) {
        pq.offer(new int[]{curShop, curProduct-1});
      }
      curDay++;
    }
    return res;
  }
}
