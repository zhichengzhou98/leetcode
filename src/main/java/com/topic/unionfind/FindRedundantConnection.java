package com.topic.unionfind;

/**
 * @author zc.zhou
 * @Description 684. 冗余连接 并查集
 * @create 2024-10-27 12:54
 */
public class FindRedundantConnection {
  public int[] findRedundantConnection(int[][] edges) {
    int size = edges.length;
    UnionFindV6 uf = new UnionFindV6(size + 1);
    for(int[] e : edges) {
      int x = e[0];
      int y = e[1];
      if (uf.isConnected(x, y)) {
        //如果当前的两个点已经是联通的， 说明x与y之间的边是多余的（形成了环）
        return e;
      } else {
        uf.union(x, y);
      }
    }
    return edges[size-1];
  }
}
class UnionFindV6 {
  int[] parent;
  int[] rank;

  //联通块的大小
  int size;

  public UnionFindV6(int n) {
    parent = new int[n];
    rank = new int[n];
    size = n;
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      size--;
      //将小树合并到大树上
      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootY] < rank[rootX]) {
        parent[rootY] = rootX;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}
