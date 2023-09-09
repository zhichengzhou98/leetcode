package com.zzc.leetcode_aug;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-19 21:13
 */
public class MaxProduct {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {

        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            }else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (max -1) * (secondMax - 1);
    }

    /*public int maxProduct(int[] nums) {
        //PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(nums);
        int len = nums.length - 1;
        return (nums[len] - 1) * (nums[len - 1] - 1);
    }*/
}
