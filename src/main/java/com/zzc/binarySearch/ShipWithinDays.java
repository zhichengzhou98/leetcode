package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-18 19:55
 */
public class ShipWithinDays {
    public static void main(String[] args) {
        ShipWithinDays sWD = new ShipWithinDays();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sWD.shipWithinDays(weights, 5));
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0];
        int r = 25000000;
        //查找左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, days, weights)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int days, int[] weights) {
        int needDay = 1;
        int temp = med;
        for (int i = 0; i < weights.length; i++) {
            if (med - weights[i] < 0) {
                needDay++;
                med = temp - weights[i];
                if (med < 0 || needDay > days) {
                    return false;
                }
            }else {
                med -= weights[i];
            }
        }
        return needDay <= days;
    }
}
