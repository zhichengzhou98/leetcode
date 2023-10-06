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

    //714. 买卖股票的最佳时机含手续费
    public int maxProfit(int[] prices, int fee) {
        //持有股票
        int h = -prices[0];

        //不持有股票
        int uH = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = uH;
            uH = Math.max(h + prices[i] - fee, uH);
            h = Math.max(h, temp - prices[i]);
        }
        return uH;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit1(arr));
    }

    //121. 买卖股票的最佳时机
    public static int maxProfit1(int[] prices) {
        int fee = 0;
        //k次交易
        int k = 2;
        //买一次股票算一次交易
        // i j k : 第i天， 持有/不持有， 第k次交易（索引从0开始）
        //持有股票
        int[][] h = new int[prices.length][k + 1];
        h[0][1] = -prices[0];
        h[0][0] = Integer.MIN_VALUE;//第一天持有股票但是没发生交易
        //不持有股票
        int[][] uH = new int[prices.length][k + 1];
        uH[0][0] = 0;
        uH[0][1] = Integer.MIN_VALUE;//第一天未持有股票，但是发生了交易
        for (int i = 1; i < h.length; i++) {
            h[i][0] = Integer.MIN_VALUE;
            h[i][1] = -prices[i];
            uH[i][0] = 0;
            uH[i][1] = Integer.MIN_VALUE;
            for (int j = 1; j < h[i].length; j++) {
                if (j > i) {
                    h[i][j] = Integer.MIN_VALUE;
                    uH[i][j] = Integer.MIN_VALUE;
                    break;
                }
                h[i][j] = Math.max(h[i - 1][j], uH[i  -1][j-1] - prices[i]);
                uH[i][j] = Math.max(uH[i - 1][j], h[i][j] + prices[i] - fee);
            }
        }
        int res = 0;

        for (int i = 0; i < uH[prices.length- 1].length ; i++) {
            res = Math.max(res, uH[prices.length - 1][i]);
        }
        return res;
    }
}
