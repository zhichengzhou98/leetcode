package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-02 18:24
 */
public class CarPooling {
    @Test
    public void test() {
        int[][] trips = {{2,1,5},{3,5,7}};
        System.out.println(carPooling(trips, 3));
    }
    public boolean carPooling(int[][] trips, int capacity) {
        //差分数组
        int[] diff = new int[1001];
        for(int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];
            diff[from] += num;
            diff[to] -= num;
        }
        if (diff[0] > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
            if (diff[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
