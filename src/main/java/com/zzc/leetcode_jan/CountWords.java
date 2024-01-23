package com.zzc.leetcode_jan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-12 11:54
 */
public class CountWords {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for(String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry: map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
