package com.zzc.leetcode_may;

import com.zzc.exam.Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-07 21:41
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            String wordFloat = getWordString(word);
            if (map.containsKey(wordFloat)) {
                map.get(wordFloat).add(word);
            }else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(wordFloat, list);
            }
        }
        return map.values().stream().toList();
    }

    private String getWordString(String word) {
        int[] words = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            words[(ch - 'a')]++;
        }
        StringBuilder res = new StringBuilder();
        for(int i : words) {
            res.append(i).append(',');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //System.out.println(Float.MAX_VALUE);

    }

    @Test
    public void testFun() {
        String[] words = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(words));
        System.out.println(getWordString("wac").equals(getWordString("wee")));
        System.out.println(getWordString("bdddddddddd"));
    }

}
