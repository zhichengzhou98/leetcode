package com.zzc.leetcode_nov;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-29 12:17
 */
public class SmallestInfiniteSet {
    Set<Integer> removedSet;
    int max;
    public SmallestInfiniteSet() {
        removedSet = new HashSet<>();
        max = Integer.MIN_VALUE;
    }

    public int popSmallest() {
        if (removedSet.isEmpty()) {
            removedSet.add(1);
            max = Math.max(max, 1);
            return 1;
        }
        int removeNum = 0;
        for (int i = 1; i < max + 2; i++) {
            if (!removedSet.contains(i)) {
                removeNum = i;
                break;
            }
        }
        removedSet.add(removeNum);
        max = Math.max(max, removeNum);
        return removeNum;
    }

    public void addBack(int num) {
        removedSet.remove(num);
    }
}
