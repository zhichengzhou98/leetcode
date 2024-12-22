package com.topic.dp.presum;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3250. 单调数组对的数目 I  3251. 单调数组对的数目 II
 * @create 2024-11-28 19:50
 */
public class CountOfPairs {
  @Test
  void testFun() {
    int[] arr = {1, 17};
    System.out.println(countOfPairs(arr));
  }

  private static final int MOD = (int) (1e9 + 7);

  // 前缀和优化
  public int countOfPairs(int[] nums) {
    int size = nums.length;
    // dp[i][j] 表示 前i项 nums1[i] = j时的方案数
    long[][] dp = new long[size][1001];
    // 前缀和
    long[][] preSum = new long[size][1002];
    // i = 0时
    int nums0 = nums[0];
    for (int i = 0; i <= nums0; i++) {
      dp[0][i] = 1;
      preSum[0][i + 1] = preSum[0][i] + dp[0][i];
    }
    for (int i = 1; i < nums.length; i++) {
      // 当前索引 i
      int cur = nums[i];
      for (int j = 0; j <= cur; j++) {
        // 当前nums2 -> cur -j
        // 求dp[i - 1][k]之和  k: [0, nums[i-1] - (cur - j)] 且 k<= j
        // nums[i-1] - (cur - j) < 0, 且说明不存在k
        int k = Math.min(nums[i - 1] - (cur - j), j) + 1;
        if (k >= 0) {
          dp[i][j] = preSum[i - 1][k];
        }
        // 更新前缀和
        preSum[i][j + 1] = (preSum[i][j] + dp[i][j]) % MOD;
      }
    }
    return (int) preSum[size - 1][nums[size - 1] + 1];
  }

  // o(n * m²)
  public int countOfPairsV1(int[] nums) {
    int size = nums.length;
    // dp[i][j] 表示 前i项 nums1[i] = j时的方案数
    long[][] dp = new long[size][51];
    // i = 0时
    int nums0 = nums[0];
    for (int i = 0; i <= nums0; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < nums.length; i++) {
      // 当前索引 i
      int cur = nums[i];
      for (int j = 0; j <= cur; j++) {
        dp[i][j] = 0;
        int nums2 = cur - j;
        for (int k = 0; k <= j; k++) {
          // 需要保证nums2递减
          int preNums2 = nums[i - 1] - k;
          if (nums2 <= preNums2) {
            dp[i][j] = (dp[i - 1][k] + dp[i][j]) % MOD;
          }
        }
      }
    }
    long res = 0L;
    for (int i = 0; i <= 50; i++) {
      res = (res + dp[size - 1][i]) % MOD;
    }
    return (int) res;
  }
}
