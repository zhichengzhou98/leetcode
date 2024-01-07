package com.zzc.leetcode_dec;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-23 12:04
 */
public class MinStoneSum {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> -x));
        for(int num : piles) {
            sum += num;
            pq.offer(num);
        }
        while (!pq.isEmpty() && k > 0) {
            Integer poll = pq.poll();
            if (poll == 1) {
                break;
            }
            int remove = poll / 2;
            sum -= remove;
            pq.offer(poll - remove);
            k--;
        }
        return sum;
    }
}
