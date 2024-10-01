package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 3176
 * @create 2024-09-06 10:17
 */
public class MaximumLength {
  @Test
  void testFun() {
    int[] arr = {30, 30, 29};


    System.out.println(maximumLength(arr, 0));
  }

  public int maximumLength(int[] nums, int k) {
    len = nums.length;
    this.nums = nums;
    int[][] dp = new int[len][k + 1];
    //dp[i][j] 表示以nums[i]结尾的数组中， num[seq] != num[seq + 1] 不超过j个
    for (int[] arr : dp) {
      Arrays.fill(arr, 1);
    }
    int res = 1;
    for (int i = 1; i < len; i++) {
      for (int j = 0; j <= k; j++) {
        int current = nums[i];
        //求dp[i][j]
        for (int l = 0; l < i; l++) {
          if (nums[l] == current) {
            dp[i][j] = dp[l][j] + 1;
          } else {
            if (j >= 1) {
              dp[i][j] = Math.max(dp[i][j], 1 + dp[l][j - 1]);
            }
          }
        }
        res = Math.max(res, dp[i][j]);
      }
    }
    return res;
  }

  int[] nums;
  int len;
  Map<String, Integer> map;

  public int maximumLengthV1(int[] nums, int k) {
    len = nums.length;
    this.nums = nums;
    map = new HashMap<>();
    return dfs(len - 1, 0, k);
  }

  /**
   * @param index   当前索引
   * @param lastNum 上一次选中的值，lastNum为0表示上一次没选
   * @param k
   * @return
   */
  private int dfs(int index, int lastNum, int k) {
    String key = String.join(",", List.of(String.valueOf(index), String.valueOf(lastNum),
        String.valueOf(k)));
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (index < 0) {
      return 0;
    }
    int res = 0;
    if (k == 0) {
      //表示只能选和lastNum一样的数字
      if (lastNum == 0) {
        //上一次没选
        //这一次选
        res = Math.max(res, 1 + dfs(index - 1, nums[index], k));
        //这一次不选
        res = Math.max(res, dfs(index - 1, lastNum, k));
      } else {
        //上次选了 只能选和上次一样的值
        if (nums[index] == lastNum) {
          res = Math.max(res, 1 + dfs(index - 1, lastNum, k));
        } else {
          //这次只能跳过
          res = Math.max(res, dfs(index - 1, lastNum, k));
        }

      }
    } else {
      if (lastNum == 0) {
        //上一次没选
        //这一次选
        res = Math.max(res, 1 + dfs(index - 1, nums[index], k));

        //这一次不选
        res = Math.max(res, dfs(index - 1, lastNum, k));
      } else {
        if (nums[index] == lastNum) {
          res = Math.max(res, 1 + dfs(index - 1, lastNum, k));
        } else {
          //跳过
          res = Math.max(res, dfs(index - 1, lastNum, k));
          //选
          res = Math.max(res, 1 + dfs(index - 1, nums[index], k - 1));
        }
      }
    }
    map.put(key, res);
    return res;
  }
}
