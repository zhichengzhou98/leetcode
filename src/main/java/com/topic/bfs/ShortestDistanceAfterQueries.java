package com.topic.bfs;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 3243. 新增道路查询后的最短距离 I BFS
 * @create 2024-11-19 20:04
 */
public class ShortestDistanceAfterQueries {
  @Test
  void testFun() throws IOException {
    int[][] q = ArrayUtils.generate("array", int[][].class);
    System.out.println(Arrays.toString(shortestDistanceAfterQueries(500, q)));
  }
  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    int len = queries.length;
    int[] res = new int[len];

    // 每个节点的下一个节点
    List[] nexts = new List[n];
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = new ArrayList<Integer>();
      if (i < nexts.length - 1) {
        nexts[i].add(i + 1);
      }
    }
    for (int i = 0; i < len; i++) {
      int[] q = queries[i];
      int begin = q[0];
      int end = q[1];
      // 更新nexts
      nexts[begin].add(end);

      // bfs
      Queue<int[]> queue = new ArrayDeque<>();
      boolean[] isVisited = new boolean[n];
      queue.offer(new int[]{0,0});
      isVisited[0] = true;
      while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        List<Integer> next = nexts[poll[0]];
        boolean flag = false;
        for(int node : next) {
          if (!isVisited[node]) {
            if (node == n-1) {
              flag = true;
              break;
            } else {
              isVisited[node] = true;
              queue.offer(new int[]{node, poll[1] + 1});
            }
          }

        }
        if (flag) {
          res[i] = poll[1] + 1;
          break;
        }
      }
    }
    return res;
  }
}
