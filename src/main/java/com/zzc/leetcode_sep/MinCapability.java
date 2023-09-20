package com.zzc.leetcode_sep;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-19 17:52
 */
public class MinCapability {
    public static void main(String[] args) {
        int[] arr = {9,6,20,21,8};
        MinCapability mC = new MinCapability();
        System.out.println(mC.minCapability(arr, 3));
    }

    //二分答案
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = (int)Math.pow(10, 9) + 1;
        //查找左边界
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(med, k, nums)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }

    public boolean checkMed(int med, int k, int[] nums) {
        int counts = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] <= med) {
                counts++;
                if (counts >= k) {
                    return true;
                }
                i += 2;
            }else {
                i++;
            }
        }
        return counts >= k;
    }

    //动态规划， 超时
    /*public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[] preGrid = new int[n];
        for (int i = 0; i < preGrid.length; i++) {
            if (i == 0) {
                preGrid[i] = nums[i];
            }else {
                preGrid[i] = Math.min(preGrid[i - 1], nums[i]);
            }
        }
        //int[] currentGrid = Arrays.copyOf(preGrid, preGrid.length);
        int[] currentGrid = new int[n];
        for (int i = 2; i < k + 1; i++) {
            //i -> k
            for (int j = 0; j < preGrid.length; j++) {
                //j -> n
                if (j >= 2 * i - 2) {
                    //选 nums[n] 和 grid[k - 1][n - 2]
                    int a1 = Math.max(nums[j], preGrid[j - 2]);
                    //不选 nums[n]， grid[k][n-1]
                    int a2 = currentGrid[j - 1];
                    if (j != 2 * i - 2 && a2 > 0) {
                        currentGrid[j] = Math.min(a1, a2);
                    } else {
                        currentGrid[j] = a1;
                    }
                }
            }
            //preGrid = Arrays.copyOf(currentGrid, currentGrid.length);
            int[] temp = currentGrid;
            currentGrid = preGrid;
            preGrid = temp;
        }
        return preGrid[n - 1];
    }*/
    //内存超出
    /*public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[][] grid = new int[k + 1][n];
        for (int i = 0; i < grid[1].length; i++) {
            if (i == 0) {
                grid[1][i] = nums[i];
            }else {
                grid[1][i] = Math.min(grid[1][i - 1], nums[i]);
            }
        }
        for (int i = 2; i < grid.length; i++) {
            //i -> k
            for (int j = 0; j < grid[i].length; j++) {
                //j -> n
                if (j < 2 * i - 2) {
                    grid[i][j] = -1;
                }else {
                    //选 nums[n] 和 grid[k - 1][n - 2]
                    int a1 = Math.max(nums[j], grid[i - 1][j - 2]);
                    //不选 nums[n]， grid[k][n-1]
                    int a2 = grid[i][j - 1];
                    if (a2 > 0) {
                        grid[i][j] = Math.min(a1, a2);
                    }else {
                        grid[i][j] = a1;
                    }
                }
            }
        }
        return grid[k][n - 1];
    }*/
}
