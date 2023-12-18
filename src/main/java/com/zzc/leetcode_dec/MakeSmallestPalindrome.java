package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-13 12:01
 */
public class MakeSmallestPalindrome {
    @Test
    public void test() {
        System.out.println(makeSmallestPalindrome("abcd"));
    }
    public String makeSmallestPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (r >= l) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (left == right) {
                sb.append(right);
            }else if(left > right) {
                sb.append(right);
            }else {
                sb.append(left);
            }
            l++;
            r--;
        }
        if (s.length() % 2 == 0) {
            sb = sb.append(new StringBuilder(sb).reverse());
        }else {
            sb = sb.append(new StringBuilder(sb.substring(0, sb.length() - 1)).reverse());
        }
        return sb.toString();
    }
}
