package com.zzc.leetcode_dec;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-17 19:18
 */
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int theorySum = 0;
        int actualSum = 0;
        int i = 1;
        int repeatNum = 0;
        Set<Integer> set = new HashSet<>();
        for(int [] arr : grid) {
            for(int num : arr) {
                theorySum += i;
                i++;
                actualSum += num;
                if (!set.isEmpty() && set.contains(num)) {
                    repeatNum = num;
                }
                set.add(num);
            }
        }
        return new int[]{repeatNum, theorySum - (actualSum - repeatNum)};
    }
}
