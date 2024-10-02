package com.topic.dp;

import com.zzc.utils.MathUtils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description 983. 最低票价
 * @create 2024-10-01 13:14
 */
public class MincostTickets {
  @Test
  void testFun() {
    int[] d = {1, 4, 6, 7, 8};
    int[] c = {7, 2, 15};
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

  public int mincostTicketsV2(int[] days, int[] costs) {
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

  int[] costs;
  int[] memo;
  Set<Integer> daySet;

  public int mincostTickets(int[] days, int[] costs) {
    int size = days.length;
    memo = new int[366];
    Arrays.fill(memo, -1);
    this.costs = costs;
    daySet = Arrays.stream(days).boxed().collect(Collectors.toSet());
    return dfs(days[size - 1]);
  }

  private int dfs(int i) {
    if (i <= 0) {
      return 0;
    }
    int res = 0;
    if (memo[i] != -1) {
      return memo[i];
    }
    if (!daySet.contains(i)) {
      return dfs(i - 1);
    }
    if (i <= 1) {
      res = min(costs[0], costs[1], costs[2]);
    } else if (i <= 6) {
      res = min(dfs(i - 1) + costs[0], costs[1]);
    } else if (i <= 29) {
      res = min(dfs(i - 1) + costs[0], dfs(i - 7) + costs[1], costs[2]);
    } else {
      res = min(dfs(i - 1) + costs[0], dfs(i - 7) + costs[1], dfs(i - 30) + costs[2]);
    }
    memo[i] = res;
    return res;
  }

  public static int min(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.min(res, num);
    }
    return res;
  }
}
