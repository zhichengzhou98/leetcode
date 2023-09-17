package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 9:19
 */
public class RobII {
    public static void main(String[] args) {
        int[] arr = {4,1,2,7,5,3,1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        if (nums.length == 2) {
            max = Math.max(max, nums[1]);
            return max;
        }
        if (nums.length == 3) {
            max = Math.max(max, nums[1]);
            max = Math.max(max, nums[2]);
            return max;

        }
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        res[2] = Math.max(res[1], nums[2]);
        int[] temp = new int[nums.length - 3];
        int[] temp1 = new int[nums.length];
        temp[0] = nums[1];
        temp1[0] = nums[0];
        temp1[1] = res[1];
        temp1[2] = Math.max(nums[2] + temp1[0], temp1[1]);
        for (int i = 3; i < nums.length; i++) {
            if (i == 4) {
                temp[1] = Math.max(nums[1], nums[2]);
            } else if (i > 4) {
                temp[i- 3] = Math.max(nums[i - 2] + temp[i - 5], temp[i - 4]);
            }
            temp1[i] = Math.max(nums[i] + temp1[i-2], temp1[i-1]);
            res[i] = Math.max(nums[i] + temp[i - 3], temp1[i - 1]);
        }

        return res[res.length - 1];
    }
}
