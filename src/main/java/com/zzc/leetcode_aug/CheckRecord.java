package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-28 21:57
 */
public class CheckRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        int countA = 0;
        int contiL = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'A') {
                countA++;
                if (countA == 2) {
                    return false;
                }
                contiL = 0;
            }else if (a == 'L') {
                contiL++;
                if (contiL == 3) {
                    return false;
                }
            }else {
                contiL = 0;
            }
        }

        return true;
    }
}
