package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 12:26
 */
public class FindNumbers {
    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int item:nums) {
            if(isBitEven(item)){
                res++;
            }
        }
        return res;
    }

    public boolean isBitEven(int num) {
        int bit = 1;
        while (num >= 10) {
            num = num / 10;
            bit++;
        }
        return bit % 2 == 0;
    }
}
