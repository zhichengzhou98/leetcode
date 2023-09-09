package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description 1009. 十进制整数的反码
 * @create 2023-07-17 15:12
 */
public class BitwiseComplement {
    public static void main(String[] args) {
        //System.out.println((1<<31) - 1);
        System.out.println(bitwiseComplement(0));
    }
    public static int bitwiseComplement(int n) {
        for (int i = 31; i >= 0; i--) {
            if (n > (1 << i) - 1) {
                return (1 << (i + 1)) - 1 - n;
            }
        }
        return 1;
    }
}
