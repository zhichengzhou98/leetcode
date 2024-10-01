package com.competition;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-15 10:29
 */
public class WeekCompetition0915 {
  @Test
  void testFun() throws IOException {
    int[] a = {13774,31587,-16090,-10727};
    int[] b = ArrayUtils.generate("array", int[].class);

    System.out.println(maxScore(a,b));
  }

  public long maxScore(int[] a, int[] b) {
    double dp0 = Long.MIN_VALUE;
    double dp1 = Long.MIN_VALUE;
    double dp2 = Long.MIN_VALUE;
    double dp3 = Long.MIN_VALUE;
    for (int j : b) {
      dp3 = Math.max(dp3, dp2 + (double) a[3] * j);
      dp2 = Math.max(dp2, dp1 + (double) a[2] * j);
      dp1 = Math.max(dp1, dp0 + (double) a[1] * j);
      dp0 = Math.max(dp0, (double) a[0] * j);
    }
    return (long) dp3;
  }

  public int[] getSneakyNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int[] result = new int[2];
    int index = 0;

    for (int num : nums) {
      if (set.contains(num)) {
        result[index++] = num;
      } else {
        set.add(num);
      }
    }
    return result;
  }
}
