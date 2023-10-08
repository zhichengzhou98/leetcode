package com.zzc.weekcompetition;

import com.zzc.leetcode_aug.XorOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-08 10:47
 */
public class MinOperations1 {
    public static void main(String[] args) {
        String s1 = "0110010001101011010";
        String s2 = "1011110101000001100";
        System.out.println(minOperations(s1, s2, 3));
    }

    public static int minOperations(String s1, String s2, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() % 2 != 0) {
            return -1;
        }
        if (list.size() == 0) {
            return 0;
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        int[] res = new int[ints.length];
        res[0] = x;
        res[1] = Math.min(x, ints[1] - ints[0]);
        for (int i = 2; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = Math.min(res[i - 1] + x, res[i - 2] + Math.min(ints[i] - ints[i - 1], x));
            }else {
                res[i] = Math.min(res[i - 1], res[i - 2] + Math.min(ints[i] - ints[i - 1], x));
            }
        }
        return res[res.length- 1];
    }
}
