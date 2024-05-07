package com.zzc.leetcode_may;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-07 11:08
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{30,60,90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0 ; i--) {

            while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            }else{
                res[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
