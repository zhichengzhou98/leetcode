package com.competition;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-18 10:31
 */
public class WeekCompetition0818 {
  @Test
  void testFun() throws IOException {
    int[][] q = ArrayUtils.generate("array", int[][].class);
    String s = "010101";
    System.out.println(Arrays.toString(countKConstraintSubstrings(s, 1, q)));


    //System.out.println(countKConstraintSubstrings("10101", 1));
  }

  Map<String,Integer> cntMap;
  public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
    long[] res = new long[queries.length];
    cntMap = new HashMap<>();
    for (int i = 0; i < queries.length; i++) {
      int[] q = queries[i];
      String sub = s.substring(q[0], q[1] + 1);
      if (cntMap.containsKey(sub)) {
        res[i] = cntMap.get(sub);
      } else {
        int counts = countKConstraintSubstrings(sub, k);
        cntMap.put(sub, counts);
        res[i] = counts;
      }
    }
    return res;
  }

  public int countKConstraintSubstrings(String s, int k) {
    int n = s.length();
    int count = 0;
    int left = 0;
    int zeros = 0;
    int ones = 0;
    for (int right = 0; right < n; right++) {
      // 更新计数
      if (s.charAt(right) == '0') {
        zeros++;
      } else {
        ones++;
      }
      // 如果窗口不再满足条件，移动左指针
      while (zeros > k && ones > k) {
        if (s.charAt(left) == '0') {
          zeros--;
        } else {
          ones--;
        }
        left++;
      }
      count += (right - left + 1);
    }
    return count;
  }

  public int countKConstraintSubstringsV1(String s, int k) {
    int n = s.length();
    int count = 0;

    // 枚举所有子字符串的起始点
    for (int i = 0; i < n; i++) {
      int zeros = 0, ones = 0;

      // 枚举子字符串的结束点
      for (int j = i; j < n; j++) {
        // 统计当前子字符串中的 0 和 1
        if (s.charAt(j) == '0') {
          zeros++;
        } else {
          ones++;
        }

        // 检查是否满足 k 约束条件
        if (zeros <= k || ones <= k) {
          count++;
        } else {
          // 如果不满足，后续的子字符串也不会满足，因此可以提前退出内循环
          break;
        }
      }
    }
    return count;
  }

  public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
    int n = energyDrinkA.length;

    // 初始化 dp 数组
    long[] dpA = new long[n];
    long[] dpB = new long[n];

    // 初始条件
    dpA[0] = energyDrinkA[0];
    dpB[0] = energyDrinkB[0];

    // 如果 n > 1，则初始化第二个小时
    if (n > 1) {
      dpA[1] = Math.max(energyDrinkA[1], dpA[0] + energyDrinkA[1]);
      dpB[1] = Math.max(energyDrinkB[1], dpB[0] + energyDrinkB[1]);
    }

    // 动态规划填充 dp 数组
    for (int i = 2; i < n; i++) {
      dpA[i] = Math.max(dpA[i - 1] + energyDrinkA[i], dpB[i - 2] + energyDrinkA[i]);
      dpB[i] = Math.max(dpB[i - 1] + energyDrinkB[i], dpA[i - 2] + energyDrinkB[i]);
    }

    // 返回最大能量值
    return Math.max(dpA[n - 1], dpB[n - 1]);
  }
}
