package com.zzc.leetcode_nov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-28 12:06
 */
public class FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue fMBQ = new FrontMiddleBackQueue();
        fMBQ.pushFront(1);
        fMBQ.pushBack(2);
        fMBQ.pushMiddle(3);
        fMBQ.pushMiddle(4);
        fMBQ.popFront();
        fMBQ.popMiddle();
        fMBQ.popMiddle();
        fMBQ.popBack();

    }

    List<Integer> list;
    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add((list.size())/2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(0);
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove((list.size()-1)/2);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size()-1);
    }
}
