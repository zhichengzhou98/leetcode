package com.topic.dp.interval;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1547. 切棍子的最小成本 区间DP
 * @create 2024-11-11 21:36
 */
public class MinCost {
  public static void main(String[] args) {
    MinCost minCost = new MinCost();
    int[] arr = {13,17,15,18,3,22,27,6,35,7,11,28,26,20,4,5,21,10,8};
    System.out.println(minCost.minCost(36,arr));
  }
  int[] cuts;
  int[][] memo;

  public int minCost(int n, int[] cuts) {
    int size = cuts.length;
    int[] newCuts = new int[size + 2];
    Arrays.sort(cuts);
    newCuts[size + 1] = n;
    System.arraycopy(cuts, 0, newCuts, 1, newCuts.length - 1 - 1);
    this.cuts = newCuts;
    memo = new int[size + 2][size + 2];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfs(0, size + 1);
  }

  private int dfs(int i, int j) {
    if (i + 1 >= j) {
      return 0;
    }
    if (memo[i][j] >= 0) {
      return memo[i][j];
    }
    int res = Integer.MAX_VALUE;
    for (int k = i + 1; k < j; k++) {
      //枚举切割点
      res = Math.min(res, dfs(i, k) + dfs(k,j));
    }
    memo[i][j] = res + cuts[j] - cuts[i];
    return memo[i][j];
  }
}
