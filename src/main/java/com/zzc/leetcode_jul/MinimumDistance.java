package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

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
    points = Arrays.stream(points).map(point -> new int[]{point[0] + point[1],
        point[0] - point[1]}).toArray(int[][]::new);
    System.out.println(Arrays.deepToString(points));
    Arrays.sort(points, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });
    System.out.println(Arrays.deepToString(points));
    int[] first = points[0];
    int[] second = points[1];
    int[] third = points[points.length - 2];
    int[] forth = points[points.length - 1];
    return Math.min(getChebyshevDistance(first, third), getChebyshevDistance(second, forth));
  }

  private int getManhattanDistance(int[] begin, int[] end) {
    return Math.abs(begin[0] - end[0]) + Math.abs(begin[1] - end[1]);
  }

  private int getChebyshevDistance(int[] begin, int[] end) {
    return Math.max(Math.abs(begin[0] - end[0]), Math.abs(begin[1] - end[1]));
  }

}
