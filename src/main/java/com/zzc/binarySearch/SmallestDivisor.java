package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 21:01
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = (int) Math.pow(10, 6);
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, threshold, nums)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int threshold, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            //向上取整
            sum += (current + med - 1) / med;
        }
        return sum <= threshold;
    }

}
