package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 21:22
 */
public class MinSpeedOnTime {
    public static void main(String[] args) {
        int[] dist = {1,1,100000};
        MinSpeedOnTime mSO = new MinSpeedOnTime();
        System.out.println(mSO.minSpeedOnTime(dist, 2.01));
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) {
            return -1;
        }
        int l = 1;
        int r = (int) Math.pow(10, 7) +1;
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, hour, dist)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, double hour, int[] dist) {
        double costs = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                //最后一趟不需要取整
                costs += (double) dist[i] / med;
            }else {
                //由于需要整点候车 因此需要向上取整
                costs =costs + (int)(dist[i] + med - 1)/med;
            }
        }
        return costs <= hour;
    }
}
