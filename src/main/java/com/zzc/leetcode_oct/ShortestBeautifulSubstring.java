package com.zzc.leetcode_oct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description "11000111" TODO 滑动窗口
 * @create 2023-10-18 21:33
 */
public class ShortestBeautifulSubstring {
    public static void main(String[] args) {
        String s = "11000111";
        System.out.println(shortestBeautifulSubstring(s, 1));
    }
    //不定长滑窗
    public static String shortestBeautifulSubstring(String s, int k) {
        //满足条件的字符串集合
        List<String> res = new ArrayList<>();
        //最小长度
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int cnt = 0;
        if (s.charAt(r) == '1') {
            cnt++;
        }
        while (l < s.length() && r < s.length()) {
            while (r < s.length() && cnt <= k) {
                if (cnt == k) {
                    res.add(s.substring(l, r + 1));
                    minLen = Math.min(minLen, r - l + 1);
                }
                r++;
                if (r < s.length() && s.charAt(r) == '1') {
                    cnt++;
                }
            }
            if (r == s.length()) {
                break;
            }
            //cnt > k 左边界向前移动
            while (l < r && cnt >= k) {
                if (cnt == k) {
                    res.add(s.substring(l, r + 1));
                    minLen = Math.min(minLen, r - l + 1);
                }
                l++;
                if (l <= r && s.charAt(l - 1) == '1') {
                    cnt--;

                }
            }
        }
        if (res.isEmpty()) {
            return "";
        }
        final int len = minLen;
        return res.stream().filter(str -> str.length() == len).sorted().collect(Collectors.toList()).get(0);
    }
}
