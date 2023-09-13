package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-13 12:02
 */
public class CheckValidGrid {

    public static void main(String[] args) {
        CheckValidGrid checkValidGrid = new CheckValidGrid();
        int[][] grid = {{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}};
        System.out.println(checkValidGrid.checkValidGrid(grid));
    }
    public boolean checkValidGrid(int[][] grid) {
        Set<String> set = new HashSet<>();
        int[][] pos = new int[grid.length * grid.length][];
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!set.isEmpty() && set.contains(i+String.valueOf(j))) {
                    return false;
                }
                set.add(i+String.valueOf(j));
                int[] node = {grid[i][j], i, j};
                pos[k] = node;
                k++;
            }
        }

        Arrays.sort(pos, (a, b)->a[0] - b[0]);
        int[] first = pos[0];
        if (first[1] != 0 || first[2] != 0) {
            return false;
        }
        for (int i = 1; i < pos.length; i++) {
            int[] after = pos[i];
            int[] before = pos[i- 1];
            if (after[0] - before[0] == 1) {
                int deltX = Math.abs(after[1] - before[1]);
                int deltY = Math.abs(after[2] - before[2]);
                if (!(deltY == 2 && deltX == 1) && !(deltY == 1 && deltX == 2)) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
