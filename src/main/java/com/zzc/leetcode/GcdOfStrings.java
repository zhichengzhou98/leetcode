package com.zzc.leetcode;

import java.util.ArrayList;

/**
 * @author zc.zhou
 * @Description 1071. 字符串的最大公因子 TODO easy way
 * @create 2023-07-18 21:37
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABCABC", "ABCAAA"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        //先求s1和s2长度的公因数
        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.min(len1, len2);
        ArrayList<Integer> gcdList = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (len1 % i == 0 && len2 % i == 0) {
                gcdList.add(i);
            }
        }
        for (int i = gcdList.size() - 1; i >= 0; i--) {
            int sectionLen = gcdList.get(i);
            //对于s1 将s1截断成len1 / gcdList.get(i) 段
            int section = len1 / sectionLen;
            boolean flag1 = true;
            for (int j = 0; j < sectionLen; j++) {
                boolean f1 = false;
                for (int k = 0; k < section - 1; k++) {
                    if (str1.charAt(k +j) != str1.charAt(sectionLen + k +j)) {
                        f1 = true;
                        break;
                    }
                }
                if (f1) {
                    flag1 = false;
                    break;
                }
            }

            //对于s2 将s2截断成len2 / i 段
            section = len2 / sectionLen;
            boolean flag2 = true;
            for (int j = 0; j < sectionLen; j++) {
                boolean f1 = false;
                for (int k = 0; k < section - 1; k++) {
                    if (str2.charAt(k+j) != str2.charAt(sectionLen + k +j)) {
                        f1 = true;
                        break;
                    }
                }
                if (f1) {
                    flag2 = false;
                    break;
                }
            }
            if (flag1 && flag2 && str1.substring(0, sectionLen).equals(str2.substring(0, sectionLen))) {
                return str1.substring(0, sectionLen);
            }
        }
        return "";
    }
}
