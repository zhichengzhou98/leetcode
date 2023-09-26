package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description 二分查找+回溯
 * @create 2023-09-26 20:29
 */
public class SwimInWater {
    public static void main(String[] args) {
        SwimInWater siw = new SwimInWater();
       /* int[][] grid = {
                {26,99,80,1,89,86,54,90,47,87},
                {9,59,61,49,14,55,77,3,83,79},
                {42,22,15,5,95,38,74,12,92,71},
                {58,40,64,62,24,85,30,6,96,52},
                {10,70,57,19,44,27,98,16,25,65},
                {13,0,76,32,29,45,28,69,53,41},
                {18,8,21,67,46,36,56,50,51,72},
                {39,78,48,63,68,91,34,4,11,31},
                {97,23,60,17,66,37,43,33,84,35},
                {75,88,82,20,7,73,2,94,93,81}};*/
         int[][] grid = {
                 {31,28,33,0,8,57,86,99,23,98},
                 {25,90,20,73,34,65,29,9,42,46},
                 {17,84,10,4,40,5,41,21,71,79},
                 {13,70,69,81,63,93,77,1,94,53},
                 {38,87,61,50,92,2,15,95,82,68},
                 {44,72,88,47,27,91,37,48,83,16},
                 {3,30,96,66,7,58,76,54,19,64},
                 {85,45,60,11,51,26,6,22,74,32},
                 {43,12,62,59,89,52,36,97,49,78},
                 {75,24,14,67,56,35,55,39,80,18}};

         /*int[][] grid = {
                 {11,15,3,2},
                 {6,4,0,13},
                 {5,8,9,10},
                 {1,14,12,7}};*/
        System.out.println(siw.swimInWater(grid));
        //siw.dfs(new int[]{0,0}, 1000, grid);
        //System.out.println(siw.flag);
    }
    public int swimInWater(int[][] grid) {
        int len = grid.length - 1;
        this.len = len;
        int start = grid[0][0];
        int end = grid[len][len];
        end = Math.max(start, end);
        if (len >= 1) {
            int end1 = Math.min(grid[len][len - 1],grid[len - 1][len]);
            end = Math.max(end1,end);
        }
        int n = grid.length;
        int l = Math.max(2 * n - 2, end);
        int r = n * n - 1;
        //查找左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, grid)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }
    int len;
    boolean flag;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean checkMed(int med, int[][] grid) {
        if (med < grid[0][0]) {
            return false;
        }
        flag = false;
        boolean[][] isVisited = new boolean[len + 1][len + 1];
        dfs(new int[]{0,0}, med, grid, isVisited);
        return flag;
    }

    public boolean checkPos(int x, int y) {
        if (x >=0 && x <= len && y >= 0 && y <= len) {
            return true;
        }
        return false;
    }

    public void dfs(int[] current, int med, int[][] grid, boolean[][] isVisited) {
        int x = current[0];
        int y = current[1];
        if (x == grid.length - 1 && y == grid.length - 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (checkPos(nextX, nextY) && med >= grid[nextX][nextY] && !isVisited[nextX][nextY]) {
                //记录当前位置来过
                isVisited[nextX][nextY]= true;
                dfs(new int[]{nextX, nextY}, med, grid, isVisited);
                if (flag) {
                    return;
                }
            }
        }
    }
    //深度优先
    /*public void dfs(int[] current, int med, int[][] grid) {
        int x = current[0];
        int y = current[1];
        if (x == grid.length - 1 && y == grid.length - 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (checkPos(nextX, nextY) && med >= grid[nextX][nextY] && grid[nextX][nextY] >=0) {
                int temp = grid[x][y];
                //记录当前位置来过
                grid[x][y] = -1;
                dfs(new int[]{nextX, nextY}, med, grid);
                //恢复现场
                grid[x][y] = temp;
                if (flag) {
                    return;
                }
            }
        }
    }*/


    //深度优先
    /*public void dfs(int[] current, int med, int[][] grid) {
        int x = current[0];
        int y = current[1];
        if (x == grid.length - 1 && y == grid.length - 1) {
            flag = true;
            return;
        }
        //向下递归
        if (x < grid.length - 1 && med >= grid[x + 1][y] && grid[x + 1][y] >= 0) {
            int temp = grid[x][y];
            //记录当前位置来过
            grid[x][y] = -1;
            dfs(new int[]{x  + 1, y}, med, grid);
            //恢复现场
            grid[x][y] = temp;
            if (flag) {
                return;
            }
        }
        //向右递归
        if (y < grid.length - 1 && med >= grid[x][y + 1] && grid[x][y + 1] >= 0) {
            int temp = grid[x][y];
            //记录当前位置来过
            grid[x][y] = -1;
            dfs(new int[]{x, y + 1}, med, grid);
            //恢复现场
            grid[x][y] = temp;
            if (flag) {
                return;
            }
        }
        //向左递归
        if (y >= 1 && med >= grid[x][y - 1] && grid[x][y-1] >= 0) {
            int temp = grid[x][y];
            //记录当前位置来过
            grid[x][y] = -1;
            dfs(new int[]{x, y-1}, med, grid);
            //恢复现场
            grid[x][y] = temp;
            if (flag) {
                return;
            }
        }
        //向上递归
        if (x >= 1 && med >= grid[x - 1][y] && grid[x-1][y] >= 0) {
            int temp = grid[x][y];
            //记录当前位置来过
            grid[x][y] = -1;
            dfs(new int[]{x-1, y}, med, grid);
            //恢复现场
            grid[x][y] = temp;
            if (flag) {
                return;
            }
        }
    }*/
}
