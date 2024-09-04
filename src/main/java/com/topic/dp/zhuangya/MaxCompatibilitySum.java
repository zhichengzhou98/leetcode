package com.topic.dp.zhuangya;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1947. 最大兼容性评分和 状压dp 回溯
 * @create 2024-09-04 22:41
 */
public class MaxCompatibilitySum {
  int len;
  int[][] s;
  int[][] m;

  public int maxCompatibilitySum(int[][] students, int[][] mentors) {
    len = students.length;
    s = students;
    m = mentors;
    int[][] memo = new int[len][1 << len];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfs(len - 1, 0, memo);
  }

  /**
   * 时间复杂度：n * 2^n * n * m
   * @param n    当前匹配到的索引
   * @param j    mentors已经选过的索引
   * @param memo 缓存
   * @return 数组0-n最大得分
   */
  private int dfs(int n, int j, int[][] memo) {
    if (n < 0) {
      return 0;
    }
    if (memo[n][j] != -1) {
      return memo[n][j];
    }
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      if ((j & (1 << i)) == 0) {
        //当前索引i位置的mentors没有被选过
        int[] tmpM = m[i];
        int[] tmpN = s[n];
        int tempScore = 0;
        for (int k = 0; k < tmpN.length; k++) {
          if (tmpM[k] == tmpN[k]) {
            tempScore++;
          }
        }
        res = Math.max(res, tempScore + dfs(n - 1, j | (1 << i), memo));
      }
    }
    memo[n][j] = res;
    return res;
  }
}
