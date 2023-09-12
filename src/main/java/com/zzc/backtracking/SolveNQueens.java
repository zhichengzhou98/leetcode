package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 17:43
 */
public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens sq = new SolveNQueens();
        System.out.println(sq.solveNQueens(4));
    }
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        if (n == 2 || n == 3) {
            return new ArrayList<List<String>>();
        }
        //2 表示Q, 1 表示无法继续放， 0 表示可以放
        int[][] grid = new int[n][n];
        res = new ArrayList<>();
        dfs(grid, 0);
        return res;
    }

    //i 表示该在第 i 行放置旗子, i [0, n - 1]
    public void dfs(int[][] grid, int i) {
        if (i >= grid.length) {
            //放完了
            formatGrid(grid);
            return;
        }
        //第 i 行数组
        int[] lineI = grid[i];
        for (int j = 0; j < lineI.length; j++) {
            if (lineI[j] == 1) {
                //无法放置
                continue;
            }
            //可以放置
            lineI[j] = 2;
            //刷新grid, 把 不能放的位置变成1
            int[][] copy = refreshGrid(grid, i, j);
            //向第i + 1 行递归
            dfs(copy, i + 1);
            //回溯 把当前位置置为0
            lineI[j] = 0;
        }
        //没有位置可以放
    }

    //要重新成一个新的grid，才能不影响下次回溯
    //在(i, j)位置新加一个Q
    public int[][] refreshGrid(int[][] grid, int i, int j) {
        int[][] copy = Arrays.stream(grid)
                .map(int[]::clone)
                .toArray(int[][]::new);
        for (int k = i + 1; k < grid.length; k++) {
            for (int l = 0; l < grid[i].length; l++) {
                if (l == j) {
                    copy[k][l] = 1;
                }
                if (Math.abs(i - k) == Math.abs(j - l)) {
                    copy[k][l] = 1;
                }
            }
        }
        return copy;
    }

    public void formatGrid(int[][] grid) {
        List<String> partRes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int[] line = grid[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 0 || line[j] == 1) {
                    sb.append(".");
                }else {
                    sb.append("Q");
                }
            }
            partRes.add(sb.toString());
        }
        res.add(partRes);
    }
}
