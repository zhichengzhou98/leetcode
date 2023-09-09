package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 12:45
 */
public class ReplaceElements {

    public static void main(String[] args) {

    }
    public int[] replaceElements(int[] arr) {
        int len = arr.length - 1;
        int max = arr[len];
        arr[len] = -1;
        for (int i = len - 1; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }

        return arr;
    }
}
