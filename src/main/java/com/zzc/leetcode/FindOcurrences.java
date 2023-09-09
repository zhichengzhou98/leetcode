package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-19 20:31
 */
public class FindOcurrences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("we will we will rock you", "we", "will")));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> res = new ArrayList<>();

        String[] s = text.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].equals(first) && s[i + 1].equals(second)) {
                if (i + 2 < s.length) {
                    res.add(s[i + 2]);
                }
            }
        }

        return res.toArray(new String[0]);
    }
}
