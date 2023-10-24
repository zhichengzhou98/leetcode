package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-24 11:59
 */
public class NumRollsToTarget {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
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
                int minL = j - i + 1;
                minL = Math.min(minL, k);
                for (int l = Math.max(1, (j - (i - 1) * k)); l <= Math.min(j - 1, minL); l++) {
                    // j - l >= i - 1  => l <= j - i + 1
                    // ( i - 1 ) * k >= j - l l >= (j - (i - 1) * k)
                    a = (a + ((res[1][l] * res[i-1][j-l]) % MOD)) % MOD;
                }
                res[i][j] = a;
            }
        }
        return (int) res[n][target];
    }
}
