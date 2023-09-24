package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-24 15:53
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1,1);
        c.put(2,2);
        c.get(1);
        c.put(3,3);
        int i = c.get(2);
        System.out.println(i);
    }

    //value ： 0 值， 1 在list中的位置
    Map<Integer, Integer> map;

    List<Integer> pos;

    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        pos = new ArrayList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            //移动key的位置
            //使用双向链表可以优化移动结点的时间复杂度
            for (int i = 0; i < pos.size(); i++) {
                if (pos.get(i) == key) {
                    pos.remove(i);
                    break;
                }
            }
            //在首位置插入
            pos.add(0, key);
            return value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //跟新value 并移动
            map.put(key, value);
            get(key);
        }else {
            //插入 key value
            if (pos.size() == capacity) {
                //容量占满移除队尾元素
                Integer lastKey = pos.remove(capacity - 1);
                map.remove(lastKey);
            }
            pos.add(0, key);
            map.put(key, value);
        }
    }
}
