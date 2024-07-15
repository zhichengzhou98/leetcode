package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description TODO：并查集
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
  //(a) (b) (a, b) => 同一个账户，按照以下逻辑会有两个账户 (a, b) (b)
  public List<List<String>> accountsMerge1(List<List<String>> accounts) {
    //key：邮箱账号，value：name
    Map<Set<String>, String> map = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);
      List<String> emails = account.subList(1, account.size());
      Set<Set<String>> sets = map.keySet();
      boolean flag = false;
      for(Set<String> set: sets) {
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

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
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
