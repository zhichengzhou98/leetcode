package com.zzc.leetcode;

import java.util.ArrayList;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-27 12:19
 */
public class DecompressRLElist {
    public static void main(String[] args) {
        
    }

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int count = nums[i];
            for (int j = 0; j < count; j++) {
                list.add(nums[i+1]);
            }
            i += 2;
        }
        int[] ints = new int[list.size()];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = list.get(j);
        }
        return ints;
    }
}
