package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-20 20:14
 */
public class MinDays {
    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (double)m * k) {
            //花不够
            return -1;
        }
        int l = 1;
        int r = (int)Math.pow(10, 9) + 1;
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, m, k, bloomDay)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int m, int k, int[] bloomDay) {
        int cnt = 0;
        int i = 0;
        while (i < bloomDay.length) {
            while (i < bloomDay.length && bloomDay[i] > med) {
                i++;
            }
            if (i == bloomDay.length) {
                break;
            }
            int j = i + 1;
            while (j < bloomDay.length && bloomDay[j] <= med) {
                j++;
            }
            cnt += (j - i) / k;
            if (cnt >= m) {
                return true;
            }
            i = j;
        }
        return false;
    }
}
