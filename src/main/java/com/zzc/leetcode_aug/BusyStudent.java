package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-16 21:08
 */
public class BusyStudent {
    public static void main(String[] args) {

    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }

        return res;
    }
}
