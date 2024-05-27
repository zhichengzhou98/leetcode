package com.zzc.leetcode_mar;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-16 15:47
 */
public class MaxMoves {

    public int maxMoves(int[][] grid) {
        int rowMax = grid.length;
        int colMax = grid[0].length;
        int[][] res = new int[grid.length][grid[0].length];

        int max = Integer.MIN_VALUE;
        for (int i = colMax - 2; i >= 0; i--) {
            for (int j = 0; j <= rowMax - 1; j++) {
                int current = grid[j][i];
                if (j - 1 >= 0 && grid[j - 1][i + 1] > current) {
                    res[j][i] = Math.max(res[j][i], 1 + res[j - 1][i + 1]);
                }

                if (j + 1 < rowMax && grid[j + 1][i + 1] > current) {
                    res[j][i] = Math.max(res[j][i], 1 + res[j + 1][i + 1]);
                }

                if (grid[j][i + 1] > current) {
                    res[j][i] = Math.max(res[j][i], 1 + res[j][i + 1]);
                }
                if (i == 0) {
                    max = Math.max(max, res[j][i]);
                }
            }
        }
        return max;
    }

}
