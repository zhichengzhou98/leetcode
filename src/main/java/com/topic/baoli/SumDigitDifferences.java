package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 3153
 * @create 2024-08-30 9:15
 */
public class SumDigitDifferences {
  @Test
  void testFun() {
    System.out.println(sumDigitDifferences(new int[]{554,528}));
  }
  public long sumDigitDifferences(int[] nums) {
    long res = 0L;
    String numStr = String.valueOf(nums[0]);
    //maps[i] 表示第i位数字出现过的数次的map
    int[][] maps = new int[numStr.length()][10];
    for (int i = 0; i < numStr.length(); i++) {
      char c = numStr.charAt(i);
      int numIndex = c - '0';
      maps[i][numIndex]++;
    }
    for (int i = 1; i < nums.length; i++) {
      //当前数字
      String str = String.valueOf(nums[i]);
      for (int j = 0; j < str.length(); j++) {
        int numIndex = str.charAt(j) - '0';
        int cnt = maps[j][numIndex];
        res = res + i - cnt;
        maps[j][numIndex]++;
      }
    }
    return res;
  }

  public long sumDigitDifferencesV1(int[] nums) {
    long res = 0L;
    String numStr = String.valueOf(nums[0]);
    //maps[i] 表示第i为数字出现过的数次的map
    Map<Integer, Integer>[] maps = new Map[numStr.length()];
    for (int i = 0; i < numStr.length(); i++) {
      char c = numStr.charAt(i);
      maps[i] = new HashMap<>();
      int numIndex = c - '0';
      maps[i].put(numIndex, maps[i].getOrDefault(numIndex, 0) + 1);
    }
    for (int i = 1; i < nums.length; i++) {
      //当前数字
      String str = String.valueOf(nums[i]);
      for (int j = 0; j < str.length(); j++) {
        int numIndex = str.charAt(j) - '0';
        if (!maps[j].containsKey(numIndex)) {
          res = res + i;
          maps[j].put(numIndex, 1);
        } else {
          int cnt = maps[j].get(numIndex);
          res = res + i - cnt;
          maps[j].put(numIndex, cnt + 1);
        }
      }
    }
    return res;
  }
}
