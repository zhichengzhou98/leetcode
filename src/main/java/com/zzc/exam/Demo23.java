package com.zzc.exam;

/**
 * @author zzc
 * @Description 29a + 20b + 31c = 366
 * @create 2023-05-28 18:26
 */
public class Demo23 {
    public static void main(String[] args) {
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 12; j++) {
                for (int k = 0; k <= 12; k++) {
                    if (29 * i + 30 * j + 31 * k == 366) {
                        System.out.println("a=" + i + ",b=" + j + ",c=" + k);
                    }
                }
            }
        }
    }
}
