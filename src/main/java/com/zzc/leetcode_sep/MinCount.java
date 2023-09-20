package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-20 9:28
 */
public class MinCount {
    public static void main(String[] args) {

    }

    public int minCount(int[] coins) {
        int cnt = 0;
        for (int i = 0; i < coins.length; i++) {
            cnt += (coins[i] + 2 - 1) / 2;
        }
        return cnt;
    }
}
