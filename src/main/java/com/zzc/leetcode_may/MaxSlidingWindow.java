package com.zzc.leetcode_may;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-14 18:36
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> -x));
        for (int i = 0; i < k; i++) {

        }
        return null;
    }
}
