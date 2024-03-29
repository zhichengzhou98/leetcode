package com.zzc.leetcode_oct;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-27 12:08
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea mA = new MaxArea();
        System.out.println(mA.maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        System.out.println(mA.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    @Test
    public void testMaxArea() {
        System.out.println(Long.MAX_VALUE);
        System.out.println((long) MOD * MOD);
        System.out.println(maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    private static int MOD = (int) (Math.pow(10, 9) + 7);
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long area = ((long) maxDiff(h, horizontalCuts) * maxDiff(w, verticalCuts)) % MOD;
        return (int) area;
    }

    public int maxDiff(int h, int[] horizontalCuts) {
        Arrays.sort(horizontalCuts);
        int maxDiffH = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxDiffH = Math.max(maxDiffH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxDiffH = Math.max(h - horizontalCuts[horizontalCuts.length - 1], maxDiffH);
        return maxDiffH;
    }
}
