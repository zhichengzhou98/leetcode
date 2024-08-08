package com.topic.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-08 18:14
 */
public class NetworkDelayTime {
  public int networkDelayTime(int[][] times, int n, int k) {
    //标记节点是否被访问
    boolean[] flag = new boolean[n];
    //建图 lists[i]表示节点i的下一个节点 List<int[]> 0: 下一个节点， 1: 距离
    List<int[]>[] lists = new List[n];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<>();
    }

    for (int[] time : times) {
      int begin = time[0];
      int end = time[1];
      int distance = time[2];
      lists[begin].add(new int[]{end, distance});
    }
    return -1;
  }

  private void dijkstra(List<int[]>[] lists, int begin) {

  }
}
