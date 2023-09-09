package com.zzc.leetcode_aug;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-18 21:42
 */
public class CanBeEqual {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
