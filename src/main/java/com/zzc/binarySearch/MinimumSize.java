package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-18 20:27
 */
public class MinimumSize {
    public static void main(String[] args) {

    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = (int)Math.pow(10, 9);
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, maxOperations, nums)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int maxOperations, int[] nums) {
        //袋子中的球小于等于med
        //实际操作次数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > med) {
                //操作次数 = 最终堆数 - 1
                //堆数需要向上取整
                count += (nums[i] + med - 1) / med - 1;
                if (count > maxOperations) {
                    return false;
                }
            }
        }
        return true;
    }
}
