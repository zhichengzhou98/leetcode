package com.zzc.leetcode_oct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-14 13:15
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int[] singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.isEmpty() && set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
