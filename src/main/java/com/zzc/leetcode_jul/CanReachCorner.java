package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author zc.zhou
 * @Description 3235并查集
 * @create 2024-07-29 10:04
 */
public class CanReachCorner {

  @Test
  void testFun() throws IOException {
    int[][] circles = ArrayUtils.generate("array", int[][].class);
    System.out.println(canReachCorner(5, 7, circles));
  }

  public boolean canReachCorner(int X, int Y, int[][] circles) {
    //将左上/右下也看成节点
    int n = circles.length + 2;
    UnionFindV1 uf = new UnionFindV1(n);
    for (int i = 0; i < circles.length; i++) {
      for (int j = i + 1; j < circles.length; j++) {
        if (isCircleUnion(circles[i], circles[j])) {
          uf.union(i, j);
        }
      }
    }

    //判断左上边界是否和圆相交
    for (int i = 0; i < circles.length; i++) {
      int[] c = circles[i];
      //左上边界
      if (Math.abs(c[0]) <= c[2] || Math.abs(c[1] - Y) <= c[2]) {
        uf.union(n - 2, i);

      }
      //右下边界
      if (Math.abs(c[1]) <= c[2] || Math.abs(c[0] - X) <= c[2]) {

        uf.union(n - 1, i);
      }
    }
    return !uf.isConnected(n - 1, n - 2);
  }

  //判断两个圆是否联通
  private boolean isCircleUnion(int[] c1, int[] c2) {
    //圆心距离
    long dis1 = (long) (c1[0] - c2[0]) * (c1[0] - c2[0]) + (long) (c1[1] - c2[1]) * (c1[1] - c2[1]);
    //半径距离
    long dis2 = (long) (c1[2] + c2[2]) * (c1[2] + c2[2]);
    return dis1 <= dis2;
  }
}

class UnionFindV1 {
  //记录每个节点的父节点
  int[] parent;
  //记录每个节点的深度
  int[] rank;

  public UnionFindV1(int n) {
    //初始化节点 每个节点的父节点都指向它自己
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      //初始化深度为1
      rank[i] = 1;
    }
  }

  //查询每个节点的根节点
  private int find(int x) {

    if (parent[x] != x) {
      // 路径压缩 1 -> 2 -> 3   ===>  1 -> 3
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }


  //合并两个节点x, y
  public void union(int x, int y) {
    //查找x, y根节点
    int rootX = find(x);
    int rootY = find(y);
    //根节点不同时才需要合并
    if (rootX != rootY) {
      //判断rootX rootY节点的高度, 把较低的树合并到较高的树
      if (rank[rootX] < rank[rootY]) {
        //较低的树合并到较高的树
        parent[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else {
        //树的高度一样
        parent[rootX] = rootY;
        //更新rootY的高度
        rank[rootY] += 1;
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}
