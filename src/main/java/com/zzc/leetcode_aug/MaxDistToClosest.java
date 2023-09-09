package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-22 19:48
 */
public class MaxDistToClosest {
    public static void main(String[] args) {

    }

    public int maxDistToClosest(int[] seats) {
        int i = 0;
        int maxBlank = 0;
        while (i < seats.length && seats[i] != 1) {
            i++;
        }
        maxBlank = Math.max(i, maxBlank);
        int j = i+1;
        while (j < seats.length) {
            while (j < seats.length &&seats[j] != 1) {
                j++;
            }
            if (j == seats.length) {
                maxBlank = Math.max(j - 1 - i, maxBlank);
            }else {
                maxBlank = Math.max((j - i) / 2, maxBlank);
            }
            i = j;
            j++;
        }
        return maxBlank;
    }
}
