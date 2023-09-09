package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description 1351. 统计有序矩阵中的负数
 * @create 2023-07-31 12:14
 */
public class CountNegatives {
    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {
        int row = grid.length;//行
        int column = grid[0].length;//列
        //从左下角开始遍历
        int j = 0;
        int i = row - 1;
        int count = 0;
        while (i >=0 && j < column) {
            if(grid[i][j] < 0) {
                count = count + column - j;
                i--;
            }else {
                j++;
            }
        }
        return count;
    }
}
