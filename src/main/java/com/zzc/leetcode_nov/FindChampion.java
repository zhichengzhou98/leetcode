package com.zzc.leetcode_nov;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-07 21:24
 */
public class FindChampion {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for(int[] arr : edges) {
            set.remove(arr[1]);
        }
        if (set.size() > 1) {
            return -1;
        }
        return set.stream().findFirst().get();
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    set.remove(j);
                }
            }

        }
        if (set.size() > 1) {
            return -1;
        }
        return set.stream().findFirst().get();
    }
}
