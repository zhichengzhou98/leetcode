package com.topic.baoli;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 2506. 统计相似字符串对的数目
 * @create 2025-02-22 11:37
 */
public class SimilarPairs {
  public int similarPairs(String[] words) {
    Map<Integer, Integer> map = new HashMap<>();
    for (String word : words) {
      int key = generateKey(word);
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    int res = 0;
    for (int v : map.values()) {
      res += (v) * (v - 1) / 2;
    }
    return res;
  }

  private int generateKey(String word) {
    int res = 0;
    for (int i = 0; i < word.length(); i++) {
      int num = word.charAt(i) - 'a';
      res = res | (1 << num);
    }
    return res;
  }
}
