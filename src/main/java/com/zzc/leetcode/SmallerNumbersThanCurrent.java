package com.zzc.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-02 20:58
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent1(new int[]{8,1,2,2,3})));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0};
        }
        int[] res = new int[nums.length];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int count = 0;
        HashMap<Integer, Integer> numCountsMap = new HashMap<>();
        numCountsMap.put(copy[0], 0);
        for (int i = 1; i < copy.length; i++) {
            if(copy[i] == copy[i-1]) {
                count++;
            }else {
                count++;
                numCountsMap.put(copy[i], count);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = numCountsMap.get(nums[i]);
        }
        return res;
    }

    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] countNum = new int[101];
        for (int i = 0; i < nums.length; i++) {
            countNum[nums[i]]++;
        }
        for (int i = 1; i < countNum.length; i++) {
            countNum[i] = countNum[i - 1] + countNum[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i] == 0 ? 0 : countNum[nums[i]-1];
        }
        return res;
    }
}
