package com.topic.template;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 求最大公因数
 * @create 2024-01-06 20:20
 */
public class GreatestCommonDivisors {
    @Test
    public void test() {
        System.out.println(maxCommonDivisors2(985, 457));
        System.out.println(maxCommonDivisors1(985, 457));
    }
    public int maxCommonDivisors(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    //辗转相除
    public int maxCommonDivisors2(int a, int b) {
        int dividend = Math.max(a, b);
        int divisor = Math.min(a, b);
        //余数 remainder
        int remainder = dividend % divisor;
        if (remainder == 0) {
            return divisor;
        }
        return maxCommonDivisors2(divisor, remainder);
    }
    public int maxCommonDivisors1(int a, int b) {
        int maxRes = Math.min(a, b);
        for (int i = maxRes; i >=  1 ; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
