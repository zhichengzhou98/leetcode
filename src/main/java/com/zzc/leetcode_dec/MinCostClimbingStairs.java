package com.zzc.leetcode_dec;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-17 11:46
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int[][] res = new int[cost.length][2];
        res[0][0] = 0;
        res[0][1] = cost[0];
        res[1][0] = res[0][1];
        res[1][1] = cost[1] + Math.min(res[0][0], res[0][1]);
        for (int i = 2; i < cost.length; i++) {
            res[i][0] = res[i-1][1];
            res[i][1] = cost[i] + Math.min(res[i-1][1],res[i-1][0]);
        }
        return Math.min(res[cost.length-1][0], res[cost.length-1][1]);
    }
}
