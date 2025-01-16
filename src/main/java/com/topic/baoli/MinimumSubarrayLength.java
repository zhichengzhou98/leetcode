package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3095.或值至少K的最短子数组I 子数组(不是子序列) o(n²)
 * @create 2025-01-16 9:37
 */
public class MinimumSubarrayLength {
  public int minimumSubarrayLength(int[] nums, int k) {
    int res = Integer.MAX_VALUE;

    // 枚举开始位置
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= k) {
        return 1;
      }
      int tmp = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        tmp = tmp | nums[j];
        if (tmp >= k) {
          res = Math.min(res, j - i + 1);
          break;
        }
      }
    }
    if (res == Integer.MAX_VALUE) {
      return -1;
    }
    return res;
  }


  int[] pre;
  int[] nums;
  public int minimumSubarrayLengthV1(int[] nums, int k) {
    this.nums = nums;
    // 前缀和(与运算)
    pre = new int[nums.length];
    pre[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      pre[i] = pre[i-1] | nums[i];
    }
    long res = dfs(nums.length-1, k);
    if (res >= Integer.MAX_VALUE) {
      return -1;
    }
    return (int) res;
  }

  /**
   *
   * @param i 数组索引
   * @param tar 目标数
   * @return 最小长度
   */
  private long dfs(int i, int tar) {
    if (tar == 0) {
      return 0;
    }
    if (i < 0) {
      return Integer.MAX_VALUE;
    }
    // 枚举选或不选
    // 先判断全选是否满足
    if (pre[i] < tar) {
      // 不满足
      return Integer.MAX_VALUE;
    }


    // 判断当前 nums[i]能否影响tar
    if ((nums[i] & tar) > 0) {
      // 能影响
      // 选 i

      return Math.min(dfs(i-1, (tar ^ nums[i]) & tar) + 1, dfs(i-1, tar));
    } else {
      // 不能影响 直接跳过
      return dfs(i-1, tar);
    }
  }
}
