package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-04 18:12
 */
public class MaximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        //前缀最大值
        int[] preMax = new int[nums.length];
        preMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        //后缀最大值
        int[] sufMax = new int[nums.length];
        sufMax[sufMax.length - 1] = nums[nums.length - 1];
        for (int i = sufMax.length - 2; i >= 0 ; i--) {
            sufMax[i] = Math.max(sufMax[i+ 1], nums[i]);
        }
        long res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //中间数的索引为i
            res = Math.max(res, (long) (preMax[i - 1] - nums[i]) * sufMax[i + 1]);
        }
        return res;
    }
}
