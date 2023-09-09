package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-22 17:02
 */
public class BubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(10));
    }
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n >= 10) {
            int b = n % 10;
            n = n / 10;
            product = product * b;
            sum = sum + b;
        }
        return product * n - sum - n;
    }
}
