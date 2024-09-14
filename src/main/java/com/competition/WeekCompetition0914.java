package com.competition;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description dijkstra算法
 * @create 2024-09-14 22:25
 */
public class WeekCompetition0914 {
  @Test
  void testFun() throws IOException {
    List<List<Integer>> list = ArrayUtils.generate("array", List.class, List.class, Integer.class);
    System.out.println(findSafeWalk(list, 4));
  }


  private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  int m;
  int n;

  public boolean findSafeWalk(List<List<Integer>> grid, int health) {
    this.m = grid.size();
    this.n = grid.get(0).size();
    //记录每个点的最小消耗值
    int[][] dp = new int[m][n];
    for (int[] arr : dp) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }
    dp[0][0] = grid.get(0).get(0);
    dijkstra(grid, dp);

    return health > dp[m - 1][n - 1];
  }

  private void dijkstra(List<List<Integer>> grid, int[][] distances) {
    //0, 1: 点  2: distance
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    pq.offer(new int[]{0, 0, grid.get(0).get(0)});
    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int nodeX = current[0];
      int nodeY = current[1];
      int dis = current[2];
      for (int[] dir : dirs) {
        int newX = nodeX + dir[0];
        int newY = nodeY + dir[1];
        // 检查新位置是否在边界内且未被访问过
        if (!isValid(newX, newY) || grid.get(newX).get(newY) + dis >= distances[newX][newY]) {
          continue;
        }
        //当前路线到nextNode的距离更近，更新此距离，并把nextNode放入优先队列
        distances[newX][newY] = grid.get(newX).get(newY) + dis;
        pq.offer(new int[]{newX, newY, distances[newX][newY]});
      }
    }
  }

  private boolean isValid(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
