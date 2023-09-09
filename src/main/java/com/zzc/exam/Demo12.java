package com.zzc.exam;

import java.util.HashSet;

/**
 * @author zzc
 * @Description
 * @create 2023-03-12 23:08
 */
public class Demo12 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

   /* public static boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }*/
   public static boolean isPerfectSquare(int num) {
       HashSet<Integer> set = new HashSet<>();
       for (int i = 0; i < Integer.MAX_VALUE / i; i++) {
           set.add(i * i);
       }
       return set.contains(num);
   }

}
