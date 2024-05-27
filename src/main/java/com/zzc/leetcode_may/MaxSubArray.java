package com.zzc.leetcode_may;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-15 17:44
 */
public class MaxSubArray {

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 100, -3, -4, -1, -2, -1, -5, -4}));
    }

    //[-2,1,-3,4,-1,2,1,-5,4]
    //输出：6
    //解释：连续子数组 [4,-1,2,1] 的和最大，为 6
    public int maxSubArray(int[] nums) {
        //0: 不包含当前数字 1：包含当前数字
        int[][] res = new int[nums.length][2];
        res[0][0] = Integer.MIN_VALUE;
        res[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][1]);
            res[i][1] = Math.max(nums[i], nums[i] + res[i - 1][1]);
        }
        return Math.max(res[nums.length - 1][0], res[nums.length - 1][1]);
    }
}
