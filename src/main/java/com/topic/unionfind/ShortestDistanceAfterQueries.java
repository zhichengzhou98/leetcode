package com.topic.unionfind;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 3244
 * @create 2024-08-09 13:57
 */
public class ShortestDistanceAfterQueries {
  @Test
  void testFun() throws IOException {
    int[][] queries = ArrayUtils.generate("array", int[][].class);
    System.out.println(Arrays.toString(shortestDistanceAfterQueries(5, queries)));
  }

  //超时
  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    // 0 -> 1 -> 2  0 ~ n - 1 一个n个节点， n-1个区间
    int[] res = new int[queries.length];
    //记录每个节点联通的下一个最远的节点
    //最后一个节点不需要记录
    int[] nexts = new int[n-1];
    for (int i = 0; i < nexts.length; i++) {
      nexts[i] = i + 1;
    }
    UnionFindV5 uf = new UnionFindV5(n - 1);
    for (int i = 0; i < queries.length; i++) {
      int begin = queries[i][0];
      int end = queries[i][1];//end表示点的位置
      int pEnd = uf.find(end - 1) + 1;
      if (pEnd > nexts[begin]) {
        //合并区间
        for (int j = nexts[begin]; j <= pEnd - 1; j++) {
          uf.union(begin, j);
        }
      }
      res[i] = uf.size;
    }
    return res;
  }
}

class UnionFindV5 {
  int[] parent;
  int[] rank;

  //联通块的大小
  int size;

  public UnionFindV5(int n) {
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
