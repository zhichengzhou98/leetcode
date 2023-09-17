package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 20:09
 */
public class MinEatingSpeed {
    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        //最小速度
        int l = 1;
        //最大速度
        int r = (int) Math.pow(10, 9);
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, h, piles)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int speed, int hour, int[] piles) {
        int t = 0;
        for (int i = 0; i < piles.length; i++) {
            //第i堆香蕉
            int count = piles[i];
            t += (int) Math.ceil((double) count / speed);
            /*if (count % speed == 0) {
                t = count / speed + t;
            }else {
                t += count / speed + 1;
            }*/
        }
        return t <= hour;
    }
}
