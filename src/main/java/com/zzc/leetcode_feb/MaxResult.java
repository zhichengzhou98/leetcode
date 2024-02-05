package com.zzc.leetcode_feb;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description dp + 滑动窗口的最大值
 * @create 2024-02-05 22:31
 */
public class MaxResult {
    public int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] res = new int[nums.length];

        res[0] = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            res[i] = res[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && res[queue.peekLast()] <= res[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);

        }
        return res[res.length-1];
    }

    public int maxRes(int[] res, int k, int end) {
        int max = res[end];
        while (end >= 0 && k > 0) {
            max = Math.max(max, res[end]);
            k--;
            end--;
        }
        return max;
    }
}
