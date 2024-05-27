package com.zzc.leetcode_may;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-11 21:20
 */
public class FindDuplicate {

    public static void main(String[] args) {

    }
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = nums[0];
        set.add(res);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }

        return res;
    }

}
