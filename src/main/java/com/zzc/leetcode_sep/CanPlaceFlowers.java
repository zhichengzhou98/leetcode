package com.zzc.leetcode_sep;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-29 13:49
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] f = {1, 0, 0};
        System.out.println(canPlaceFlowers(f, 1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] res = new int[flowerbed.length + 2];
        res[0] = 0;
        res[res.length - 1] = 0;
        for (int i = 1; i < res.length - 1; i++) {
            res[i] = flowerbed[i-1];
        }
        flowerbed = res;
//求连续 0 的个数
        //连续两个0   无法种花  -->  0
        //连续3个0   --> 1
        //4  --> 1
        //连续奇数个0  --> count / 2; 偶数个 count / 2 - 1; 求和 与 n 比较
        int count = 0;
        int left = 0;
        int right = 0;
        int length = flowerbed.length;
        while (right < length && left < length){
            while (left < length && flowerbed[left] == 1){
                left++;
            }
            right = left;
            while (right < length && flowerbed[right] == 0){
                right++;
            }
            int temp = right - left;
            if (temp % 2 == 0 && temp != 0) {
                count = count + (temp / 2) - 1;
            }else {
                count = count + temp / 2;
            }
            left = right;
        }

        return count >= n;
    }
}
