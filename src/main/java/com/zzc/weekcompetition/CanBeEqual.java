package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 22:31
 */
public class CanBeEqual {
    public static void main(String[] args) {
        System.out.println(canBeEqual("abcd", "cdab"));
    }

    public static boolean canBeEqual(String s1, String s2) {
        //交换1 ， 3
        String res1 = new StringBuilder().append(s1.charAt(0))
                .append(s1.charAt(3))
                .append(s1.charAt(2))
                .append(s1.charAt(1)).toString();
        //交换0,2
        String res2 = new StringBuilder().append(s1.charAt(2))
                .append(s1.charAt(1))
                .append(s1.charAt(0))
                .append(s1.charAt(3)).toString();
        //交换1,3 0,2
        String res3 = new StringBuilder().append(s1.charAt(2))
                .append(s1.charAt(3))
                .append(s1.charAt(0))
                .append(s1.charAt(1)).toString();
        return s1.equals(s2) || res1.equals(s2) ||
                res2.equals(s2) ||
                res3.equals(s2);
    }
}
