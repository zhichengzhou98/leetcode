package com.zzc.leetcode;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-20 12:08
 */
public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res =  new int[num_people];
        int num = 1;
        int i = 0;
        while (candies > 0) {
            if (candies >= num) {
                res[i] = num + res[i];
                candies = candies - num;
                num++;
                i = (i + 1) % num_people;
            }else {
                res[i] = candies + res[i];
                break;
            }
        }
        return res;
    }
}
