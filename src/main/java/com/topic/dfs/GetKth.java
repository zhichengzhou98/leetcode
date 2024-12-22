package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 1387. 将整数按权重排序 dfs + 排序
 * @create 2024-12-22 11:00
 */
public class GetKth {
  @Test
  void testFun() {

  }

  Map<Integer, Integer> memo;

  public int getKth(int lo, int hi, int k) {
    memo = new HashMap<>();
    memo.put(1, 0);
    List<Integer> list = new ArrayList<>();
    for (int i = lo; i <= hi; i++) {
      list.add(i);
    }
    list.sort((a, b) -> {
      int cnt1 = dfs(a);
      int cnt2 = dfs(b);
      if (cnt1 == cnt2) {
        return a - b;
      } else {
        return cnt1 - cnt2;
      }
    });
    //System.out.println(list);
    return list.get(k - 1);
  }


  /**
   * @param n 当前数字
   * @return 变成1所需要的步数
   */
  private int dfs(int n) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    int res = 0;
    if (n % 2 == 1) {
      res = 1 + dfs(n * 3 + 1);
    } else {
      res = 1 + dfs(n >> 1);
    }
    memo.put(n, res);
    return res;
  }
}
