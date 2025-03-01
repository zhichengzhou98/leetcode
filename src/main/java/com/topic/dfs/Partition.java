package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 131. 分割回文串 回溯
 * @create 2025-03-01 16:21
 */
public class Partition {
  @Test
  void testFun() {
    String s = "aab";
    System.out.println(partition(s));
  }

  List<List<String>> res;

  public List<List<String>> partition(String s) {
    res = new ArrayList<>();
    dfs(s, new ArrayList<>());
    return res;
  }

  private void dfs(String s, List<String> tmp) {
    if ("".equals(s) && !tmp.isEmpty()) {
      res.add(new ArrayList<>(tmp));
      return;
    }
    for (int i = 1; i <= s.length(); i++) {
      String sub = s.substring(0, i);
      if (check(sub)) {
        tmp.add(sub);
        dfs(s.substring(i), tmp);
        // 回溯
        tmp.remove(tmp.size() - 1);
      }
    }
  }

  private boolean check(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (right > left) {
      if (s.charAt(left) == s.charAt(right)) {
        right--;
        left++;
      } else {
        return false;
      }
    }
    return true;
  }
}
