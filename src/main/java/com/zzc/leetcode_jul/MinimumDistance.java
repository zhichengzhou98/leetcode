package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;
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

  //TODO: o(n)
  public int minimumDistance(int[][] points) {
    return 0;
  }

  public int minimumDistance1(int[][] points) {
    points = Arrays.stream(points).map(point -> new int[]{point[0] + point[1],
        point[0] - point[1]}).toArray(int[][]::new);
    System.out.println(Arrays.deepToString(points));
    TreeMap<Integer, Integer> xCountMap = new TreeMap<>();
    TreeMap<Integer, Integer> yCountMap = new TreeMap<>();
    for (int[] point : points) {
      xCountMap.put(point[0], xCountMap.getOrDefault(point[0], 0) + 1);
      yCountMap.put(point[1], yCountMap.getOrDefault(point[1], 0) + 1);
    }
    int res = Integer.MAX_VALUE;
    //枚举移除每个点
    for (int[] point : points) {
      int x = point[0];
      xCountMap.put(x, xCountMap.get(x) - 1);
      if (xCountMap.get(x) == 0) {
        xCountMap.remove(x);
      }
      int y = point[1];
      yCountMap.put(y, yCountMap.get(y) - 1);
      if (yCountMap.get(y) == 0) {
        yCountMap.remove(y);
      }
      res = Math.min(res, Math.max(xCountMap.lastKey() - xCountMap.firstKey(),
          yCountMap.lastKey() - yCountMap.firstKey()));
      xCountMap.put(x, xCountMap.getOrDefault(x, 0) + 1);
      yCountMap.put(y, yCountMap.getOrDefault(y, 0) + 1);
    }
    return res;
  }

  private int getManhattanDistance(int[] begin, int[] end) {
    return Math.abs(begin[0] - end[0]) + Math.abs(begin[1] - end[1]);
  }

  private int getChebyshevDistance(int[] begin, int[] end) {
    return Math.max(Math.abs(begin[0] - end[0]), Math.abs(begin[1] - end[1]));
  }

}
