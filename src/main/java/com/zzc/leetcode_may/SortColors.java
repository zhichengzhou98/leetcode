package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-10 22:55
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else if (nums[i] == 2) {
                twoCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            nums[i] = 0;
        }
        for (int i = zeroCount; i < oneCount + zeroCount; i++) {
            nums[i] = 1;
        }
        for (int i = oneCount + zeroCount; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
