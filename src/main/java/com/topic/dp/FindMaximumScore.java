package com.topic.dp;

import java.util.List;

/**
 * @author zc.zhou
 * @Description 3282. 到达数组末尾的最大得分
 * @create 2024-09-08 20:55
 */
public class FindMaximumScore {
  public long findMaximumScoreV1(List<Integer> nums) {
    long[] dp = new long[nums.size()];
    for (int i = 1; i < dp.length; i++) {
      //求dp[i]
      for (int j = 0; j < i; j++) {
        dp[i] = Math.max(dp[j] + (long) (i - j) * nums.get(j), dp[i]);
      }
    }
    return dp[dp.length - 1];
  }

  public long findMaximumScore(List<Integer> nums) {
    long[] dp = new long[nums.size()];
    long maxNum = nums.get(0);
    for (int i = 1; i < dp.length; i++) {
      //求dp[i] dp[i] = dp[i - 1] + max(n[0]...n[i -1])
      dp[i] = dp[i - 1] + maxNum;
      maxNum = Math.max(maxNum, nums.get(i));
    }
    return dp[dp.length - 1];
  }
}
