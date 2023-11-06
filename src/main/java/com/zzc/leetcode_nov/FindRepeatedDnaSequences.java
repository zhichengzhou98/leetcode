package com.zzc.leetcode_nov;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-05 11:48
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {

    }

    //定长滑窗
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return  new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int l = 0;
        int r = l + 10;
        while (r <= s.length() ) {
            String sub = s.substring(l , r);
            map.put(sub,map.getOrDefault(sub, 0) + 1);
            l++;
            r++;
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
