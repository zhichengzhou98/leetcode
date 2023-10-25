package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-25 20:59
 */
public class PerfectPerformance {
    public static void main(String[] args) {

    }
    public boolean perfectPerformance(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int lR = 0;
        int uD = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c == 'L') {
                lR++;
            }else if (c == 'R') {
                lR--;
            }else if (c == 'U') {
                uD++;
            }else if (c == 'D') {
                uD--;
            }
        }
        return lR == 0 && uD == 0;
    }
}
