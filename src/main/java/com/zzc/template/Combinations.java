package com.zzc.template;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 计算组合数
 * @create 2023-10-28 10:05
 */
public class Combinations {
    //取模
    public static final int MOD = 998244353;
    @Test
    public void testCombinations() {
        System.out.println(calculateCombinations(100, 50));
    }

    //C(n, m) = n!/(m! * (n - m)!)
    public long calculateCombinations(int n, int m) {
        long nFac = calculateFactorial(n);
        long fenMu = calculateFactorial(m) * calculateFactorial(n - m) % MOD;
        return (nFac * modInverse(fenMu)) % MOD;
    }

    //求逆元
    public  long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
    public long modPow(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            y = y >> 1; // y = y / 2
            x = (x * x) % MOD;
        }
        return result;
    }

    public long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        long res = 1;
        for (int i = 1; i <= n ; i++) {
            res = res * i % MOD;
        }
        return res;
    }
}
