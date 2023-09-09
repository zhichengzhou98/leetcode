package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-05 9:17
 */
public class MinNumber {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int[] set1 = new int[9];
        for (int i = 0; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            set1[nums1[i]-1]++;
        }
        //取两个数组交集
        int unionMin = 10;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums2.length; i++) {
            min2 = Math.min(min2, nums2[i]);
            if (set1[nums2[i] - 1] > 0) {
                unionMin = Math.min(unionMin, nums2[i]);
            }
        }
        if (unionMin!= 10) {
            return unionMin;
        }
        return Math.min(10 * min2 + min1, 10 * min1 + min2);
    }
}
