package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description 721并查集
 * @create 2024-07-15 9:51
 */
public class AccountsMerge {
  @Test
  void testFun() {
    //[[],[],[],[]]
    List<String> account1 = List.of("John","johnsmith@mail.com","john_newyork@mail.com");
    List<String> account2 = List.of("John","johnsmith@mail.com","john00@mail.com");
    List<String> account3 = List.of("Mary","mary@mail.com");
    List<String> account4 = List.of("John","johnnybravo@mail.com");
    List<List<String>> res = List.of(account1, account2, account3, account4);
    System.out.println(accountsMerge(res));

  }

  //并查集
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    UnionFindV4 uf = new UnionFindV4(accounts.size());
    for (int i = 0; i < accounts.size(); i++) {
      for (int j = i + 1; j < accounts.size(); j++) {
        List<String> account1 = accounts.get(i);
        List<String> account2 = accounts.get(j);
        List<String> emails1 = account1.subList(1, account1.size());
        List<String> emails2 = account2.subList(1, account2.size());
        if (!Collections.disjoint(emails2, emails1)) {
          uf.union(i, j);
        }
      }
    }
    Map<Integer, List<Integer>> map = uf.map;
    return map.values().stream().map(value -> {
      //所有相同的账户索引
      Set<String> set = new HashSet<>();
      for (Integer integer : value) {
        List<String> account = accounts.get(integer);
        set.addAll(account.subList(1, account.size()));
      }
      List<String> list = new ArrayList<>(set);
      Collections.sort(list);
      list.add(0, accounts.get(value.get(0)).get(0));
      return list;
    }).toList();
  }

  //(a) (b) (a, b) => 同一个账户，按照以下逻辑会有两个账户 (a, b) (b)
  public List<List<String>> accountsMerge1(List<List<String>> accounts) {
    //key：邮箱账号，value：name
    Map<Set<String>, String> map = new HashMap<>();
    for (List<String> account : accounts) {
      List<String> emails = account.subList(1, account.size());
      Set<Set<String>> sets = map.keySet();
      boolean flag = false;
      for (Set<String> set : sets) {
        //遍历当前人的每个邮箱账户
        for (int j = 1; j < account.size(); j++) {
          if (set.contains(account.get(j))) {
            flag = true;
            break;
          }
        }
        if (flag) {
          //当前账户和set是同一个人
          set.addAll(emails);
          break;
        }
      }
      if (!flag) {
        //新的个人 存入map
        map.put(new TreeSet<>(emails), account.get(0));
      }
    }
    return map.entrySet().stream().map(entry -> {
      List<String> res = new ArrayList<>();
      res.add(entry.getValue());
      res.addAll(entry.getKey());
      return res;
    }).toList();
  }

  public List<List<String>> accountsMergeV1(List<List<String>> accounts) {
    int lastSize = accounts.size();
    List<List<String>> lists = accountsMerge1(accounts);
    //如果合并前后的size不必 说明不能再继续合并了
    while (lists.size() != lastSize) {
      lastSize = lists.size();
      lists = accountsMerge1(lists);
    }
    return lists;
  }
}

class UnionFindV4{
  int[] parent;
  int[] rank;

  Map<Integer, List<Integer>> map;
  public UnionFindV4(int n) {
    parent = new int[n];
    rank = new int[n];
    map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
      List<Integer> list = new ArrayList<>();
      list.add(i);
      map.put(i, list);
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
    if (rootX == rootY) {
      return;
    }
    parent[rootX] = rootY;
    List<Integer> list = map.get(rootX);
    map.get(rootY).addAll(list);
    map.remove(rootX);
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}
