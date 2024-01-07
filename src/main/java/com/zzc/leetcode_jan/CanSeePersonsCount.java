package com.zzc.leetcode_jan;

import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-05 12:01
 */
public class CanSeePersonsCount {
    public int[] canSeePersonsCount(int[] heights) {
        //单调递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int curHigh = heights[i];
            int cnts = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() < curHigh) {
                    stack.pop();
                    cnts++;
                }else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                cnts++;
            }
            stack.push(curHigh);
            heights[i] = cnts;
        }
        return heights;
    }
}
