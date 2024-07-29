package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 990并查集
 * @create 2024-07-29 14:35
 */
public class EquationsPossible {
  //a == b
  public boolean equationsPossible(String[] equations) {
    //把每个字母都当成一个节点
    UnionFindV2 uf = new UnionFindV2(26);
    //把 != 当都拿出来
    List<int[]> notEqual = new ArrayList<>();
    for (String str : equations) {
      int node1 = str.charAt(0) - 'a';
      int node2 = str.charAt(3) - 'a';
      //是否相等
      if (str.charAt(1) == '=') {
        //相等则联通node1 node2
        uf.union(node1, node2);
      } else {
        notEqual.add(new int[]{node1, node2});
      }
    }
    //遍历notEqual, 判断uf是否满足
    for(int[] arr : notEqual) {
      if (uf.isConnect(arr[0], arr[1])) {
        return false;
      }
    }
    return true;
  }
}

class UnionFindV2 {
  int[] parent;
  //树的高度
  int[] rank;

  public UnionFindV2(int n) {
    parent = new int[n];
    rank = new int[n];
    //初始化节点的父节点为自己
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  //查找根节点
  public int find(int x) {
    if (parent[x] != x) {
      //路径压缩 1 -> 2 -> 3   ==> 1 -> 3
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  //合并
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] < rank[rootY]) {
        //将高度低的树合并到高度高的树
        parent[rootX] = rootY;
      } else if (rank[rootY] < rank[rootX]) {
        parent[rootY] = rootX;
      } else {
        //高度一样
        //y合到x, x高度+1
        parent[rootY] = rootX;
        rank[rootX]++;
      }
    }
    //不需要合并
  }

  //判断x, y是否相连
  public boolean isConnect(int x, int y) {
    return find(x) == find(y);
  }
}
