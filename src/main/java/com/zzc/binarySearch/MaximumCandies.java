package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 21:12
 */
public class MaximumCandies {
    public static void main(String[] args) {

    }

    public int maximumCandies(int[] candies, long k) {
        int l = 0;
        int r = (int) Math.pow(10, 7);
        //求右边界 糖果的堆数 >= k
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMedRight(med, k, candies)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return med;
    }

    public boolean checkMedRight(int med, long k, int[] candies) {
        long counts = 0;
        for (int i = 0; i < candies.length; i++) {
            counts += candies[i] / med;
        }
        return counts >= k;
    }
}
