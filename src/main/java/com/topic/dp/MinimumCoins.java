package com.topic.dp;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2944. 购买水果需要的最少金币数 dp
 * @create 2025-01-24 21:35
 */
public class MinimumCoins {
  @Test
  void testFun() {
    int[] p = {3,1,2};
    System.out.println(minimumCoins(p));
  }
  public int minimumCoins(int[] prices) {
    // cost[i][0] 前i 且不买第i项的花费
    // cost[i][1] 前i 且买第i项的花费
    int[][] cost = new int[prices.length][2];
    cost[0][0] = Integer.MAX_VALUE;
    cost[0][1] = prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 不买第i项的花费 cost[i][0]
      // (i-1)/2 ~ (i - 1) 项必须购买 取最小值(i-1) / 2需要向上取整
      cost[i][0] = Integer.MAX_VALUE;
      int minIndex = Math.max(0, (int) Math.ceil((i - 1) / 2.0));
      for (int j = minIndex; j <= i - 1; j++) {
        cost[i][0] = Math.min(cost[i][0], cost[j][1]);
      }
      // 买第i项的花费 cost[i][1]
      cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][1]) + prices[i];
    }
    return Math.min(cost[prices.length - 1][0], cost[prices.length - 1][1]);
  }
}
