package com.topic.dijkstra;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 743
 * @create 2024-08-08 18:14
 */
public class NetworkDelayTime {
  @Test
  void testFun() throws IOException {
    int[][] times = ArrayUtils.generate("array", int[][].class);
    System.out.println(networkDelayTime(times, 4 , 2));
  }

  int[] distances;

  public int networkDelayTime(int[][] times, int n, int k) {
    //标记节点是否被访问
    distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[k] = 0;
    //建图 lists[i]表示节点i的下一个节点 List<int[]> 0: 下一个节点， 1: 距离
    List<int[]>[] lists = new List[n + 1];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<>();
    }

    for (int[] time : times) {
      int begin = time[0];
      int end = time[1];
      int distance = time[2];
      lists[begin].add(new int[]{end, distance});
    }
    dijkstra(lists, k);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < distances.length; i++) {
      int num = distances[i];
      max = Math.max(max, num);
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }

  private void dijkstra(List<int[]>[] lists, int begin) {
    //0: 点  1: distance
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{begin, 0});
    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];
      int dis = current[1];
      List<int[]> nexts = lists[node];
      for (int[] next : nexts) {
        int nextNode = next[0];
        int nextDis = next[1];
        if (nextDis + dis >= distances[nextNode]) {
          continue;
        }
        distances[nextNode] = nextDis + dis;
        pq.offer(new int[]{nextNode, distances[nextNode]});
      }
    }
  }
}
