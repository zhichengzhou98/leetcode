package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-26 11:07
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int j = 0;
        while (j < nums.length) {
            int i = j + 1;
            while (i < nums.length && nums[i] - nums[i-1] == 1) {
                i++;
            }
            if (j == i - 1) {
                list.add(String.valueOf(nums[j]));
            }else {
                String res = nums[j] + "->" + nums[i - 1];
                list.add(res);
            }
            j = i;
        }
        return list;
    }
}
