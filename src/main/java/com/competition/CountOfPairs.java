package com.competition;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-11 10:41
 */
public class CountOfPairs {
  @Test
  void testFun() {
    int[] arr = {51,195,196,202,389,534,659,807,875,939};
    System.out.println(countOfPairsV1(arr));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);
  long res = 0L;
  int len;
  private Map<String, Long> map;

  public int countOfPairsV1(int[] nums) {
    len = nums.length;
    map = new HashMap<>();
    //回溯
    dfsV1(0, nums, 0);
    return (int) res;
  }
  private void dfsV1(int current, int[] nums, int pre1) {
    if (current >= len) {
      res = (res + 1) % MOD;
      return;
    }

    String key = current + "," + pre1;
    if (map.containsKey(key)) {
      res = (res + map.get(key)) % MOD;
      return;
    }

    long localRes = 0;
    int num = nums[current];
    for (int i = pre1; i <= num; i++) {
      int left = num - i;
      if ((current == 0 && left <= 1000) || (current > 0 && left <= nums[current - 1] - pre1)) {
        long previousRes = res;
        dfsV1(current + 1, nums, i);
        localRes = (localRes + res - previousRes + MOD) % MOD;
      }
    }

    map.put(key, localRes);
  }

  //pre1数组1的前一个数
  //current当前遍历的位置
  //表示遍历到前current个数并且上一个数是pre1的组合个数
  private void dfs(int current, int[] nums, int pre1) {
    if (current >= len) {
      res = (res + 1) % MOD;
      return;
    }
    int num = nums[current];

    for (int i = pre1; i <= num; i++) {
      int left = num - i;
      if ((current == 0 && left <= 1000) || left <= nums[current - 1] - pre1) {
        dfs(current + 1, nums, i);
      }
    }
  }
}
