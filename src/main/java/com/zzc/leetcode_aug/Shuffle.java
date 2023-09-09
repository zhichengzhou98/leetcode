package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-20 11:50
 */
public class Shuffle {
    public static void main(String[] args) {

    }

    public int[] shuffle(int[] nums, int n) {
        int[] res =  new int[2 * n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            res[j++] = nums[i];
            res[j++] = nums[i+n];
        }
        return res;
    }
}
