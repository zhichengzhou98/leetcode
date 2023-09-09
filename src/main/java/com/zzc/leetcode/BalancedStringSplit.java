package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-22 16:33
 */
public class BalancedStringSplit {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        int left = 0;
        int countL = 0;
        int countR = 0;
        while (left < s.length()) {
            char c = s.charAt(left);
            if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            }
            if (countL == countR) {
                count++;
                countL = 0;
                countR = 0;
            }
            left++;
        }
        return count;
    }
}
