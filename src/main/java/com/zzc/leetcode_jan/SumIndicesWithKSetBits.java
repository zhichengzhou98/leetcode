package com.zzc.leetcode_jan;

import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-25 23:44
 */
public class SumIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
