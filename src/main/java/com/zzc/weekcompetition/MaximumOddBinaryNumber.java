package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-24 10:31
 */
public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
    }
    public static String maximumOddBinaryNumber(String s) {
        int cnt1 = 0;
        int cnt0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
            }else if (s.charAt(i) == '0') {
                cnt0++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (cnt1 - 1 > 0) {
            sb.append('1');
            cnt1--;
        }
        while (cnt0 > 0) {
            sb.append('0');
            cnt0--;
        }
        return sb.toString() + '1';
    }
}
