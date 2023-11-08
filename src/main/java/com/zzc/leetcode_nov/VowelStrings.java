package com.zzc.leetcode_nov;

import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-07 12:10
 */
public class VowelStrings {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i = left; i <= right;i++) {
            String word = words[i];
            Character begin = word.charAt(0);
            Character end = word.charAt(word.length() - 1);
            if (set.contains(end) && set.contains(begin)) {
                res++;
            }
        }
        return res;
    }
}
