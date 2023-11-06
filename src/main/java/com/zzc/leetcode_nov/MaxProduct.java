package com.zzc.leetcode_nov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-06 12:13
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        //计算每个字符串的掩码
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            masks[i] = calculateMask(word);
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public int calculateMask(String s) {
        int res = 0;
        for (int i = 0; i < s.length();i++){
            res = res | (1 <<(s.charAt(i)-'a'));
        }
        return res;
    }

    public boolean havePublicChar(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
            if(set.size() == 26) {
                return true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
