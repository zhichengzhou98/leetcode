package com.zzc.binarySearch;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-18 20:14
 */
public class MinimizedMaximum {
    public static void main(String[] args) {

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        //求左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, n, quantities)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int n, int[] quantities) {
        //每份为不超过med， 被分为n份
        int fenShu= 0;
        for (int i = 0; i < quantities.length; i++) {
            int count = quantities[i];
            if (count <= med) {
                fenShu++;
            }else {
                //向上取整
                fenShu += (count + med - 1) / med;
            }
            if (fenShu > n) {
                return false;
            }
        }
        return fenShu <= n;
    }
}
