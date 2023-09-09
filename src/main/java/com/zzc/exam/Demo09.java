package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-06 22:02
 */
public class Demo09 {
    public static void main(String[] args) {
        System.out.println(isUgly(25));
    }

    public static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            n /= 2;
            if (n == 1) {
                return true;
            }
            return isUgly(n);
        }
        if (n % 3 == 0) {
            n /= 3;
            if (n == 1) {
                return true;
            }
            return isUgly(n);
        }
        if (n % 5 == 0) {
            n /= 5;
            if (n == 1) {
                return true;
            }
            return isUgly(n);
        }
        return false;
    }
}
