package com.topic.template;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-26 12:14
 */
public class IsSubSeq {
    public static void main(String[] args) {
        System.out.println(isSubSeq("avbas", "ava"));
    }



    //双指针
    public static boolean isSubSeq(String s, String seq) {
        if (seq.length() > s.length()) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while (p1 < seq.length()) {
            char c = seq.charAt(p1);
            while (p2 < s.length() && s.charAt(p2) != c) {
                p2++;
            }
            if (p2 == s.length()) {
                return false;
            }else {
                p1++;
                p2++;
            }
        }
        return true;
    }

    //string api
    /*public static boolean isSubSeq(String s, String seq) {
        if (seq.length() > s.length()) {
            return false;
        }
        int i = 0;
        while (i < seq.length()) {
            char c = seq.charAt(i);
            int i1 = s.indexOf(c);
            if (i1 == -1) {
                return false;
            }else {
                s = s.substring(i1 +1);
                i++;
            }
        }
        return true;
    }*/
}
