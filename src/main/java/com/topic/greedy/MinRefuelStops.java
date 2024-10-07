package com.topic.greedy;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 871. 最低加油次数
 * @create 2024-10-07 09:46
 */
public class MinRefuelStops {
  @Test
  void testFun() throws IOException {
    int tar = 100;
    int startFuel = 50;
    int[][] s = ArrayUtils.generate("array", int[][].class);
    System.out.println(minRefuelStops(tar, startFuel, s));
  }

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    Queue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> -x));
    //当前加油站的索引
    int index = -1;
    pq.offer(startFuel);
    int cnts = -1;
    //当前已行驶距离
    int distance = 0;
    while (target > 0 && !pq.isEmpty()) {
      Integer maxFuel = pq.poll();
      cnts++;
      //还能行驶maxFuel距离
      distance += maxFuel;
      target -= maxFuel;
      //把这一次行驶途中的加油站放入队列
      while (index + 1 < stations.length) {
        if (stations[index + 1][0] > distance) {
          break;
        } else {
          pq.offer(stations[index + 1][1]);
          index++;
        }
      }
    }
    return target <= 0 ? cnts : -1;
  }
}
