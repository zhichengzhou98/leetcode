package com.zzc.leetcode_aug;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description 1475. 商品折扣后的最终价格
 * @create 2023-08-20 20:36
 */
public class FinalPrices {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
    }

    //使用单调递减栈
    public static int[] finalPrices(int[] prices) {
        int[] discount = new int[prices.length];
        //记录数组中元素的值
        Stack<Integer> stack = new Stack<>();
        //记录数组中元素的下标
        Stack<Integer> indexStack = new Stack<>();
        stack.push(prices[0]);
        indexStack.push(0);
        for (int i = 1; i < prices.length; i++) {
            //如果栈为非空
            while (stack.size() > 0 && prices[i] <= stack.peek()) {
                //出栈
                stack.pop();
                int index = indexStack.pop();
                discount[index] = prices[i];
            }
            //当前元素入栈
            stack.push(prices[i]);
            indexStack.push(i);
        }
        for (int i = 0; i < discount.length; i++) {
            prices[i] = prices[i] - discount[i];
        }
        return prices;
    }

    /*public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            prices[i] = prices[i] - discount;
        }
        return prices;
    }*/
}

