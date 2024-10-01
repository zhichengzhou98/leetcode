package com.topic.bfs;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 10^5
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 10^5
 * 0 <= routes[i][j] < 10^6
 * 0 <= source, target < 10^6
 * @Description 815. 公交路线
 * @create 2024-09-17 09:12
 */
public class NumBusesToDestination {
  @Test
  void testFun() throws IOException {
    int[][] r = ArrayUtils.generate("array", int[][].class);
    long s = System.currentTimeMillis();
    System.out.println(numBusesToDestinationV2(r, 37, 43));
    System.out.println(System.currentTimeMillis() - s);
  }


  public int numBusesToDestinationV2(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    //起点对应的索引
    Set<Integer> srcSet = new HashSet<>();
    //终点对应的索引
    Set<Integer> tarSet = new HashSet<>();
    //建图
    //构建每个图的相邻节点
    List[] nexts = new List[routes.length];
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < routes.length; i++) {
      for (int j = i + 1; j < routes.length; j++) {
        //判断routes[i] routes[j]是否有交集
        if (checkArrayIntersection(routes[i], routes[j])) {
          nexts[i].add(j);
          nexts[j].add(i);
        }
      }

      //更新srcSet tarSet
      for (int r : routes[i]) {
        if (r == source) {
          srcSet.add(i);
        }
        if (r == target) {
          tarSet.add(i);
        }
      }
    }
    //求最短路径bfs
    for (int s : srcSet) {
      res = Math.min(res, bfs(nexts, s, tarSet));
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public int bfs(List[] nexts, int start, Set<Integer> end) {
    int res = 1;
    if (end.contains(start)) {
      return res;
    }
    boolean[] flag = new boolean[nexts.length];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    flag[start] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      res++;
      List<Integer> next = nexts[current];
      for (int tmp : next) {
        if (end.contains(tmp)) {
          return res;
        }
        if (!flag[tmp]) {
          flag[tmp] = true;
          queue.offer(tmp);
        }
      }
    }
    return Integer.MAX_VALUE;
  }


  /**
   * 判断两个数组是否有公共元素
   *
   * @param arrI
   * @param arrJ
   * @return
   */
  private boolean checkArrayIntersection(int[] arrI, int[] arrJ) {
    Set<Integer> set = Arrays.stream(arrI).boxed().collect(Collectors.toSet());
    for (int j : arrJ) {
      if (set.contains(j)) {
        return true;
      }
    }
    return false;
  }


  //超时
  public int numBusesToDestinationV1(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    //起点对应的索引
    Set<Integer> srcSet = new HashSet<>();
    //终点对应的索引
    Set<Integer> tarSet = new HashSet<>();
    //建图
    List[] lists = new List[(int) 10e6];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < routes.length; i++) {
      int[] r = routes[i];
      for (int ri : r) {
        lists[ri].add(i);
        if (ri == source) {
          srcSet.add(i);
        }
        if (ri == target) {
          tarSet.add(i);
        }
      }
    }
    //构建每个图的相邻节点
    Set[] nexts = new Set[routes.length];
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = new HashSet<Integer>();
      int[] r = routes[i];
      for (int ri : r) {
        List<Integer> tmp = lists[ri];
        for (int index : tmp) {
          if (index != i) {
            nexts[i].add(index);
          }
        }
      }
    }
    //求最短路径bfs
    for (int s : srcSet) {
      res = Math.min(res, bfsV1(nexts, s, tarSet));
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public int bfsV1(Set[] nexts, int start, Set<Integer> end) {
    int res = 1;
    if (end.contains(start)) {
      return res;
    }
    boolean[] flag = new boolean[nexts.length];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    flag[start] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      res++;
      Set<Integer> next = nexts[current];
      for (int tmp : next) {
        if (end.contains(tmp)) {
          return res;
        }
        if (!flag[tmp]) {
          flag[tmp] = true;
          queue.offer(tmp);
        }
      }
    }
    return Integer.MAX_VALUE;
  }
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    //起点对应的索引
    Set<Integer> srcSet = new HashSet<>();
    //终点对应的索引
    Set<Integer> tarSet = new HashSet<>();
    //建图
    //构建每个图的相邻节点
    List[] nexts = new List[routes.length];
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = new ArrayList<Integer>();
    }
    //并查集 解答错误 i j相连并不等于j是i的下一个节点
    UnionFindV6 uf = new UnionFindV6((int) 1e6);
    for (int i = 0; i < routes.length; i++) {
      int[] route = routes[i];
      for (int j = 1; j < route.length ; j++) {
        uf.union(route[0], route[j]);
      }
    }
    for (int i = 0; i < routes.length; i++) {
      for (int j = i + 1; j < routes.length; j++) {
        //判断routes[i] routes[j]是否有交集
        if (uf.isConnect(routes[i][0], routes[j][0])) {
          nexts[i].add(j);
          nexts[j].add(i);
        }
      }
      //更新srcSet tarSet
      for (int r : routes[i]) {
        if (r == source) {
          srcSet.add(i);
        }
        if (r == target) {
          tarSet.add(i);
        }
      }
    }
    //求最短路径bfs
    for (int s : srcSet) {
      res = Math.min(res, bfs(nexts, s, tarSet));
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

}

class UnionFindV6 {
  int[] parent;
  int[] rank;

  public UnionFindV6(int size) {
    parent = new int[size];
    rank = new int[size];
    //每个根节点的父节点是他自己
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x != parent[x]) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      //把小树合并大大树上
      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootY] <rank[rootX]) {
        parent[rootY] = rootX;
      } else {
        //一样大
        parent[rootY] = rootX;
        rank[rootX]++;
      }
    }
  }

  public boolean isConnect(int x, int y) {
    return find(x) == find(y);
  }
}
