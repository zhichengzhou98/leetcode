package com.zzc.weekcompetition;

import java.sql.SQLOutput;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 10:31
 */
public class CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1200,1230));
    }
    public static int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            String str = String.valueOf(i);
            if (str.length() % 2 == 0) {
                int len = str.length() / 2;
                int before = 0;
                int after = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (j < len) {
                        before += str.charAt(j) - '0';
                    }else {
                        after += str.charAt(j) - '0';
                    }
                }
                if (before == after) {
                    res++;
                }
            }
        }
        return res;
    }
}
