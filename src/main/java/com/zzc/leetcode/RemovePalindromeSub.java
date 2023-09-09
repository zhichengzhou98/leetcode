package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-29 17:47
 */
public class RemovePalindromeSub {
    public static void main(String[] args) {

    }

    public int removePalindromeSub(String s) {
        if (isPalindromeStr(s)) {
            return 1;
        }

        return 2;
    }

    public boolean isPalindromeStr(String s) {
        if(s.length()== 0 || s.length() == 1) {
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() -1)){
            return isPalindromeStr(s.substring(1, s.length()-1));
        }
        return false;
    }
}
