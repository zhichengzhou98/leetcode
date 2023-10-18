package com.zzc.leetcode_oct;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-18 12:15
 */
public class MaxKelements {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x->-x));
        for(int i : nums) {
            pq.offer(i);
        }
        long res = 0L;
        while (!pq.isEmpty() && k > 0) {
            Integer poll = pq.poll();
            if (poll == 0) {
                break;
            }
            res += poll;
            poll = (poll - 1) / 3 + 1;
            pq.offer(poll);
        }
        return res;
    }
}
