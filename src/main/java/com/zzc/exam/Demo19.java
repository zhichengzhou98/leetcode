package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-21 20:10
 */

/*
给定两个字符串 s 和 t ，它们只包含小写字母。字符串 t 由字符串 s 随机重排，
然后在随机位置添加一个字母。请找出在 t 中被添加的字母。
示例 1：输入：s = "abcd", t = "bdeca"
输出："e"
示例 2：输入：s = "a", t = "aa"
输出："a"
示例 3：输入：s = "", t = "y"
输出："y"
 */
public class Demo19 {
    public static void main(String[] args) {
        System.out.println(test1("abcd", "bdeca"));
        System.out.println(test1("a", "aa"));
        System.out.println(test1("", "y"));
        System.out.println(test1("abcgjh", "abcgsjh"));
        System.out.println(test1("abcgjh", "aabcgjh"));
        System.out.println(test1("abcgjh", "abbcgjh"));
    }

    public static String test(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[t.charAt(i) - 'a']++;
            arr[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return (char) (i + 'a') + "";
            }
        }
        return t.charAt(t.length()-1)+"";
    }

    public static String test1(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res ^ s.charAt(i) ^ t.charAt(i);
        }

        return Character.toString((char)(res ^ t.charAt(t.length()-1)));
    }
}
