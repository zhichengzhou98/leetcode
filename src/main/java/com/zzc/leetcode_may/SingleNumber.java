package com.zzc.leetcode_may;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-10 22:38
 */
public class SingleNumber {
    @Test
    public void testFun() {
        int[] res = {1,2,3,1,2};
        System.out.println(singleNumber(res));
    }
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
