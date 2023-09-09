package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-26 12:10
 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(6);
        treeSet.add(4);
        treeSet.add(1);
        System.out.println(treeSet);
    }

    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> integers = new TreeSet<>();
        for(int i: arr) {
            integers.add(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        while (!integers.isEmpty()) {
            map.put(integers.pollFirst(), i);
            i++;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = map.get(arr[j]);
        }
        return arr;
    }
}
