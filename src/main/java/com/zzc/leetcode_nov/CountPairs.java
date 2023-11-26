package com.zzc.leetcode_nov;

import java.util.Collections;
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

    public int countPairsV2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        int last = nums.size()-1;
        for (int i = 0; i < nums.size(); i++) {
            int num1 = nums.get(i);
            int num2 = target - num1;
            for (int j = last; j >= 0 ; j--) {
                int numJ = nums.get(j);
                if (numJ < num2) {
                    if (j >= i) {
                        res = res + j + 1 - 1;
                    }else {
                        res = res + j + 1;
                    }
                    last = j;
                    break;
                }
            }
        }
        return res/2;
    }
}
