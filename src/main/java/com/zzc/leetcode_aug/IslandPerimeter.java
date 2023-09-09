package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description 对于一个陆地格子的每条边，它被算作岛屿的周长当且仅当这条边为网格的边界或者相邻的另一个格子为水域。
 * @create 2023-08-26 17:37
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter i = new IslandPerimeter();
        System.out.println(i.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1} , {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int side = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < dir.length; k++) {
                        int[] newPos = new int[]{i + dir[k][0], j + dir[k][1]};
                        if (newPos[0] < 0 || newPos[0] >= grid.length ||
                                newPos[1] < 0 || newPos[1] >= grid[i].length || grid[newPos[0]][newPos[1]] == 0) {
                            cnt++;
                        }
                    }
                    side += cnt;
                }
            }
        }
        return side;
    }

}
