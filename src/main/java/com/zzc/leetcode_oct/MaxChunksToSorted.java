package com.zzc.leetcode_oct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description TODO: 768
 * @create 2023-10-12 22:07
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        //大顶堆
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x->-x));
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (!pq.isEmpty() && pq.peek() == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxChunksToSorted mCTS = new MaxChunksToSorted();
        System.out.println(mCTS.maxChunksToSorted1(new int[]{1, 1, 0, 0, 1}));
    }

    public int maxChunksToSorted1(int[] arr) {
        int res = 0;
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (max == copy[i] && min == copy[0]) {
                res++;
            }
        }
        return res;
    }
}
