package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-22 16:56
 */
public class MinTimeToVisitAllPoints {
    public static void main(String[] args) {

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] a = points[i];
            int[] b = points[i + 1];
            time = time + Math.max(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1]));
        }

        return time;
    }
}
