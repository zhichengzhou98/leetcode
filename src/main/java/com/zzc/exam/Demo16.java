package com.zzc.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzc
 * @Description
 * @create 2023-03-18 19:26
 */
public class Demo16 {
    public static void main(String[] args) {
        System.out.println(toHex(15));
        System.out.println(toHex(-1));
        System.out.println(Math.sqrt(6667));
    }

    public static String toHex(int num) {
        if (num >= 0) {
            return getString(num);
        }
        return getString(Integer.toUnsignedLong(num));


    }

    @org.jetbrains.annotations.NotNull
    private static String getString(long num) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i <= 15; i++) {
            if (i <= 9) {
                map.put(i + "", i + "");
            } else {
                map.put(i + "", Character.toString((char) (i - 10 + 'a')));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (num > 15) {
            long res = num % 16;
            sb.append(map.get(res + ""));

            num /= 16;
        }
        sb.append(map.get(num + ""));
        return sb.reverse().toString();
    }
}
