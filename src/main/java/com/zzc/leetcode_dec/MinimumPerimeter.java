package com.zzc.leetcode_dec;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-24 22:25
 */
public class MinimumPerimeter {
    public static void main(String[] args) {

    }

    //二分 求左边界 2n * (n + 1) * (2n + 1) >= neededApples, n 为边长的1/2
    public long minimumPerimeter(long neededApples) {
        return leftBoundary(neededApples) * 8;
    }

    public long leftBoundary(long target){
        long l = 0L;
        long r = (long) Math.pow(10, 5);
        long med = (r - l) / 2 + l;
        while (l < r) {
            if (2*med * (med + 1) * (2*med + 1) >= target) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }
}
