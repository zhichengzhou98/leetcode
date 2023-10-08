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

    public static int differenceOfSums1(int n, int m) {
        int k =  n / m;
        int s = ( 1 + n ) * n / 2;

        return s - k * m * (k + 1);
    }
}
