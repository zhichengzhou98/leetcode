package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * @create 2023-07-21 21:39
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(25));
    }
    /*public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }*/

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n - 2; i++) {
            int temp = c;
            c = a + b + c;
            a = b;
            b = temp;
        }
        return c;
    }
}
