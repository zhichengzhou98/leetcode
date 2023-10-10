package com.zzc.leetcode_oct;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-10 12:03
 */
public class SumDistance {
    public static void main(String[] args) {

    }
    private static int MOD = (int) (Math.pow(10, 9) + 7);
    public int sumDistance(int[] nums, String s, int d) {
        long[] des = new long[nums.length];
        //统计各个机器人的终点位置
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'L') {
                // -
                des[i] = (long) nums[i] - d;
            }else if (s.charAt(i) == 'R') {
                // +
                des[i] = (long) nums[i] + d;
            }
        }
        //排序
        Arrays.sort(des);
        long res = 0L;
        int i = 0;
        int j = des.length - 1;
        //统计des各个数字两两之差之和
        while (j >= i) {
            long begin = des[i];
            long end = des[j];
            long delt = (end - begin) % MOD;
            //中间元素的个数
            int cnt = Math.max(1, j - i);
            res = (res + cnt * delt % MOD)%MOD;
            i++;
            j--;
        }
        return (int)res;
    }
}
