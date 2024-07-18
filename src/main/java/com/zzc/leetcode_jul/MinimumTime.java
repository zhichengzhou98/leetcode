package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description TODO 迪杰斯特拉算法
 * @create 2024-07-18 13:32
 */
public class MinimumTime {
  @Test
  void testFun() {
    int n = 3;
    int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
    int[] disappear = {1, 1, 2};
    System.out.println(Arrays.toString(minimumTime(n, edges, disappear)));
  }

  public int[] minimumTime(int n, int[][] edges, int[] disappear) {
    //统计与每个点相连的点
    //list[i]: 表示与i节点相连的点，list的每个元素都是一个都是一个数组
    //arr[0]: 表示相连的点， arr[1]：表示距离
    List<int[]>[] lists = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int i = 0; i < edges.length; i++) {
      int p1 = edges[i][0];
      int p2 = edges[i][1];
      int dis = edges[i][2];
      lists[p1].add(new int[]{p2, dis});
      lists[p2].add(new int[]{p1, dis});
    }
    int[] answer = new int[n];
    Arrays.fill(answer, -1);
    answer[0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    //arr[0]: currentNode, arr[1]: distance
    pq.offer(new int[]{0, 0});
    while (!pq.isEmpty()) {
      int[] arr = pq.poll();
      int currentNode = arr[0];
      int distance = arr[1];
      //???
      if (answer[currentNode] != distance) {
        continue;
      }
      for (int[] nexts : lists[currentNode]) {
        int nextNode = nexts[0];
        int length = nexts[1];
        // distance + length < disappear[nextNode] 在nextNode节点消失之前能到达
        // answer[nextNode] == -1 -> 没有遍历过nextNode节点
        // distance + length < answer[nextNode] -> 遍历过nextNode节点但是有更近的距离
        if (distance + length < disappear[nextNode] && (answer[nextNode] == -1 || distance + length < answer[nextNode])) {
          pq.offer(new int[]{nextNode, distance + length});
          answer[nextNode] = distance + length;
        }
      }
    }
    return answer;
  }
}
