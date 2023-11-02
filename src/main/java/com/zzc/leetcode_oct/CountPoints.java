package com.zzc.leetcode_oct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-02 12:01
 */
public class CountPoints {
    public int countPoints(String rings) {
        Set[] sets = new Set[10];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<Character>();
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < rings.length(); i+= 2) {
            char color = rings.charAt(i);
            int gan = rings.charAt(i + 1) - '0';
            sets[gan].add(color);
            if (sets[gan].size() == 3) {
                res.add(gan);
            }
            if (res.size() == 10) {
                return 10;
            }
        }
        return res.size();
    }
}
