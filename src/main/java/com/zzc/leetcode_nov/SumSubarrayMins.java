package com.zzc.leetcode_nov;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-27 12:11
 */
public class SumSubarrayMins {

    @Test
    public void test() {
        System.out.println(sumSubarrayMins(new int[]{3, 1}));
    }

    private static int MOD = (int) (Math.pow(10, 9) + 7);

    public int sumSubarrayMins(int[] arr) {
        long[] res = new long[arr.length];
        //单调递增栈 int[2]: 0:元素值， 1:出现的次数
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{arr[0], 1});
        //栈中所有的数之和
        int sumOfStack = arr[0];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            //current需要入栈，判断栈顶元素与current的大小
            //弹出元素的个数
            int cnts = 1;
            //记录弹出元素的和
            while (!stack.isEmpty() && current < stack.peek()[0]) {
                int[] pop = stack.pop();
                int value = pop[0];
                int count = pop[1];
                sumOfStack = sumOfStack - (int) ((long)value * count % MOD) % MOD;
                cnts = cnts + count;
            }
            //需要将cnt个current入栈
            stack.push(new int[]{current, cnts});
            sumOfStack = (int)(sumOfStack + (long)(current) * cnts % MOD) % MOD;
            res[i] = (res[i - 1] + sumOfStack) % MOD;
        }
        return ((int) res[res.length - 1] + MOD) % MOD;
    }
    public int sumSubarrayMinsV2(int[] arr) {
        long[] res = new long[arr.length];
        //单调递增栈 int[2]: 0:元素值， 1:出现的次数
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{arr[0], 1});
        //栈中所有的数之和
        int sumOfStack = arr[0];
        res[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            //current需要入栈，判断栈顶元素与current的大小
            //弹出元素的个数
            int cnts = 1;
            //记录弹出元素的和
            int sumOfPop = 0;
            while (!stack.isEmpty() && current < stack.peek()[0]) {
                int[] pop = stack.pop();
                int value = pop[0];
                int count = pop[1];
                sumOfPop = (int) (sumOfPop + (long)value * count % MOD) % MOD;
                cnts = cnts + count;
            }
            sumOfStack -= sumOfPop;
            //需要将cnt个current入栈
            stack.push(new int[]{current, cnts});
            sumOfStack = (int)(sumOfStack + (long)(current) * cnts % MOD) % MOD;
            res[i] = (res[i - 1] + sumOfStack) % MOD;
        }
        return (int) res[res.length - 1];
    }
    public int sumSubarrayMinsV1(int[] arr) {
        long[] res = new long[arr.length];
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        //栈中所有的数之和
        int sumOfStack = arr[0];
        res[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            //current需要入栈，判断栈顶元素与current的大小
            //弹出元素的个数
            int cnts = 1;
            //记录弹出元素的和
            int sumOfPop = 0;
            while (!stack.isEmpty() && current < stack.peek()) {
                sumOfPop = (sumOfPop + stack.pop()) % MOD;
                cnts++;
            }
            sumOfStack -= sumOfPop;
            //需要将cnt个current入栈
            while (cnts > 0) {
                stack.push(current);
                cnts--;
                sumOfStack = (sumOfStack + current) % MOD;
            }
            res[i] = (res[i - 1] + sumOfStack) % MOD;
        }
        return (int) res[res.length - 1];
    }
    /*private static int MOD = (int) (Math.pow(10, 9) + 7);
     public int sumSubarrayMins(int[] arr) {
        long[] res = new long[arr.length];
        long[] min = new long[arr.length];
        res[0] = arr[0];
        min[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min[i] = Math.min(min[i-1], arr[i]);
            res[i] = (res[i-1] + ((i) * min[i-1]) % MOD + arr[i])%MOD;
        }
        return (int) res[res.length-1];
    }*/
   /* public int sumSubarrayMins(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                res = (res+ min) % MOD;
            }
        }
        return res;
    }*/
}
