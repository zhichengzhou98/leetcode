package com.topic.dp;

import com.zzc.utils.MathUtils;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 983. 最低票价
 * @create 2024-10-01 13:14
 */
public class MincostTickets {
  @Test
  void testFun() {
    int[] d = {1, 4, 6, 7, 8, 20};
    int[] c = {2, 7, 15};
    System.out.println(mincostTickets(d, c));
  }

  private static final int MAX_COST = 365 * 1000;

  public int mincostTicketsV1(int[] days, int[] costs) {
    int size = days.length;
    //dp[i][j] 表示0-i 天最小的花费， 且第i天买的票为costs[j] j==3表示第i天不买票
    //j == 4表示 j为[0,3]的最小值
    int[][] dp = new int[size][5];
    dp[0][0] = costs[0];
    dp[0][1] = costs[1];
    dp[0][2] = costs[2];
    dp[0][3] = MAX_COST;
    dp[0][4] = min(dp[0][0], dp[0][1], dp[0][2], dp[0][3]);
    for (int i = 1; i < days.length; i++) {
      int dayNum = days[i];
      //买一天的票
      dp[i][0] = dp[i - 1][4] + costs[0];
      //买7天的票
      dp[i][1] = dp[i - 1][4] + costs[1];
      dp[i][2] = dp[i - 1][4] + costs[2];
      //不买票
      dp[i][3] = MAX_COST;
      //dayNum倒推30天
      for (int j = i - 30; j < i; j++) {
        if (j >= 0) {
          if (dayNum - days[j] <= 29) {
            dp[i][3] = Math.min(dp[i][3], dp[j][2]);
          }
          if (dayNum - days[j] <= 6) {
            dp[i][3] = min(dp[i][3], dp[j][2], dp[j][1]);
          }
        }
      }
      dp[i][4] = min(dp[i][0], dp[i][1], dp[i][2], dp[i][3]);
    }
    return dp[size - 1][4];
  }

  public int mincostTickets(int[] days, int[] costs) {
    int size = days.length;
    //dp[i][j] 表示0-i 天最小的花费， 且第i天买的票为costs[j] j==3表示第i天不买票
    //j == 4表示 j为[0,3]的最小值
    int[][] dp = new int[size][5];
    dp[0][0] = costs[0];
    dp[0][1] = costs[1];
    dp[0][2] = costs[2];
    dp[0][3] = MAX_COST;
    dp[0][4] = min(dp[0][0], dp[0][1], dp[0][2], dp[0][3]);
    for (int i = 1; i < days.length; i++) {
      int dayNum = days[i];
      //买一天的票
      dp[i][0] = dp[i - 1][4] + costs[0];
      //买7天的票
      dp[i][1] = dp[i - 1][4] + costs[1];
      dp[i][2] = dp[i - 1][4] + costs[2];
      //不买票
      dp[i][3] = MAX_COST;
      //dayNum倒推30天
      for (int j = i - 1; j >= 0; j--) {
        if (dayNum - days[j] <= 6) {
          dp[i][3] = min(dp[i][3], dp[j][2], dp[j][1]);
        } else if (dayNum - days[j] <= 29) {
          dp[i][3] = Math.min(dp[i][3], dp[j][2]);
        } else {
          break;
        }
      }
      dp[i][4] = min(dp[i][0], dp[i][1], dp[i][2], dp[i][3]);
    }
    return dp[size - 1][4];
  }

  public static int min(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.min(res, num);
    }
    return res;
  }
}
