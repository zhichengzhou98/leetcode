package com.topic.dp.knapsack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 3180. 执行操作可获得的最大总奖励 I
 * @create 2024-09-26 21:07
 */
public class MaxTotalReward {
  @Test
  void testFun() {
    int[] arr = {1,6,4,3,2};
    System.out.println(maxTotalReward(arr));
  }
  public int maxTotalReward(int[] rewardValues) {
    Arrays.sort(rewardValues);
    int res = 0;
    int size = rewardValues.length;
    //最大值不超过4000
    int maxScore = 4000;
    boolean[][] dp = new boolean[size][maxScore];
    //dp[i][j] 表示前i个数 能否达到j积分
    dp[0][0] = true;
    dp[0][rewardValues[0]] = true;
    for (int i = 1; i < size; i++) {
      for (int j = 0; j < maxScore; j++) {
        if (j == 0) {
          dp[i][j] = true;
        } else {
          //考虑当前数 选还是不选
          int cur = rewardValues[i];
          //不选
          dp[i][j] = dp[i - 1][j];
          //选 => 前i-1个数要实现的积分为 j-cur
          if (cur > j - cur && j - cur >= 0) {
            dp[i][j] |= dp[i - 1][j - cur];
          }
        }
      }
    }
    for (int i = maxScore - 1; i >= 0; i--) {
      if (dp[size - 1][i]) {
        return i;
      }
    }
    return res;
  }
}
