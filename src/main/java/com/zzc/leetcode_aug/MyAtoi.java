package com.zzc.leetcode_aug;

import java.lang.invoke.MutableCallSite;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-29 21:38
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }

    //s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
    public static int myAtoi(String s) {
        long res = 0;
        boolean pos = true;//表示正负
        boolean flag = false;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char c1 = s.charAt(0);

        if (!Character.isDigit(c1) && !Set.of('+', '-').contains(c1)) {
            return 0;
        }
        if (s.length() >= 2) {
            if (!Character.isDigit(s.charAt(0)) && !Character.isDigit(s.charAt(1))) {
                return 0;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                flag = true;
                res = res * 10 + (c - '0');
                if (pos && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }else if (!pos && -res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }else if (c == '-') {
                if (flag) {
                    break;
                }
                pos = false;
                flag = true;
            }else if (c == '+') {
                if (flag) {
                    break;
                }
                pos = true;
                flag = true;
            } else {
                if (flag) {
                    break;
                }
            }
        }

        return pos ? (int) res : -((int) res);
    }
}
