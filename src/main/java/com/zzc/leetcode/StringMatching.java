package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-08 21:04
 */
public class StringMatching {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass","as","hero","superhero"}));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = words.length-1; j >= 0 ; j--) {
                if (words[i].length() < words[j].length()) {
                    if (words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
