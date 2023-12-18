package com.zzc.leetcode_dec;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-17 17:57
 */
public class DivideArray {
    public static void main(String[] args) {

    }

    public int[][] divideArray(int[] nums, int k) {
        int len = nums.length / 3;
        int[][] res = new int[len][3];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=3) {
            if (nums[i + 2] - nums[i] <= k) {
                res[i/3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            }else {
                return new int[len][1];
            }
        }
        return res;
    }
}
