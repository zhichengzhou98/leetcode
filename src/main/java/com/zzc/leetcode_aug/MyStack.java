package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-25 22:22
 */
public class MyStack {
    List<Integer> list;
    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        return list.remove(list.size() - 1);
    }

    public int top() {

        return list.get(list.size() - 1);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
