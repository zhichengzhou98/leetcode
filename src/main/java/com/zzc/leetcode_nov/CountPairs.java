package com.zzc.leetcode_nov;

import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-24 12:16
 */
public class CountPairs {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num1 = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                int num2 = nums.get(j);
                if (num1 + num2 < target) {
                    res++;
                }
            }
        }
        return res;
    }
}
