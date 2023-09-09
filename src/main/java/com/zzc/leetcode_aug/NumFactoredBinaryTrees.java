package com.zzc.leetcode_aug;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-29 12:26
 */
public class NumFactoredBinaryTrees {
    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[]{2,3,6,18}));
    }
    public static int numFactoredBinaryTrees(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);
        HashSet<Integer> arrSet = new HashSet<>();
        for(int i : arr) {
            arrSet.add(i);
        }

        long[] count = count(arr, arrSet);
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = (sum + count[i]) % ((int) (Math.pow(10, 9) + 7));
        }
        return (int) sum;
    }

    public static long[] count(int[] arr, Set<Integer> set) {
        long[] res = new long[arr.length];
        HashMap<Integer, Long> map = new HashMap<>();
        res[0] = 1;
        map.put(arr[0], 1L);
        for (int i = 1; i < arr.length; i++) {
            res[i] = 1;
            //以arr[i]为根结点构造二叉树
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] % arr[j] == 0 && set.contains(arr[j]) && set.contains(arr[i] / arr[j])) {
                    res[i] = (res[i] + (map.get(arr[j]) * map.get(arr[i] / arr[j]))%((int) (Math.pow(10, 9) + 7)) )% ((int) (Math.pow(10, 9) + 7));
                }
            }
            map.put(arr[i],res[i]);
        }
        return res;
    }
}
