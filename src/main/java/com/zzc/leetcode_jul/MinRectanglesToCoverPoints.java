package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-31 9:23
 */
public class MinRectanglesToCoverPoints {
  @Test
  void testFun() throws IOException {
    int[][] points = ArrayUtils.generate("array", int[][].class);
    System.out.println(minRectanglesToCoverPoints(points, 1));
  }
  public int minRectanglesToCoverPoints(int[][] points, int w) {
    //获取点的横坐标集合 并去重
    List<Integer> list = Arrays.stream(points).map(arr -> arr[0]).distinct().sorted().toList();
    if (list.isEmpty()) {
      return 0;
    }
    int currentPre = list.get(0);
    int count = 1;
    int currentLast = currentPre + w;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) > currentLast) {
        count++;
        currentPre = list.get(i);
        currentLast = currentPre + w;
      }
    }
    return count;
  }
}
