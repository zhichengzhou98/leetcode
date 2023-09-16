package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description 单调栈
 * @create 2023-09-16 20:42
 */
public class StockSpanner {
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        ss.next(32);
        ss.next(82);
        ss.next(73);
        ss.next(99);
        ss.next(91);
    }

    List<Integer> prices;
    List<Integer> days;
    Stack<int[]> stack;
    public StockSpanner() {
        prices = new ArrayList<>();
        days = new ArrayList<>();
        stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, - 1});
    }

    public int next(int price) {
        int day = 1;
        while (!stack.isEmpty()) {
            int[] peek = stack.peek();
            if (price >= peek[0]) {
                day = day + peek[1];
                stack.pop();
            }else {
                stack.push(new int[]{price, day});
                break;
            }
        }
        return day;
    }

    /*public int next(int price) {
        int max = 1;
        prices.add(price);
        if (prices.size() > 1) {
            int i = prices.size() - 1;
            int cnt = 0;
            while (i >= 0 && prices.get(i) <= price) {
                cnt++;
                i--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }*/

    /*public int next(int price) {
        prices.add(price);
        if (prices.size() == 1) {
            days.add(1);
        }else {
            int before = prices.get(prices.size() - 2);
            if (price >= before) {
                days.add(days.get(days.size() - 1) + 1);
            }else {
                days.add(1);
            }
        }
        return days.get(days.size() - 1);
    }*/
}
