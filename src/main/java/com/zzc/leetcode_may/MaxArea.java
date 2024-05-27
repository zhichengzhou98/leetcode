package com.zzc.leetcode_may;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-08 20:47
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxRes = 0;
        int left = 0;
        int right = height.length - 1;
        while (right >= left) {
            maxRes = Math.max(maxRes, Math.min(height[left], height[right]) * (right - left));
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxRes;
    }
}
