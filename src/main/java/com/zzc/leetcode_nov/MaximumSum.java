package com.zzc.leetcode_nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-18 18:06
 */
public class MaximumSum {
    public int maximumSum(int[] nums) {
        List[] list = new List[82];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i >=0 ; i--) {
            int index = sumOfNum(nums[i]);
            list[index].add(nums[i]);
        }
        int res = -1;
        for (int i = 0; i < list.length; i++) {
            List<Integer> arrayList = list[i];
            if (arrayList.size() >= 2) {
                res = Math.max(res, arrayList.get(0) + arrayList.get(1));
            }
        }
        return res;
    }

    public int sumOfNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
