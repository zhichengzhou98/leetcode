package com.topic.dp;

import com.zzc.utils.ArrayUtils;
import com.zzc.utils.MathUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-23 17:12
 */
public class MostPoints {
  @Test
  void testFun() throws IOException {
    int[][] q = ArrayUtils.generate("array", int[][].class);
    System.out.println(mostPoints(q));
  }

  public long mostPoints(int[][] questions) {
    int len = questions.length;
    long res = questions[len - 1][0];
    long[][] dp = new long[len][2];
    //倒序遍历questions dp[i][1]表示解决第i题时的最大值
    for (int i = len - 1; i >= 0; i--) {
      int skip = questions[i][1];
      dp[i][1] = questions[i][0];
      if (i == len - 1) {
        dp[i][0] = 0;
      } else {
        dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]);
      }
      if (i + skip + 1 < len) {
        dp[i][1] += Math.max(dp[i + skip + 1][0], dp[i + skip + 1][1]);
      }
      res = MathUtils.max(res, dp[i][1], dp[i][0]);
    }
    return res;
  }
}
