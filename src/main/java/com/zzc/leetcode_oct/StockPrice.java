package com.zzc.leetcode_oct;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-08 10:06
 */
public class StockPrice {
    public static void main(String[] args) {
        StockPrice sP = new StockPrice();
        sP.update(1, 10);
        sP.update(2, 5);
        System.out.println(sP.current());
        System.out.println(sP.maximum());
        sP.update(1, 3);
        System.out.println(sP.maximum());

    }
    //key: 时间戳 value: 股票价格
    TreeMap<Integer, Integer> map;

    //key: 股票价格 value: 时间戳
    TreeMap<Integer, Set<Integer>> priceTime;
    public StockPrice() {
        map = new TreeMap<>();
        priceTime = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            //更新股票价格
            //获取原来的价格
            Integer lastPrice = map.get(timestamp);
            Set<Integer> times = priceTime.get(lastPrice);
            //移除timestamp
            times.remove(timestamp);
            if (times.isEmpty()) {
                priceTime.remove(lastPrice);
            }
        }
        Set<Integer> set = priceTime.getOrDefault(price, new HashSet<>());
        set.add(timestamp);
        priceTime.put(price, set);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(map.lastKey());
    }

    public int maximum() {
        return priceTime.lastKey();
    }

    public int minimum() {
        return priceTime.firstKey();
    }
}
