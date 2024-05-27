package com.zzc.leetcode_may;

import java.util.ArrayDeque;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-14 18:36
 */
public class MaxSlidingWindow {

    @Test
    public void test() {
        int[] nums = new int[]{9, 100, 2, 3, 4, 7, 8, 9};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        //双端队列
        //0: value, 1: index in nums.
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            //往对列中末尾加入元素，保证元素递减
            while (!deque.isEmpty() && deque.peekLast()[0] < current) {
                deque.pollLast();
            }
            //检查首位元素是否不在窗口中
            while (!deque.isEmpty() && deque.peekFirst()[1] <= i - k) {
                deque.pollFirst();
            }
            //往队列中加入元素
            deque.offerLast(new int[]{current, i});

            //更新结果
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst()[0];
            }
        }
        return res;
    }
}
