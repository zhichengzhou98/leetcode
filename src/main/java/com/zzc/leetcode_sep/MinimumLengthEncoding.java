package com.zzc.leetcode_sep;

import java.util.*;

/**
 * @author zc.zhou
 * @Description 820. 单词的压缩编码
 * @create 2023-09-09 18:54
 */
public class MinimumLengthEncoding {
    public static void main(String[] args) {
        //String[] words = {"time","me","bell"};
        //String[] words = {"a","ba","bba"};
        String[] words = {"feipyxx","e"};
        System.out.println(minimumLengthEncoding(words));
    }
    //TODO 字典树
    public static int minimumLengthEncoding(String[] words) {
        HashSet<String> res = new HashSet<>(List.of(words));

        int count = 0;
        for (String s : words) {
            for (int i = 1; i < s.length(); i++) {
                res.remove(s.substring(i));
            }
        }
        for (String s : res) {
            count = count + s.length() + 1;
        }
        return count;
    }

    /*public static int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            boolean flag = false;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].endsWith(current)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += current.length() + 1;
            }
        }
        return count + words[words.length - 1].length() + 1;
    }*/
}
