package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-24 11:59
 */
public class NumRollsToTarget {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(3, 6, 3));
    }
    private static int MOD = (int) (Math.pow(10, 9) + 7);

    public static int numRollsToTarget(int n, int k, int target) {
        long[][] res = new long[n + 1][target + 1];
        //n = 0 为 0个骰子 k = 0为0个面
        for (int i = 1; i < target + 1; i++) {
            if (k >= i) {
                res[1][i] = 1;
            }
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                long a = 0L;
                for (int m = 1; m <= i - 1; m++) {
                    for (int l = 1; l <= j - 1; l++) {
                        a = (a + (res[m][l] * res[i-m][j-l] % MOD)) % MOD;
                    }
                }
                res[i][j] = a;
            }
        }
        return (int) res[n][target];
    }
}
