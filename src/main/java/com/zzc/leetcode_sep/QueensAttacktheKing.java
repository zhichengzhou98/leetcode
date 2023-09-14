package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-14 12:11
 */
public class QueensAttacktheKing {
    public static void main(String[] args) {
        int[][] q = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] k = {0 ,0};
        QueensAttacktheKing qa = new QueensAttacktheKing();
        System.out.println(qa.queensAttacktheKing(q, k));
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] grid = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            int[] pos = queens[i];
            grid[pos[0]][pos[1]]++;
        }
        List<List<Integer>> res = new ArrayList<>();
        int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {0, 1}, {1, 1}, {1, 0}, {-1, 1}, {-1, 0}};
        for (int i = 0; i < dir.length; i++) {
            int[]d = dir[i];
            int step = 1;
            int[] newPos = {king[0] + d[0] * step, king[1] + d[1] * step};
            while (checkPos(newPos)) {
                if (grid[newPos[0]][newPos[1]] > 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(newPos[0]);
                    list.add(newPos[1]);
                    //res.add(Arrays.stream(newPos).boxed().collect(Collectors.toList()));
                    res.add(list);
                    break;
                }
                step++;
                newPos[0] = king[0] + d[0] * step;
                newPos[1] = king[1] + d[1] * step;
            }
        }
        return res;
    }

    public boolean checkPos(int[] pos) {
        if (pos[0] >= 0 && pos[0] < 8 && pos[1] >= 0 && pos[1] < 8) {
            return true;
        }
        return false;
    }
}
