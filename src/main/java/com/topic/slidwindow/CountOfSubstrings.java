package com.topic.slidwindow;

import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2025-03-12 17:09
 */
public class CountOfSubstrings {
  public int countOfSubstrings(String word, int k) {

  }

  // 恰好出现 k次 -> 最少出现k次 - 最少出现k+1次
  public int slidWin(String word, int k) {
    int left = 0;
    int[] cnts = new int[5];
    int cntK = 0;
    Map<Character, Integer> charIndex = Map.of('a', 0,
        'e', 1,
        'i', 2,
        'o', 3,
        'u', 4);
    Set<Character> set = charIndex.keySet();
    // right
    for (int right = 0; right < word.length(); right++) {
      char c = word.charAt(right);
      if (set.contains(c)) {
        cntK++;
      } else {
        Integer i = charIndex.get(c);
        cnts[i]++;
      }

    }
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
