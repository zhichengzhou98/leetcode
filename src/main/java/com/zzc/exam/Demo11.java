package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-08 21:35
 */
public class Demo11 {
    public static void main(String[] args) {

        System.out.println((int)(Math.pow(3,19)));
        System.out.println((4 & 3) == 0);
    }

    public static boolean isPowerOfThree(int n) {
        if( n == 1 ){
            return true;
        }
        if( n <= 0){
            return false;
        }
        return n % 3 == 0 ? isPowerOfThree( n /3) : false;
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0  && n % 3 ==1 && (n & (n-1)) == 0;
    }
}
