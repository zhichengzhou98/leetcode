package com.zzc.template;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 快速幂
 * @create 2024-03-27 22:20
 */
public class ExponentiationBySquaring {
    @Test
    public void test() {
        System.out.println(exponentiationBySquaring(2, 87));
    }

    public static int MOD = (int) (Math.pow(10, 9) + 7);


    public long exponentiationBySquaring(int a, int b) {
        //求a的b次幂
        if (b == 1) {
            return a % MOD;
        }

        if (b % 2 == 0) {
            long x = exponentiationBySquaring(a, b/2) % MOD;
            return x * x % MOD;
        }
        long y = exponentiationBySquaring(a, (b-1)/2) % MOD;
        return y * y % MOD * a % MOD;
    }
}
