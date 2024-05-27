package com.zzc.leetcode_mar;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-13 20:37
 */
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
            }else if (s.charAt(i) == '0') {
                cnt0++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt1 - 1; i++) {
            sb.append('1');
        }
        for (int i = 0; i < cnt0; i++) {
            sb.append('0');
        }
        return sb.append('1').toString();
    }
}
