package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 8:42
 */
public class MinimumOperations {
    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //奇数位置数字出现的次数
        Map<Integer, Integer> oddMap = new HashMap<>();
        int evenCnt = (nums.length + 1) / 2;
        int oddCnt = (nums.length) / 2;
        Map<Integer, Integer> evenMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            }else {
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        int evenMaxCount = evenMap.values().stream().max(Integer::compareTo).orElse(0);
        ArrayList<Integer> evenList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : evenMap.entrySet()) {
            if (entry.getValue() == evenMaxCount) {
                evenList.add(entry.getKey());
            }
            if (evenList.size() >= 2) {
                break;
            }
        }
        int oddMaxCount = oddMap.values().stream().max(Integer::compareTo).orElse(0);
        ArrayList<Integer> oddList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
            if (entry.getValue() == oddMaxCount) {
                oddList.add(entry.getKey());
            }
            if (oddList.size() >= 2) {
                break;
            }
        }
        if (evenList.size() >= 2 || oddList.size() >= 2 || evenList.get(0).intValue() != oddList.get(0)) {
            return nums.length - evenMaxCount - oddMaxCount;
        }
        int evenSecondMaxCount = evenMap.values().stream()
                .filter(i -> i < evenMaxCount)
                .max(Integer::compareTo).orElse(0);
        int oddSecondMaxCount = oddMap.values().stream()
                .filter(i -> i < oddMaxCount)
                .max(Integer::compareTo).orElse(0);
        return nums.length - Math.max(evenMaxCount + oddSecondMaxCount, evenSecondMaxCount + oddMaxCount);
    }
}
