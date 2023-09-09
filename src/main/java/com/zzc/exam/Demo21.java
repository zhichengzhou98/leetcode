package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-28 20:51
 */
public class Demo21 {
    public static void main(String[] args) {
        System.out.println(2 >> 1);
        System.out.println(findComplement(3));
    }

    public static int findComplement(int num) {
        int num1 = num;
        int bitCount = 0;
        while (num > 0) {
            num  = num >> 1;
            bitCount++;
        }

        return (Integer.MAX_VALUE - num1)<<(32 - bitCount)>>(32 - bitCount);
    }
}
