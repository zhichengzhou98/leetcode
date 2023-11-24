package com.zzc.leetcode_nov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-22 12:21
 */
public class MinPathCost {
    Map<Integer, Integer> map;
    int[][] moveCost;
    int[][] grid;
    int m;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        map = new HashMap<>();
        this.moveCost = moveCost;
        this.grid = grid;
        //行数
        int m = grid.length;
        this.m = m;
        //列数
        int n = grid[0].length;
        //起始位置
        int[] begin = grid[0];
        //终点位置
        int[] end = grid[m-1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < begin.length; i++) {
            res = Math.min(dfs(begin[i], 0), res);
        }
        return res;
    }

    public int dfs(int pre, int line) {
        if (map.containsKey(pre)) {
            return map.get(pre);
        }
        //line 为当前列
        int res = pre;
        if (line == m-1) {
            return res;
        }
        // 下一列的值
        int[] next = grid[line + 1];
        //移动到下一列的代价
        int[] nextCost = moveCost[pre];
        int temp = pre;
        res = Integer.MAX_VALUE;
        for (int i = 0; i < next.length; i++) {
            res = Math.min(dfs(next[i], line + 1) + nextCost[i], res);
        }
        map.put(pre, res + temp);
        return res + temp;
    }

    public int dfs2(int[][] moveCost, int pre, int line, int path, int m, int[][] grid) {
        if (map.containsKey(pre)) {
            return map.get(pre);
        }
        path = pre + path;
        //line 为当前列
        if (line == m-1) {
            return path;
        }
        // 下一列的值
        int[] next = grid[line + 1];
        //移动到下一列的代价
        int[] nextCost = moveCost[pre];
        int temp = path;
        path = Integer.MAX_VALUE;
        for (int i = 0; i < next.length; i++) {
            path = Math.min(dfs2(moveCost, next[i], line + 1, temp + nextCost[i], m, grid), path);
        }
        map.put(pre, path);
        return path;
    }
}
