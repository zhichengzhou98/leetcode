package com.zzc.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-30 11:11
 */
public class CheckIfExist {
    public static void main(String[] args) {

    }

    public boolean checkIfExist(int[] arr) {
        long count = Arrays.stream(arr).filter(item -> item == 0).count();
        Set<Integer> set = Arrays.stream(arr).boxed().filter(item -> item != 0).collect(Collectors.toSet());
        for (int i : arr) {
            if (i % 2 == 0) {
                int j = i / 2;
                if (set.contains(j)) {
                    return true;
                }
            }
        }
        return count >= 2;
    }

}
