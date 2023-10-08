package com.zzc.leetcode_oct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-07 11:47
 */
public class StockSpanner {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));

    }

    //单调递减栈
    //单调递减栈
    Stack<Integer> s;
    List<Integer> list;
    public StockSpanner() {
        s = new Stack();
        list = new ArrayList<>();
    }
    public int next(int price) {
        while (!s.isEmpty()) {
            //price与栈顶元素比较
            Integer peek = list.get(s.peek());
            if (price >= peek) {
                //出栈
                s.pop();
            } else {
                //入栈
                int res = list.size() - s.peek();
                s.push(list.size());
                list.add(price);
                return res;
            }
        }
        //栈为空
        //将当前元素放入栈中
        s.push(list.size());
        //放入队列
        list.add(price);
        return list.size();
    }
}
