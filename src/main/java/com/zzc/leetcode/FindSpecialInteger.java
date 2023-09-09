package com.zzc.leetcode;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 二分法
 * @create 2023-07-23 10:48
 */
public class FindSpecialInteger {
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }

    public static int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int count = 1;
        int item  = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == item) {
                count++;
            } else {
                count = 1;
                item = arr[i];
            }
            if (count > arr.length * 0.25) {
                return arr[i];
            }
        }
        return arr[0];
    }

    /*public static int findSpecialInteger(int[] arr) {
        int len = arr.length / 4;
        int i = 0;
        for (; i + len < arr.length;) {
            if (arr[i + len] == arr[i]) {
                return arr[i];
            }else {
                i = i + len;
            }
        }
        return arr[i];
    }*/
}
