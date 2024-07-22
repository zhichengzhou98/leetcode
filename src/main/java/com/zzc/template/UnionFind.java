package com.zzc.template;

/**
 * @author zc.zhou
 * @Description 并查集
 * @create 2024-07-22 9:37
 */
public class UnionFind {
  private int[] parent; // 记录每个节点的父节点
  private int[] rank;   // 记录每个节点的高度(深度)

  private int[] count; //记录每个节点的数量

  public UnionFind(int size) {
    parent = new int[size];
    rank = new int[size];
    count = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i; // 初始时每个节点的父节点是自己
      rank[i] = 0;   // 初始时每个节点的高度为0
      count[i] = 1;  // 初始时，每个节点的集合中只有自己，数量为1
    }
  }

  // 查找节点x的代表元素(根节点)
  private int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]); // 路径压缩
    }
    return parent[x];
  }

  // 合并两个节点x和y所在的集合
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      // 如果两个根节点的高度不同，将较低的树合并到较高的树下
      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
        count[rootY] += count[rootX];
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
        count[rootX] += count[rootY];
      } else {
        // 如果两个树的高度相同，将其中一个的根节点作为另一个的子节点，并提升其高度
        parent[rootY] = rootX;
        rank[rootX] += 1;
        count[rootX] += count[rootY];
      }
    }
  }

  // 判断两个节点是否属于同一个集合
  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  public int[] getCount() {
    return count;
  }
}