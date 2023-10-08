package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-08 10:30
 */
public class DifferenceOfSums {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
    }
    public static int differenceOfSums(int n, int m) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n ; i++) {
            if (i % m == 0) {
                sum1+=i;
            }else {
                sum2+=i;
            }
        }
        return sum2 - sum1;
    }
}
