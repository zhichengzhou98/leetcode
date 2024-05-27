package com.zzc.leetcode_may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-14 18:44
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> lines = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    lines.add(j);
                }
            }
        }
        for(int i : rows) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j : lines) {
                matrix[i][j] = 0;
            }
        }
    }
}
