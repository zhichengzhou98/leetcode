package com.zzc.weekcompetition;

import java.util.*;

/**
 * @author zc.zhou
 * @Description TODO: 01 背包 100042. 和为目标值的最长子序列的长度
 * @create 2023-10-28 22:48
 */
public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        LengthOfLongestSubsequence l = new LengthOfLongestSubsequence();
        //[2,13,7,3,14,8,11,10,7,13]
        //44
        List<Integer> list = new ArrayList<>(List.of(2,13,7,3,14,8,11,10,7,13));
        //List<Integer> list = new ArrayList<>(List.of(1,1,5,4,5));
        System.out.println(l.maxSubArrayLen(list, 44));
    }
    public int maxSubArrayLen(List<Integer> nums, int target) {
        int[] res = new int[target + 1];
        Arrays.fill(res, -1);
        res[0] = 0;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (res[i - num] != -1) {
                    res[i] = Math.max(res[i], res[i - num] + 1);
                }
            }
        }
        return res[target];
    }

}
