package com.zzc.leetcode_dec;

import com.zzc.utils.ArrayUtils;

import java.io.IOException;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-11 21:45
 */
public class MinimumEffortPath {
    public static void main(String[] args) throws IOException {
        MinimumEffortPath mEP = new MinimumEffortPath();
        int[][] h = ArrayUtils.generate("array", int[][].class);
        int x = mEP.minimumEffortPath(h);
        System.out.println(x);
    }

    public static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int minimumEffortPath(int[][] heights) {
        maxY = heights[0].length - 1;
        maxX = heights.length - 1;
        int min = heights[0][0];
        int max = heights[0][0];
        for (int[] arr : heights) {
            for (int i : arr) {
                min = Math.min(i, min);
                max = Math.max(max, i);
            }
        }
        max = max - min;
        return leftBoundary(max, heights);
    }


    public int leftBoundary(int max, int[][] heights){
        int l = 0;
        int r = max;
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, heights)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int target, int[][] heights) {
        this.target = target;
        isVisited = new boolean[maxX + 1][maxY + 1];
        flag = false;
        dfs(new int[]{0,0}, heights);
        return flag;
    }
    boolean[][] isVisited;
    boolean flag;
    int target;
    int maxX;
    int maxY;
    public void dfs(int[] current, int[][] heights) {
        int currentX = current[0];
        int currentY = current[1];
        isVisited[currentX][currentY] = true;
        int currentHigh = heights[currentX][currentY];
        if (currentX == maxX && currentY == maxY) {
            flag = true;
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int[] curDir = dir[i];
            int nextX = currentX + curDir[0];
            int nextY = currentY + curDir[1];
            int[] next = {nextX, nextY};
            if (checkPos(next)) {
                int nextHigh = heights[nextX][nextY];
                if (Math.abs(currentHigh - nextHigh)<= target) {
                    dfs(next, heights);
                    if (flag) {
                        return;
                    }
                }
            }
        }
    }

    public boolean checkPos(int[] next){
        if (next[0] >=0 && next[0]<= maxX && next[1] >=0 && next[1]<= maxY) {
            if (isVisited[next[0]][next[1]]) {
                return false;
            }
            return true;
        }
        return false;
    }
}
