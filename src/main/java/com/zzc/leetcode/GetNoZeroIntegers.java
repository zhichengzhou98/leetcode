package com.zzc.leetcode;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-28 12:04
 */
public class GetNoZeroIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetNoZeroIntegers().getNoZeroIntegers(2)));
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (!(isContainZero(i) || isContainZero(n-i))) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

    public boolean isContainZero(int n) {
        if (n == 0){
            return true;
        }
        while (n >= 10) {
            if (n % 10 == 0) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }
}
