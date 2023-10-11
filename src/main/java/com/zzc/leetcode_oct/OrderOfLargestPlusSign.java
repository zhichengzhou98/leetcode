package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description TODO: 764. 最大加号标志 DP
 * @create 2023-10-10 21:13
 */
public class OrderOfLargestPlusSign {
    public static void main(String[] args) {
        OrderOfLargestPlusSign oOLPS = new OrderOfLargestPlusSign();
        System.out.println(oOLPS.orderOfLargestPlusSign(5,new int[][]{{4, 2}}));
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        //理论最大值
        //int maxRes = (n + 1) / 2;

        //创建网格, 默认值为0， 在mines中的点赋值为1， 寻找0
        int[][] grid = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            int[] pos = mines[i];
            grid[pos[0]][pos[1]] = 1;
        }
        //结果大于等于0
        int res = 0;
        //遍历网格grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                if (current == 0) {
                    //至少有一个点满足
                    res = Math.max(res, 1);
                    int maxRes1 = findMaxRes(i, j, n - 1, grid, res);
                    res = Math.max(res, maxRes1);
                }
            }
        }
        return res;
    }

    //以 (x, y)为中心 寻找最大的
    //maxLen = n - 1
    //alreadyRes 已经达到的最大的加号标志
    public int findMaxRes(int x, int y, int maxLen, int[][] grid, int alreadyRes) {
        int maxX = Math.min(maxLen - x + 1, x + 1);
        int maxY = Math.min(maxLen - y + 1, y + 1);
        //理论最大的加号标志
        int max = Math.min(maxX, maxY);
        for (int i = max; i >= alreadyRes + 1; i--) {
            //判断是否满足， 若满足直接放回 i
            if (checkRes(x, y, grid, i)) {
                return i;
            }
        }
        return 0;
    }

    public boolean checkRes(int x, int y, int[][] grid, int i) {
        int minX = x - (i - 1);
        int maxX = x + (i - 1);
        for (int j = minX; j <= maxX; j++) {
            if (grid[j][y] == 1) {
                return false;
            }
        }
        int minY = y - (i - 1);
        int maxY = y + (i - 1);
        for (int j = minY; j <= maxY; j++) {
            if (grid[x][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
