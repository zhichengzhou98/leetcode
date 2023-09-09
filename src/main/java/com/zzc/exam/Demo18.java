package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-20 21:37
 */
public class Demo18 {
    public static void main(String[] args) {
        Demo18 demo18 = new Demo18();
        System.out.println(demo18.hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int s = 0;
        while (res >= 1) {
            if (res % 2 == 1){
                s++;
            }
            res /= 2;
        }
        return s;
    }
}
