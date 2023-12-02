package com.zzc.leetcode_nov;

import com.zzc.leetcode_oct.PickGifts;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-30 12:11
 */
public class CloseStrings {
    @Test
    public void test() {
        closeStrings("abbzzca", "babzzcz");
    }
    public boolean closeStrings(String word1, String word2) {
        if (word2.length()!= word1.length()) {
            return false;
        }
        Map<Character, Integer> map1 = getCnts(word1);
        Map<Character, Integer> map2 = getCnts(word2);
        Set<Character> set1 = map1.keySet();
        Set<Character> set2 = map2.keySet();
        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());
        return set1.equals(set2) && list1.equals(list2);
    }

    public Map<Character, Integer> getCnts(String word1) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}

