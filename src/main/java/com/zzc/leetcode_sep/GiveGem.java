package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-15 12:00
 */
public class GiveGem {
    public static void main(String[] args) {
        int[][] o = {{0, 2}, {2, 1}, {2, 0}};
        int[] gem = {3, 1, 2};
        System.out.println(giveGem(gem, o));
    }

    public static int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            int x = operations[i][0];
            int y = operations[i][1];
            int delt = gem[x] / 2;
            gem[x] = gem[x] - delt;
            gem[y] = gem[y] + delt;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gem.length; i++) {
            min = Math.min(min, gem[i]);
            max = Math.max(max, gem[i]);
        }
        return max - min;
    }
}
