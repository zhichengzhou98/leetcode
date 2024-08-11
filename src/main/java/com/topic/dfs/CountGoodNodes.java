package com.topic.dfs;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-11 15:25
 */
public class CountGoodNodes {
  @Test
  void testFun() throws IOException {
    int[][] e = ArrayUtils.generate("array", int[][].class);
    System.out.println(countGoodNodes(e));
  }

  int goodSize;
  List<Integer>[] lists;
  Map<Integer, Integer> countMap;

  private void buildTree(int[][] edges) {
    //根节点是0
    //统计每个节点的next
    List<Integer>[] nexts = new List[edges.length + 1];
    for (int i = 0; i < lists.length; i++) {
      nexts[i] = new ArrayList<>();
      lists[i] = new ArrayList<>();
    }
    for(int[] edge : edges) {
      nexts[edge[0]].add(edge[1]);
      nexts[edge[1]].add(edge[0]);
    }
    //从根节点开始建树
    boolean[] flag = new boolean[edges.length + 1];
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    while (!stack.isEmpty()) {
      Integer current = stack.pop();
      flag[current] = true;
      //统计current的下一个节点
      List<Integer> n = nexts[current];
      for(int next : n) {
        if (!flag[next]) {
          lists[current].add(next);
          stack.push(next);
        }
      }
    }
  }
  public int countGoodNodes(int[][] edges) {
    countMap = new HashMap<>();
    lists = new List[edges.length + 1];
    buildTree(edges);
    goodDfs(0);
    return goodSize;
  }
  private void goodDfs(int root) {
    //统计当前解点是不是好节点
    List<Integer> nexts = lists[root];
    if(nexts.isEmpty()) {
      goodSize++;
      return;
    }
    long count = nexts.stream().map(this::dfsCount).distinct().count();
    if (count == 1L) {
      goodSize++;
    }
    for (int next : nexts) {
      goodDfs(next);
    }
  }

  //统计以当前节点为根节点的子树的总节点数
  private int dfsCount(int root) {
    if(countMap.containsKey(root)) {
      return countMap.get(root);
    }
    List<Integer> nexts = lists[root];
    if (nexts.isEmpty()) {
      countMap.put(root, 1);
      return 1;
    }
    int count = 1;
    for (int next : nexts) {
      count += dfsCount(next);
    }
    countMap.put(root, count);
    return count;
  }
}
