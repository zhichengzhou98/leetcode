package com.zzc.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-07 21:01
 */
public class CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(new CountLargestGroup().countLargestGroup(1786));
    }
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(bitSum(i), map.getOrDefault(bitSum(i), 0) + 1);
        }
        int integer = map.values().stream().max(Integer::compareTo).get();
        long count = map.values().stream().filter(value -> value == integer).count();

        return (int) count;
    }

    public int bitSum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum + n;
    }

}
