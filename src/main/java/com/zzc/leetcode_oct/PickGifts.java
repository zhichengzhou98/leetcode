package com.zzc.leetcode_oct;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-28 8:42
 */
public class PickGifts {
    public static void main(String[] args) {

    }

    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        long sum = 0;
        for (int i : gifts) {
            sum += i;
            pq.add(i);
        }
        while (k > 0) {
            Integer poll = pq.poll();
            if (poll == 1) {
                return sum;
            }
            int left = (int) Math.sqrt(poll);
            pq.add(left);
            sum = sum - (poll - left);
            k--;
        }
        return sum;
    }
}
