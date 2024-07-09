package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-09 10:38
 */
public class MinimumDistance {

  @Test
  void testFun() throws IOException {
    int[][] points = ArrayUtils.generate("array", int[][].class);
    System.out.println(minimumDistance(points));
  }
  public int minimumDistance(int[][] points) {
    Arrays.sort(points, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });
    int[] first = points[0];
    int[] second = points[1];
    int[] third = points[points.length - 2];
    int[] forth = points[points.length - 1];
    return Math.min(getDistance(first, third), getDistance(second, forth));
  }

  private int getDistance(int[] begin, int[] end) {
    return Math.abs(begin[0] - end[0]) + Math.abs(begin[1] - end[1]);
  }
}
