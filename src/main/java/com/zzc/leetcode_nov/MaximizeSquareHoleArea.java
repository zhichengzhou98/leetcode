package com.zzc.leetcode_nov;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 100138. 最大化网格图中正方形空洞的面积
 * @create 2023-11-26 18:51
 */
public class MaximizeSquareHoleArea {
    public static void main(String[] args) {

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int min = Math.min(maxLen(hBars), maxLen(vBars));
        return min * min;
    }

    @Test
    public void test() {
        System.out.println(maxLen(new int[]{2, 3}));
    }

    public int maxLen(int[] bars) {
        //统计bars中值连续的个数
        Arrays.sort(bars);
        int res = 1;
        int l = 1;
        while (l < bars.length) {
            int curr = 1;
            while (l < bars.length && bars[l] == bars[l - 1] + 1) {
                l++;
                curr++;
            }
            res = Math.max(res, curr);
            while (l < bars.length && bars[l] != bars[l - 1] + 1) {
                l++;
            }
        }
        return res + 1;
    }
}
