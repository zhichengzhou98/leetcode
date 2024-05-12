package com.zzc.leetcode_may;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-12 12:47
 */
public class Trap {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] res = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(res));
    }

    public int trap(int[] height) {
        int[] left = new int[height.length];
        //i位置左边最大的高度
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        //i位置右边最大的高度
        int[] right = new int[height.length];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //i位置接到的水取决于i左边和右边的最小高度，在此基础上再减去i位置的高度
            res += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return res;
    }
}
