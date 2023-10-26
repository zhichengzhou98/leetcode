package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-26 9:24
 */
public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(121));
    }
    public static int countDigits(int num) {
        int temp = num;
        int res = 0;
        while (num > 0) {
            //每一位的值
            int digit = num % 10;
            if (temp % digit == 0) {
                res++;
            }
            num /= 10;
        }
        return res;
    }
}
