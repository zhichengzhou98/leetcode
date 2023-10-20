package com.zzc.leetcode_oct;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-19 12:18
 */
public class TupleSameProduct {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10}));
    }
    public static int tupleSameProduct(int[] nums) {
        //key 为乘积 value 为出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int dul = nums[i] * nums[j];
                map.put(dul, map.getOrDefault(dul, 0) + 1);
            }
        }
        System.out.println(map.values());
        return map.values().stream().filter(i -> i >= 2).map(i -> 4 * i * (i - 1)).mapToInt(Integer::intValue).sum();
    }
}
