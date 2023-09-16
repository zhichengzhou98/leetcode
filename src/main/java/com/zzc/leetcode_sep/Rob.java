package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 1:06
 */
public class Rob {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < money.length; i++) {
            money[i] = Math.max(money[i - 1], nums[i] + money[i - 2]);
        }

        return money[money.length - 1];
    }
}
