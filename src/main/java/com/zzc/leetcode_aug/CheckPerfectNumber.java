package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 20:15
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num <= 5) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum - num == num;
    }
}
