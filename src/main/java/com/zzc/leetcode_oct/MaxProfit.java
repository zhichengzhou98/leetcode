package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-01 8:13
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res[i] = Math.max(res[i - 1], prices[i] > minPrice ? prices[i] - minPrice : 0);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return res[res.length - 1];
    }
}
