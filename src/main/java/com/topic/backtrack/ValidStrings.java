package com.topic.backtrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 3211. 生成不含相邻零的二进制字符串 回溯
 * @create 2024-10-29 17:58
 */
public class ValidStrings {
  @Test
  void testFun() {
    System.out.println(validStrings(3));
  }

  List<String> res;
  int n;

  public List<String> validStrings(int n) {
    res = new ArrayList<>();
    this.n = n;
    dfs(new StringBuilder(), false);
    return res;
  }

  /**
   * @param sb   当前字符串
   * @param flag 是否有限制 true: 有限制 -> 只能填1
   */
  public void dfs(StringBuilder sb, boolean flag) {
    if (sb.length() == n) {
      res.add(sb.toString());
      return;
    }
    if (flag) {
      //只能填1
      StringBuilder newSb = new StringBuilder(sb);
      newSb.append('1');
      dfs(newSb, false);
    } else {
      //可以填0
      StringBuilder newSb = new StringBuilder(sb);
      newSb.append('0');
      //有限制
      dfs(newSb, true);
      //回溯
      StringBuilder newSb1 = new StringBuilder(sb);
      newSb1.append('1');
      dfs(newSb1, false);
    }
  }
}
