package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-01 8:02
 */
public class WaysToBuyPensPencils {
    public static void main(String[] args) {

    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int maxCost = Math.max(cost1, cost2);
        int minCost = Math.min(cost1, cost2);
        for (int i = 0; i <= total / maxCost ; i++) {
            int leave = total - i * maxCost;
            res = res + leave / minCost+1;
        }
        return res;
    }
}
