package com.zzc.exam;



/**
 * @author zzc
 * @Description
 * @create 2023-03-19 14:37
 */
public class Demo17 {
    public static void main(String[] args) {
      /*  System.out.println(arrangeCoins(6));
        System.out.println(arrangeCoins(7));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(9));*/
        System.out.println(arrangeCoins(1804289383));
        //Utils.printHelloWorld();
    }
    public static int arrangeCoins(int n) {
        long res = (long) Math.floor(Math.sqrt((long)2 * n));
        if ( (long)2 * n >= res * (res + 1)) {
            return (int) res;
        }

        return (int)res - 1;
    }
    /*public static int arrangeCoins(int n) {
        int res = -1;
        int i = 1;
        while ( n >= 0 ) {
            res++;
            n = n - i;
            i++;
        }
        return res;
    }*/
}
