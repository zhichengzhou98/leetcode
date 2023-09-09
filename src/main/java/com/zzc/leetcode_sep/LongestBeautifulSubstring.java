package com.zzc.leetcode_sep;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-04 20:50
 */
public class LongestBeautifulSubstring {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }

    public static int longestBeautifulSubstring(String word) {
        int l = 0;
        int r = l + 1;
        int res = 0;
        while (r < word.length()) {
            while (l < word.length() && word.charAt(l) != 'a') {
                l++;
            }
            if (l == word.length()) {
                return res;
            }
            Set<Character> set = new HashSet<>();
            set.add(word.charAt(l));
            r = l + 1;
            while (r < word.length() && word.charAt(r) >= word.charAt(r-1)) {
                set.add(word.charAt(r));
                r++;

            }
            if (set.size() == 5) {
                res = Math.max(res, r - l);
            }
            l = r;
        }
        return res;
    }
}
