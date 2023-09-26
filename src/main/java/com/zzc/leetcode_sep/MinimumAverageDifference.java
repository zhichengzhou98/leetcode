package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-25 21:46
 */
public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //前缀
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        long sum = nums[0];
        for (int i = 1; i < pre.length; i++) {
            sum += nums[i];
            pre[i] = (int) (sum / ( i + 1));
        }
        //后缀
        int[] suf = new int[nums.length];
        suf[suf.length - 1] = 0;
        sum = 0L;
        for (int i = suf.length - 2; i >= 0; i--) {
            sum += nums[i + 1];
            suf[i] = (int) (sum / (suf.length - i -1));
        }
        int index = nums.length - 1;
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < pre.length; i++) {
            long diff = Math.abs(pre[i] - suf[i]);
            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        return index;
    }
    /*public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //前缀
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        //后缀
        long[] suf = new long[nums.length];
        suf[suf.length - 1] = 0;
        for (int i = suf.length - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i + 1];
        }
        int index = nums.length - 1;
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < pre.length; i++) {
            int preLen = i+ 1;
            int sufLen = nums.length - preLen;
            int sec;
            if (sufLen == 0) {
                sec = 0;
            }else {
                sec = (int) (suf[i]/sufLen);
            }
            long diff = Math.abs(pre[i]/preLen - sec);
            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        return index;
    }*/
}
