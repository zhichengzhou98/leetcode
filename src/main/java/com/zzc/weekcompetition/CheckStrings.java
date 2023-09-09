package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 22:39
 */
public class CheckStrings {
    public static void main(String[] args) {
        System.out.println(checkStrings("abe", "bea"));
    }
    public static boolean checkStrings(String s1, String s2) {
        //判断s1 s2 偶数位 奇数位出现的字母是否一致
        int[] cnts = new int[26];
        int[] cnt1s = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                cnts[s1.charAt(i) - 'a']++;
                cnts[s2.charAt(i) - 'a']--;
            }else {
                cnt1s[s1.charAt(i) - 'a']++;
                cnt1s[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] != 0 || cnt1s[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
