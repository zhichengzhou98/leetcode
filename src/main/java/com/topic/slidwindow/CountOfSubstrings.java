package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3306. 元音辅音字符串计数 II 恰好型滑窗
 * @create 2025-03-12 17:09
 */
public class CountOfSubstrings {
  @Test
  void testFun() {
    System.out.println(countOfSubstrings("aeiou", 0));
  }

  public long countOfSubstrings(String word, int k) {
    return slidWin(word, k) - slidWin(word, k + 1);
  }

  // 恰好出现 k次 -> 最少出现k次 - 最少出现k+1次
  public long slidWin(String word, int k) {
    long res = 0;
    int right = 0;
    int[] cnts = new int[5];
    int cntK = 0;
    Map<Character, Integer> charIndex = Map.of('a', 0,
        'e', 1,
        'i', 2,
        'o', 3,
        'u', 4);
    Set<Character> set = charIndex.keySet();
    // 枚举左端点
    for (int left = 0; left < word.length(); left++) {
      // 不满足条件时 右端点右移直到满组条件
      while (right < word.length() && (!check(cnts) || cntK < k)) {
        // 把right放入窗口中
        char c = word.charAt(right);
        if (!set.contains(c)) {
          cntK++;
        } else {
          Integer i = charIndex.get(c);
          cnts[i]++;
        }
        right++;
      }
      if (check(cnts) && cntK >= k) {
        res = res + word.length() - right + 1;
      }
      // left移出窗口
      char c = word.charAt(left);
      if (!set.contains(c)) {
        cntK--;
      } else {
        Integer i = charIndex.get(c);
        cnts[i]--;
      }
    }
    return res;
  }

  private boolean check(int[] cnts) {
    for (int c : cnts) {
      if (c == 0) {
        return false;
      }
    }
    return true;
  }

}
