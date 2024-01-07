package com.zzc.leetcode_dec;

import java.util.Arrays;

/** 滑动窗口！！！
 * @author zc.zhou
 * @Description
 * @create 2023-12-18 22:09
 */
public class CountSubarrays {
    public static void main(String[] args) {
        CountSubarrays cS = new CountSubarrays();
        int[] nums = {1,3,2,3,3};
        System.out.println(cS.countSubarrays(nums, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int l = 0;
        //窗口中满足条件的元素的个数
        int currNum = 0;
        //结果
        long res = 0L;
        //枚举右端点
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == maxNum) {
                currNum++;
            }
            while (currNum > k) {
                if (nums[l] == maxNum) {
                    currNum--;
                }
                if (currNum == k) {
                    res++;
                }
                l++;
            }
        }
        return res;
    }
}
