package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-21 21:33
 */
public class Demo20 {
    public static void main(String[] args) {

    }
    public int islandPerimeter(int[][] grid) {
        //TODO
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area++;
                }
            }
        }
        return area == 0 ? 0 : 2 * area + 2;
    }
}
