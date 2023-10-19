package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-18 21:26
 */
public class FindIndices {
    public static void main(String[] args) {

    }
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
