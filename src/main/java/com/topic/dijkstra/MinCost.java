package com.topic.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 1928. 规定时间内到达终点的最小花费
 * @create 2024-10-03 16:50
 */
public class MinCost {
  int[][] distances;

  public int minCost(int maxTime, int[][] edges, int[] passingFees) {
    //节点个数
    int n = passingFees.length;
    distances = new int[n][maxTime + 1];
    //初始化到每个点的距离为最大值
    for (int[] dis : distances) {
      Arrays.fill(dis, Integer.MAX_VALUE);
    }
    distances[0][0] = passingFees[0];
    //初始化List
    List[] lists = new List[n];
    for (int i = 0; i < n; i++) {

      lists[i] = new ArrayList<int[]>();
    }
    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      int time = edge[2];
      lists[x].add(new int[]{y, time});
      lists[y].add(new int[]{x, time});
    }
    int res = Integer.MAX_VALUE;
    dijkstra(lists, 0, passingFees, maxTime);
    for (int num : distances[n - 1]) {
      res = Math.min(res, num);
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private void dijkstra(List<int[]>[] lists, int begin, int[] passingFees, int maxTime) {
    //0: 点  1: fee 2: time
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{begin, distances[0][0], 0});
    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int node = current[0];
      int fee = current[1];
      int curTime = current[2];
      List<int[]> nexts = lists[node];
      for (int[] next : nexts) {
        int nextNode = next[0];
        int nextDis = passingFees[nextNode];
        int time = next[1];
        //从当前路径到nextNode的距离 没有之前到nextNode的距离短，跳过更新
        if (curTime + time > maxTime || nextDis + fee >= distances[nextNode][curTime + time]) {
          continue;
        }
        //当前路线到nextNode的距离更近，更新此距离，并把nextNode放入优先队列
        distances[nextNode][curTime + time] = nextDis + fee;
        pq.offer(new int[]{nextNode, distances[nextNode][curTime + time], curTime + time});
      }
    }
  }
}
