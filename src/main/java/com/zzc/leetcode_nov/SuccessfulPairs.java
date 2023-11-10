package com.zzc.leetcode_nov;

import java.util.Arrays;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-10 19:35
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        long[] needCount = new long[potions.length];
        for (int i = 0; i < needCount.length; i++) {
            needCount[i] = (success - 1) / potions[i] + 1;
        }
        Arrays.sort(needCount);
        for (int i = 0; i < spells.length; i++) {
            if (spells[i] < needCount[0]) {
                spells[i] = 0;
            }else {
                spells[i] = rightBoundary(needCount, spells[i]);
            }

        }
        return spells;
    }

    public int rightBoundary(long[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMedRight(nums[med], target)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return med + 1;
    }

    public boolean checkMedRight(long medNum, int target) {
        if (medNum <= target) {
            return true;
        }
        return false;
    }
}
