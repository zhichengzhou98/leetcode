package com.zzc.leetcode_oct;

import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-23 12:19
 */
public class MinimumSum {
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{8,6,1,5,3}));
    }

    public static int minimumSum(int[] nums) {
        //从前往后遍历
        int[] pre = new int[nums.length];
        //单调递增栈
        Stack<Integer> incStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (!incStack.isEmpty()) {
                if (current > incStack.peek()) {
                    incStack.push(current);
                    //栈底元素
                    pre[i] = incStack.firstElement();
                    break;
                }else {
                    //出栈
                    incStack.pop();
                }
            }
            if (incStack.isEmpty()) {
                incStack.push(current);
                pre[i] = Integer.MAX_VALUE;
            }
        }
        //从后往前遍历
        int[] suf = new int[nums.length];
        //单调递增栈
        incStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            while (!incStack.isEmpty()) {
                if (current > incStack.peek()) {
                    incStack.push(current);
                    //栈底元素
                    suf[i] = incStack.firstElement();
                    break;
                }else {
                    //出栈
                    incStack.pop();
                }
            }
            if (incStack.isEmpty()) {
                incStack.push(current);
                suf[i] = Integer.MAX_VALUE;
            }
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(res, (long) nums[i] + suf[i] + pre[i]);
        }
        if (res >= Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }
}
