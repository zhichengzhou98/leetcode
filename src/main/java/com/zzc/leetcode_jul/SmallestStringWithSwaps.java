package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 1202
 * @create 2024-07-30 15:02
 */
public class SmallestStringWithSwaps {
  //pairs 联通的字符的索引
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    UnionFindV3 uf = new UnionFindV3(s.length());
    for (List<Integer> list : pairs) {
      uf.union(list.get(0), list.get(1));
    }
    char[] chars = new char[s.length()];
    Map<Integer, List<Integer>> parentMap = uf.parentMap;
    for (Map.Entry<Integer, List<Integer>> entry : parentMap.entrySet()) {
      List<Integer> value = entry.getValue();
      //set中的字符都是联通的
      //0: 索引， 1： 表示字符
      int[] indexChar = new int[value.size()];
      for (int i = 0; i < indexChar.length; i++) {
        indexChar[i] = s.charAt(value.get(i)) - 'a';
      }
      //按数组1升序
      Arrays.sort(indexChar);
      Collections.sort(value);
      for (int i = 0; i < value.size(); i++) {
        chars[value.get(i)] = (char) (indexChar[i] + 'a');
      }

    }
    return new String(chars);
  }
}

class UnionFindV3 {
  int[] parent;
  int[] rank;

  //key：为根节点 value：所有的子节点
  Map<Integer, List<Integer>> parentMap;

  public UnionFindV3(int n) {
    parent = new int[n];
    rank = new int[n];
    parentMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
      List<Integer> list = new ArrayList<>();
      list.add(i);
      parentMap.put(i, list);
    }

  }

  public int find(int x) {
    if (parent[x] != x) {
      //路径压缩
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootY == rootX) {
      return;
    }
    //把小树合并到大树
    if (rank[rootX] < rank[rootY]) {
      //x为小树
      parent[rootX] = rootY;
      //更新parentMap
      List<Integer> setX = parentMap.get(rootX);
      parentMap.get(rootY).addAll(setX);
      parentMap.remove(rootX);
    } else if (rank[rootY] < rank[rootX]) {
      parent[rootY] = rootX;
      //更新parentMap
      List<Integer> setY = parentMap.get(rootY);
      parentMap.get(rootX).addAll(setY);
      parentMap.remove(rootY);
    } else {
      parent[rootY] = rootX;
      rank[rootX] += 1;
      //更新parentMap
      List<Integer> setY = parentMap.get(rootY);
      parentMap.get(rootX).addAll(setY);
      parentMap.remove(rootY);
    }
  }
}
