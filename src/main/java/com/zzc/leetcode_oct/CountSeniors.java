package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-23 12:00
 */
public class CountSeniors {
    public static void main(String[] args) {

    }
    public int countSeniors(String[] details) {
        int res = 0;
        for (int i = 0; i < details.length; i++) {
            String str = details[i];
            int age = Integer.parseInt(str.substring(11, 13));
            if (age > 60) {
                res++;
            }
        }
        return res;
    }
}
