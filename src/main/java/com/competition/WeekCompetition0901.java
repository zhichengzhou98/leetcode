package com.competition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-01 10:21
 */
public class WeekCompetition0901 {
  @Test
  void testFun() {
    List<List<Integer>> grid1 = List.of(
        List.of(5, 5),
        List.of(5, 5),
        List.of(11, 5)
    );
    //System.out.println(1 << 10);
    System.out.println(maxScore(grid1));
  }
  private int maxScore = 0;
  public int maxScore(List<List<Integer>> grid) {
    Set<Integer> selectedValues = new HashSet<>();
    backtrack(grid, 0, 0, selectedValues);
    return maxScore;
  }

  // row为当前处理的行号，current当前得分
  private void backtrack(List<List<Integer>> grid, int row, int current, Set<Integer> set) {
    maxScore = Math.max(maxScore, current);
    if (row == grid.size()) {
      return;
    }
    for (int col = 0; col < grid.get(row).size(); col++) {
      int value = grid.get(row).get(col);
      if (!set.contains(value)) {
        set.add(value);
        backtrack(grid, row + 1, current + value, set);
        set.remove(value);
      }
    }
  }

  public int maxScoreV1(List<List<Integer>> grid) {
    int m = grid.size(); // 行数
    int n = grid.get(0).size(); // 列数


    int[] dp = new int[1 << n];
    Arrays.fill(dp, Integer.MIN_VALUE);  // 初始化为负无穷大
    dp[0] = 0; // 初始状态
    // 遍历每一行
    for (int row = 0; row < m; row++) {
      int[] newDp = new int[1 << n];
      Arrays.fill(newDp, Integer.MIN_VALUE);
      for (int mask = 0; mask < (1 << n); mask++) {
        if (dp[mask] == Integer.MIN_VALUE) {
          continue;
        }
        for (int col = 0; col < n; col++) {
          if ((mask & (1 << col)) == 0) {
            int newMask = mask | (1 << col);
            newDp[newMask] = Math.max(newDp[newMask], dp[mask] + grid.get(row).get(col));
          }
        }
      }
      dp = newDp;
    }
    // 找到所有选择集合中的最大得分
    int res = 0;
    for (int score : dp) {
      res = Math.max(res, score);
    }
    return res;
  }

  public int[] resultsArray(int[][] queries, int k) {
    int n = queries.length;
    int[] results = new int[n];

    // 大顶堆
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      int x = queries[i][0];
      int y = queries[i][1];
      int distance = Math.abs(x) + Math.abs(y);
      pq.offer(distance);
      if (pq.size() > k) {
        pq.poll();
      }
      if (pq.size() < k) {
        results[i] = -1;
      } else {
        results[i] = pq.peek();
      }
    }
    return results;
  }

  public boolean checkTwoChessboards(String coordinate1, String coordinate2) {

    boolean color1 = getColor(coordinate1);
    boolean color2 = getColor(coordinate2);
    return color1 == color2;
  }

  // 判断单个坐标的颜色
  private boolean getColor(String coordinate) {

    char col = coordinate.charAt(0); // 列
    int row = coordinate.charAt(1) - '0'; // 行
    return ((col - 'a' + 1) + row) % 2 == 0;
  }
}
