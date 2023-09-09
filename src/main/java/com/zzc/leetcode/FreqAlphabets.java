package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-24 20:51
 */
public class FreqAlphabets {
    public static void main(String[] args) {

        System.out.println(freqAlphabets("10#11#12"));
    }

    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0;) {
            if (s.charAt(i) == '#') {
                char c1 = (char)(Integer.parseInt(s.substring(i-2, i))-10 +'j');
                sb.append(c1);
                i = i -3;
            }else {
                sb.append((char) (s.charAt(i) - '1' + 'a'));
                i--;
            }
        }

        return sb.reverse().toString();
    }
}
