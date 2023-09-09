package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 12:13
 */
public class MinSubsequence {
    public static void main(String[] args) {

    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        ArrayList<Integer> res = new ArrayList<>();
        int resSum = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            res.add(nums[i]);
            resSum = resSum + nums[i];
            sum = sum - nums[i];
            if (resSum >sum) {
                return res;
            }
        }
        return res;
    }
}
