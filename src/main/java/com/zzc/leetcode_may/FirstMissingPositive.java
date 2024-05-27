package com.zzc.leetcode_may;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-20 15:48
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n + 1; i++) {
            set.add(i);
        }
        for (int i : nums) {
            set.remove(i);
        }

        return set.stream().min(Integer::compareTo).get();
    }

    public int firstMissingPositiveV1(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public int firstMissingPositiveV2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public int firstMissingPositiveV3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (current <= n) {
                nums[current - 1] = -Math.abs(nums[current - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    @Test
    public void testFun() {
        System.out.println(firstMissingPositiveV3(new int[]{1, 1}));
    }
}
