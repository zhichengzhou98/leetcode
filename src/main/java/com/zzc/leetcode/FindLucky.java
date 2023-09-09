package com.zzc.leetcode;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-10 21:07
 */
public class FindLucky {
    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{0}));
    }

    public static int findLucky(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int count = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (max == arr[i]) {
                count++;
            }else {
                if (count ==max) {
                    return max;
                }else {
                    max = arr[i];
                    count = 1;
                }
            }
        }

        return count == max ? max : -1;
    }
}
