package com.zzc.leetcode_nov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-21 12:07
 */
public class MinDeletion {

    @Test
    public void testFun() {
        int[] nums = {0,6,6,1,8,7};
        System.out.println(minDeletion(nums));
    }
    public int minDeletion(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (res.size() % 2 == 0) {
                res.add(nums[i]);
            }else if(nums[i] != res.get(res.size() - 1)){
                res.add(nums[i]);
            }
            i++;
        }
        if (res.size() % 2 == 0) {
            return nums.length - res.size();
        }
        return nums.length - res.size() + 1;
    }
}
