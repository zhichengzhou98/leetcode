package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 13:20
 */
public class SumZero {
    public static void main(String[] args) {

    }

    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 1) {
            res[0] = 0;
            int j = 1;
            for (int i = 0; i < n / 2; i++) {
                res[j] = j;
                res[j + 1] = -j;
                j = j + 2;
            }
        }else {
            int j = 0;
            for (int i = 0; i < n / 2; i++) {
                res[j] = j + 1;
                res[j + 1] = -(j + 1);
                j = j + 2;
            }
        }

        return res;
    }
}
