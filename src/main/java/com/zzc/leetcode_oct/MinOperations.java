package com.zzc.leetcode_oct;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-01 8:20
 */
public class MinOperations {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            set.add(i);
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            Integer integer = nums.get(i);
            set.remove(integer);
            if (set.isEmpty()) {
                return nums.size() - i;
            }
        }
        return nums.size();
    }


    public int minOperations(int[] nums) {
        //统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int cnt = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return - 1;
            }else if (value % 3 == 0) {
                cnt += value/3;
            }else {
                cnt += value/3 + 1;
            }
        }
        return cnt;
    }
}
