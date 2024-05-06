package com.zzc.leetcode_may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-06 21:40
 */
public class TwoSum {

    @Test
    public void test() {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum1(arr, 9)));
    }
    //排序
    public int[] twoSum(int[] nums, int target) {

        int [][] arrs = new int[nums.length][2];
        for (int i = 0; i <arrs.length ; i++) {
            arrs[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arrs, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = arrs.length - 1;
        while (j >= i) {
            if (arrs[i][0] + arrs[j][0] == target) {
                return new int[]{arrs[i][1], arrs[j][1]};
            }else if (arrs[i][0] + arrs[j][0] >= target) {
                j--;
            }else {
                i++;
            }
        }
        return new int[]{arrs[i][1], arrs[j][1]};
    }

    //哈希表
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int targetVale = target - value;
            if (valueIndexMap.containsKey(targetVale) ) {
                return new int[]{i, valueIndexMap.get(targetVale)};
            }else {
                valueIndexMap.put(value, i);
            }
        }
        return null;
    }
}
