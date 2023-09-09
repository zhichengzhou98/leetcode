package com.zzc.leetcode_aug;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-24 21:39
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[] {1, 5, 7, 10}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        if (max == min) {
            return true;
        }
        if ((max -min) % (arr.length - 1) != 0) {
            return false;
        }
        int d = (max - min) / (arr.length - 1);
        int[] res = new int[arr.length];
        // an = a1 + (n -1)*d  => n - 1 = (an - a1) / d
        for (int i = 0; i < arr.length; i++) {
            //TODO: to be confirmed, 把 n - 1 存入set 统计set的size是否为n？？？
            if ((arr[i] - min) % d != 0) {
                return false;
            }
            res[(arr[i] - min) / d]--;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] != d) {
                return false;
            }
        }
        return true;
    }
}
