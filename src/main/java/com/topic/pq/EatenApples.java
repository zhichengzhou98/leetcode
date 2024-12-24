package com.topic.pq;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 1705 吃苹果的最大数目 贪心 + 优先队列
 * @create 2024-12-24 15:53
 */
public class EatenApples {
  @Test
  void testFun() {
    //int[] app = {1,2,3,5,2};
    int[] app = {3,0,0,0,0,2};
    //int[] days = {3,2,1,4,2};
    int[] days = {3,0,0,0,0,2};
    System.out.println(eatenApples(app, days));
  }
  // apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2] => 5
  public int eatenApples(int[] apples, int[] days) {
    // int[0]: 当前剩下的苹果数， int[1]: 过期的天数， 按照过期的天数升序排列
    Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    int res = 0;
    // 当前天数
    // days[0]: 绝对时间为0
    int i = 0;
    while (true) {
      if (i < apples.length && apples[i] > 0) {
        pq.offer(new int[]{apples[i],  days[i] + i});
      }
      while (!pq.isEmpty()) {
        int[] current = pq.peek();
        if (i >= current[1] || current[0] == 0) {
          // 过期 移除current 或者吃完
          pq.poll();
        } else {
          res++;
          current[0]--;
          break;
        }
      }
      if (pq.isEmpty() && i >= apples.length) {
        break;
      }
      i++;
    }
    return res;
  }

  public int eatenApplesV2(int[] apples, int[] days) {
    // int[0]: 当前剩下的苹果数， int[1]: 过期的天数， 按照过期的天数升序排列
    Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    int res = 0;
    // 当前天数
    // days[0]: 绝对时间为0
    int i;
    for (i = 0; i < apples.length; i++) {
      if (apples[i] > 0) {
        pq.offer(new int[]{apples[i],  days[i] + i});
      }
      while (!pq.isEmpty()) {
        int[] current = pq.peek();
        if (i >= current[1]) {
          // 过期 移除current
          pq.poll();
        } else {
          res++;
          if (current[0] >= 1) {
            current[0]--;
            if (current[0] == 0) {
              pq.poll();
            }
            break;
          }
        }
      }
    }
    while (true) {
      while (!pq.isEmpty()) {
        int[] current = pq.peek();
        if (i >= current[1]) {
          // 过期 移除current
          pq.poll();
        } else {
          res++;
          if (current[0] >= 1) {
            current[0]--;
            if (current[0] == 0) {
              pq.poll();
            }
            break;
          }
        }
      }
      if (pq.isEmpty()) {
        break;
      }
      i++;
    }
    return res;
  }
}
