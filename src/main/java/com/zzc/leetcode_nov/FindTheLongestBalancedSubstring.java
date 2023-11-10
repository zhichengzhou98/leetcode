package com.zzc.leetcode_nov;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-08 12:26
 */
public class FindTheLongestBalancedSubstring {

    @Test
    public void test() {
        System.out.println(findTheLongestBalancedSubstring("01000111"));
    }

    public int findTheLongestBalancedSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                res = Math.max(res, maxLength(i, i+1, s));
            }
        }
        return res;
    }

    public int maxLength(int i, int j, String s) {
        int cnt0 = 0;
        while (i >= 0 && s.charAt(i) == '0') {
            i--;
            cnt0++;
        }
        int cnt1 = 0;
        while (j < s.length() && s.charAt(j) == '1') {
            j++;
            cnt1++;
        }
        return Math.min(cnt0, cnt1) * 2;
    }
}
