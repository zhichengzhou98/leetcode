package com.topic.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 685. 冗余连接 II TODO
 * @create 2024-10-28 20:49
 */
public class FindRedundantDirectedConnection {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    //找到有两个父节点的坐标 记录它们在edges中的索引
    int[] twoParentIndex = new int[2];
    Set<Integer> end = new HashSet<>();
    int size = edges.length;
    UnionFindV7 uf = new UnionFindV7(size + 1);
    for (int i = 0; i < size; i++) {
      int[] e = edges[i];
      int x = e[0];
      int y = e[1];
      if (end.contains(y)) {
        twoParentIndex[1] = i;
      }
      end.add(y);
      if (uf.isConnect(x, y)) {
        //回路的最后一条边
        return e;
      }
      uf.union(x, y);
    }
    for (int[] e : edges) {
      int x = e[0];
      int y = e[1];

      end.add(y);
      if (uf.isConnect(x, y)) {
        return e;
      }
      uf.union(x, y);
    }
    return edges[size - 1];
  }
}

class UnionFindV7 {
  //每个节点的父节点
  int[] p;
  //每个子树的大小
  int[] r;

  public UnionFindV7(int n) {
    p = new int[n];
    r = new int[n];
    //初始化每个节点的父节点为自己
    for (int i = 0; i < p.length; i++) {
      p[i] = i;
    }
  }

  /**
   * 查找x的父节点
   *
   * @param x 要查找的节点
   * @return x父节点
   */
  public int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      int rankX = r[rootX];
      int rankY = r[rootY];
      if (rankX < rankY) {
        p[x] = rootY;
      } else if (rankX > rankY) {
        p[y] = rootX;
      } else {
        p[x] = rootY;
        r[rootY]++;
      }
    }
  }

  public boolean isConnect(int x, int y) {
    return find(x) == find(y);
  }
}
