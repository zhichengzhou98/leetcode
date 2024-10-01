package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2555 TODO
 * @create 2024-09-11 8:59
 */
public class MaximizeWin {
  public int maximizeWin(int[] prizePositions, int k) {
    int n = prizePositions.length;

    // 用于存储以当前i为起点，在长度为k内最多能覆盖的奖品数
    int[] dp = new int[n];

    // 滑动窗口计算dp数组
    int left = 0;
    for (int right = 0; right < n; right++) {
      while (prizePositions[right] - prizePositions[left] > k) {
        left++;
      }
      dp[right] = right - left + 1;
    }

    // 计算从左到右的最大累积数量
    int[] maxFromLeft = new int[n];
    maxFromLeft[0] = dp[0];
    for (int i = 1; i < n; i++) {
      maxFromLeft[i] = Math.max(maxFromLeft[i - 1], dp[i]);
    }

    // 使用双指针法计算两个区间最大重叠
    int maxResult = 0;
    left = 0;
    for (int right = 0; right < n; right++) {
      while (prizePositions[right] - prizePositions[left] > k) {
        left++;
      }

      int coveredWithCurrentRight = dp[right];
      int coveredWithBestLeft = (left > 0) ? maxFromLeft[left - 1] : 0;
      maxResult = Math.max(maxResult, coveredWithCurrentRight + coveredWithBestLeft);
    }

    return maxResult;
  }
}
