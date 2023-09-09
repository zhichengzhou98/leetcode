package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-02 22:22
 */
public class GenerateTheString {
    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }else {
            for (int i = 0; i < n-1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }
        return sb.toString();
    }
}
