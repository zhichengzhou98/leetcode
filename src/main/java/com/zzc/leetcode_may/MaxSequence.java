package com.zzc.leetcode_may;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-08 14:37
 */
public class MaxSequence {

    @Test
    public void testMaxSequence() {
        int[] nums = {-4, -4, 2, -6, 9, 6, 8, -6, -9, -1, 9, 5, 2, -6, 0};
        System.out.println(longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxRes = 1;
        for (int i : nums) {
            if (set.isEmpty()) {
                break;
            }
            if (!set.contains(i)) {
                continue;
            }
            set.remove(i);
            int left = i - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            int right = i + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            maxRes = Math.max(maxRes, right - left - 1);
        }
        return maxRes;
    }

}
