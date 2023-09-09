package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-10 21:40
 */
public class ToLowerCase {
    public static void main(String[] args) {

    }

    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
}
