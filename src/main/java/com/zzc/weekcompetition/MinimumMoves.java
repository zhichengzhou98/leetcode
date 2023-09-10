package com.zzc.weekcompetition;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 10:44
 */
public class MinimumMoves {
    public static void main(String[] args) {
        //int[][] grid = new int[][]{{3,2,0},{0,1,0},{0,3,0}};
        int[][] grid = new int[][]{{1,2,2},{1,1,0},{0,1,1}};
        System.out.println(minimumMoves(grid));
    }
     static int count;
    
    static int count1;
    public static int minimumMoves(int[][] grid) {
        count = 0;
        count1 = 0;
        List<int[]> pos = new ArrayList<>();
        List<int[]> zero = new ArrayList<>();
        List<int[]> list = new ArrayList();
        List<int[]> pos1 = new ArrayList<>();
        int[][] ints = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ints[i][j] = grid[i][j];
                if (grid[i][j] > 1) {
                    pos.add(new int[] {i, j, grid[i][j]});
                    pos1.add(new int[] {i, j, grid[i][j]});
                }else if (grid[i][j] == 0) {
                    zero.add(new int[] {i, j});
                    list.add(new int[] {i, j});
                }
            }

        }
        Collections.reverse(list);

        for (int i = 0; i < pos.size(); i++) {
            int[] current = pos.get(i);
            while (true) {
                if (current[2] == 1) {
                    break;
                }
                int[] arr = {0,0};
                int minLen = 100000;
                for (int j = 0; j < zero.size(); j++) {
                    int[] temp = zero.get(j);
                    if (grid[temp[0]][temp[1]] == 1) {
                        continue;
                    }
                    int min = Math.abs(temp[0] - current[0]) + Math.abs(temp[1] - current[1]);
                    if (min <= minLen) {
                        minLen = min;
                        arr = temp;
                    }
                }
                grid[arr[0]][arr[1]] = 1;
                count = count + minLen;
                current[2]--;
                grid[current[0]][current[1]]--;
            }
        }

        for (int i = 0; i < pos1.size(); i++) {
            int[] current = pos1.get(i);
            while (true) {
                if (current[2] == 1) {
                    break;
                }
                int[] arr = {0,0};
                int minLen = 100000;
                for (int j = 0; j < list.size(); j++) {
                    int[] temp = list.get(j);
                    if (ints[temp[0]][temp[1]] == 1) {
                        continue;
                    }
                    int min = Math.abs(temp[0] - current[0]) + Math.abs(temp[1] - current[1]);
                    if (min <= minLen) {
                        minLen = min;
                        arr = temp;
                    }
                }
                ints[arr[0]][arr[1]] = 1;
                count1 = count1 + minLen;
                current[2]--;
                ints[current[0]][current[1]]--;
            }
        }
        
        return Math.min(count,count1);
    }


    public static boolean checkIndex(int[] index) {
        if (index[0] >= 0 && index[0] < 3 && index[1] >= 0 && index[1] < 3) {
            return true;
        }
        return false;
    }
}
