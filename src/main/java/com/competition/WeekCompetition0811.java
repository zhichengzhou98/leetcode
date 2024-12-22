package com.competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-11 10:29
 */
public class WeekCompetition0811 {
  private List<List<Integer>> tree;
  private int[] subtreeSizes;
  private int goodNodeCount;

  public int countGoodNodes(int[][] edges) {
    int n = edges.length + 1; // 节点总数
    tree = new ArrayList<>();
    subtreeSizes = new int[n];
    goodNodeCount = 0;

    // 构建邻接表
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      tree.get(u).add(v);
      tree.get(v).add(u);
    }

    // 从根节点 0 开始执行 DFS
    dfs(0, -1);

    return goodNodeCount;
  }

  // DFS 返回以节点 node 为根的子树的大小
  private int dfs(int node, int parent) {
    int size = 1; // 节点自身也算作子树的一部分

    int childSubtreeSize = -1; // 用来比较子节点的子树大小是否相同
    boolean isGood = true;

    for (int child : tree.get(node)) {
      if (child == parent) {
        continue; // 跳过父节点
      }

      int childSize = dfs(child, node); // 递归计算子树大小

      if (childSubtreeSize == -1) {
        childSubtreeSize = childSize;
      } else if (childSubtreeSize != childSize) {
        isGood = false; // 子树大小不同
      }

      size += childSize; // 计算当前节点的子树大小
    }

    if (isGood) {
      goodNodeCount++;
    }

    subtreeSizes[node] = size;
    return size;
  }
  public int finalPositionOfSnake(int n, List<String> commands) {
    int i = 0;
    int j = 0;
    //"UP"、"RIGHT"、"DOWN" 和 "LEFT"
    for(String cmd : commands) {
      if ("UP".equals(cmd)) {
        i--;
      }else if ("RIGHT".equals(cmd)) {
        j++;
      }else if ("DOWN".equals(cmd)) {
        i++;
      }else if ("LEFT".equals(cmd)) {
        j--;
      }
    }
    return (i * n) + j;
  }

  public int finalPositionOfSnakeV1(int n, List<String> commands) {
    Map<String, Integer> map = commands.stream().collect(Collectors.toMap(
        v -> v,
        v -> 1,
        Integer::sum
    ));
    int i = map.getOrDefault("DOWN", 0) -
        map.getOrDefault("UP", 0);
    int j = map.getOrDefault("RIGHT", 0) -
        map.getOrDefault("LEFT", 0);
    return (i * n) + j;
  }
}
