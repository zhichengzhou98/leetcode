package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-29 21:04
 */
public class Reverse {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((Integer.MAX_VALUE - 1) / 10);
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-2147483648));
    }


    public static int reverse(int x) {
        int res = 0;
        while (x > 0) {
            if (res < Integer.MIN_VALUE / 10 || res > (Integer.MAX_VALUE - 1) / 10) {
                return 0;
            }
            int dig = x / 10;
            res = res * 10 + dig;
            x /= 10;
        }


        return res;
    }

   /* public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int posX = Math.abs(x);
        int res = 0;
        while (posX >= 10) {
            int yu = posX % 10;
            if(!check(yu, res)){
                return 0;
            }
            res = res * 10 + yu;
            posX /= 10;
        }
        if(!check(posX, res)){
            return 0;
        }
        res = res * 10 + posX;
        return x > 0 ? (res) : (-res);
    }*/

    public static boolean check(int yu, int res) {
        if (yu == 9 || yu == 8) {
            if (res > 214748363) {
                return false;
            }
            return true;
        }else {
            if (res > 214748364) {
                return false;
            }
            return true;
        }
    }
}
