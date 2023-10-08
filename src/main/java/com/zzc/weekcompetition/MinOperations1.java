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
        int cnt1 = 0;
        int cnt2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                cnt1++;
            }
            if (s2.charAt(i) == '1') {
                cnt2++;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (Math.abs(cnt1- cnt2) % 2 != 0) {
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
   /* public static int minOperations(String s1, String s2, int x) {
        int cnt1 = 0;
        int cnt2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                cnt1++;
            }
            if (s2.charAt(i) == '1') {
                cnt2++;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (Math.abs(cnt1- cnt2) % 2 != 0) {
            return -1;
        }
        int cnt = 0;
        if (list.size() == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < list.size();) {
            Integer currentIndex = list.get(i);
            Integer lastIndex = list.get(i - 1);
            if (currentIndex - lastIndex < x) {
                cnt += currentIndex - lastIndex;
                i+=2;
            }else {
                set.add(i - 1);
                set.add(i);
                i++;
            }
        }
        cnt+= set.size() / 2 * x;

        //
        int cnt11 = 0;

        Set<Integer> set1 = new HashSet<>();
        for (int i = list.size() - 2; i >=0;) {
            Integer currentIndex = list.get(i);
            Integer lastIndex = list.get(i + 1);
            if (lastIndex - currentIndex < x) {
                cnt11 += lastIndex - currentIndex;
                i-=2;
            }else {
                set1.add(i - 1);
                set1.add(i);
                i--;
            }
        }
        cnt11+= set1.size() / 2 * x;
        return Math.min(cnt, cnt11);
    }*/
}
