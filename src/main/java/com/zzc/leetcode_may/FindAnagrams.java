package com.zzc.leetcode_may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 定长滑窗
 * @create 2024-05-13 15:08
 */
public class FindAnagrams {

    @Test
    public void test() {
        System.out.println(Arrays.equals(new int[]{1, 2}, new int[]{2, 1}));
        System.out.println(findAnagrams("cbaebabacdabcbasfabc", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
//*
// s = "cbaebabacdabcbasfabc", p = "cba"
//输出: [0,6]*/
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = left + p.length() - 1;
        int[] array = new int[26];
        for (int i = 0; i < p.length(); i++) {
            array[p.charAt(i) - 'a']++;
            array[s.charAt(i) - 'a']--;
        }
        int diff = 0;
        for(int i: array) {
            if (i != 0) {
                diff++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (diff == 0) {
            res.add(left);
        }
        while (right < s.length() - 1) {
            left++;
            right++;
            int leftChar = s.charAt(left - 1) - 'a';
            int rightChar = s.charAt(right) - 'a';
            if (s.charAt(left - 1) != s.charAt(right)) {
                array[leftChar]++;
                array[rightChar]--;
                if (array[leftChar] == 0) {
                    diff--;
                } else if (array[leftChar] == 1) {
                    diff++;
                }
                if (array[rightChar] == 0) {
                    diff--;
                } else if (array[rightChar] == -1) {
                    diff++;
                }
            }
            if (diff == 0) {
                res.add(left);
            }
        }
        return res;
    }
}
