package com.zzc.leetcode_jan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-09 12:14
 */
public class MinExtraChar {
    @Test
    public void test() {
        String[] dir = {"leet","code","leetcode"};
        System.out.println(minExtraChar("leetscode", dir));
    }

    Map<String, Integer> map = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        if (s.length() == 0) {
            return 0;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int minRes = s.length();
        for (int i = 0; i < dictionary.length; i++) {
            if (s.startsWith(dictionary[i])) {
                String sub = s.substring(dictionary[i].length());
                minRes = Math.min(minRes, minExtraChar(sub, dictionary));
            }
        }
        minRes = Math.min(1 + minExtraChar(s.substring(1), dictionary), minRes);
        map.put(s, minRes);
        return minRes;
    }
}
