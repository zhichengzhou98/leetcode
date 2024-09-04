package com.topic.dp.zhuangya;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1879
 * @create 2024-09-04 22:22
 */
public class MinimumXORSum {
  @Test
  void testFun() {
    int[] nums1 = {1, 0, 3};
    int[] nums2 = {5, 3, 4};
    System.out.println(minimumXORSum(nums1, nums2));
  }

  int len;
  int[] num1;
  int[] num2;

  public int minimumXORSum(int[] nums1, int[] nums2) {
    int n = nums2.length;
    this.num1 = nums1;
    this.num2 = nums2;
    len = n;
    int[][] memo = new int[n][1 << n];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfs(n - 1, 0, memo);
  }

  /**
   * @param n    数值索引0-n
   * @param j    nums2中已经选过的位置的索引
   * @param memo 缓存
   * @return num1和num2 前0-n项异或值最小值
   */
  private int dfs(int n, int j, int[][] memo) {
    int res = Integer.MAX_VALUE;
    if (n == -1) {
      return 0;
    }
    if (memo[n][j] != -1) {
      return memo[n][j];
    }
    for (int i = 0; i < len; i++) {
      //i为索引
      if ((j & (1 << i)) == 0) {
        //表示第i个位置的元素没有使用过
        res = Math.min(res, (num1[n] ^ num2[i]) + dfs(n - 1, j | (1 << i), memo));
      }
    }
    memo[n][j] = res;
    return res;
  }
}
