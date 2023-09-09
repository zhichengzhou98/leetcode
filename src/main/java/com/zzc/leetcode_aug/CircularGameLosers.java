package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-31 22:19
 */
public class CircularGameLosers {
    public static void main(String[] args) {
        System.out.println(circularGameLosers(4, 1));
    }

    public static int[] circularGameLosers(int n, int k) {
        //接到球的人集合
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int next = 1;
        for (int i = 1; ; i++) {
            next = next + i * k;
            next = ( next - 1) % n + 1;
            if (set.contains(next)) {
                break;
            }
            set.add(next);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
