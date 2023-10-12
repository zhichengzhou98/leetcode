package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-12 9:16
 */
public class FindTheArrayConcVal {
    public static void main(String[] args) {

    }
    public long findTheArrayConcVal(int[] nums) {
        long res = 0L;
        int l = 0;
        int r = nums.length - 1;
        while (r >= l) {
            if (r > l) {
                int lNum = nums[l];
                int rNum = nums[r];
                res += Long.parseLong(String.valueOf(lNum) + rNum);
            }else {
                int lNum = nums[l];
                res += Long.parseLong(String.valueOf(lNum));
            }
            l++;
            r--;
        }
        return res;
    }
}
