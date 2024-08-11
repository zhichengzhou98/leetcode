package com.competition;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-04 10:24
 */
public class WeekCompetition0804 {
  @Test
  void testFun() throws IOException {
    int[][] grid = ArrayUtils.generate("array", int[][].class);
    System.out.println(Arrays.toString(shortestDistanceAfterQueries(5, grid)));
  }

  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    int[][] graph = new int[n][2];
    for (int i = 0; i < n; i++) {
      graph[i] = new int[2];
    }
    for (int i = 0; i < n - 1; i++) {
      graph[i] = new int[]{i + 1, 1};
    }

    int[] result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int u = queries[i][0];
      int v = queries[i][1];
      //更新u的next节点
      int[] ints = graph[u];
      int cnt = 1;
      if (ints != null) {
        int len = ints[0];
        cnt = ints[1];
        if (v <= len) {
          result[i] = result[i - 1];
          continue;
        }
      }
      graph[u] = new int[]{v, cnt};
      //清空 u -> maxLen之间所有的线
      for (int j = u + 1; j < v; j++) {
        graph[j] = null;
      }
      result[i] = dijkstra(graph, n);
    }

    return result;
  }

  private int dijkstra(int[][] graph, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.add(new int[]{0, 0});

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int node = curr[0];
      int distance = curr[1];
      if (distance > dist[node] || graph[node] == null)
        continue;

      int nextNode = graph[node][0];
      int newDist = distance + graph[node][1];
      if (newDist < dist[nextNode]) {
        dist[nextNode] = newDist;
        pq.add(new int[]{nextNode, newDist});
      }

    }
    return dist[n - 1];
  }

  /*int res;

  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    //最后一个节点不需要
    Set<Integer>[] nexts = new Set[n - 1];
    //初始化nexts
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = new HashSet<>();
      nexts[i].add(i + 1);
    }
    int[] cnts = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      res = Integer.MAX_VALUE;
      //新建一条路
      int[] q = queries[i];
      int pre = q[0];
      int next = q[1];
      nexts[pre].add(next);
      //从当前节点开始
      boolean[] flag = new boolean[n];
      flag[0] = true;
      len(nexts, n - 1, 0, 0, flag);
      cnts[i] = res;
    }
    return cnts;
  }

  //从当前节点到最终节点的距离 回溯
  private void len(Set<Integer>[] nexts, int end, int current, int len, boolean[] flag) {
    Set<Integer> next = nexts[current];
    if (next == null || next.isEmpty()) {
      //无敌到达
      return;
    }
    for (int i : next) {
      if (flag[i]) {
        continue;
      }
      flag[i] = true;
      if (i == end) {
        //到达下一个节点
        res = Math.min(len + 1, res);
        flag[i] = false;
        //直接退出
        return;
      }
      len(nexts, end, i, len + 1, flag);
      flag[i] = false;
    }
  }*/
}
