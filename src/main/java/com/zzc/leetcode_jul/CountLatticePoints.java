package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-23 10:47
 */
public class CountLatticePoints {
  @Test
  void testFun() throws IOException {
    int[][] circles = ArrayUtils.generate("array1", int[][].class);
    System.out.println(countLatticePoints(circles));
  }

  public int countLatticePoints(int[][] circles) {
    //枚举点
    //按圆的半径大到小排序
    Arrays.sort(circles, (a, b) -> b[2] - a[2]);
    int res = 0;
    //求出x, y 范围的最大值
    int xMax = Integer.MIN_VALUE;
    int yMax = Integer.MIN_VALUE;
    int xMin = Integer.MAX_VALUE;
    int yMin = Integer.MAX_VALUE;
    for (int i = 0; i < circles.length; i++) {
      int r = circles[i][2];
      int x = circles[i][0];
      int y = circles[i][1];
      xMax = Math.max(xMax, x + r);
      xMin = Math.min(xMin, x - r);
      yMax = Math.max(yMax, y + r);
      yMin = Math.min(yMin, y - r);
    }
    for (int j = xMin; j <= xMax; j++) {
      for (int k = yMin; k <= yMax; k++) {
        int[] currentPoint = new int[]{j, k};
        for (int i = 0; i < circles.length; i++) {
          if (inCircle(currentPoint, circles[i])) {
            res++;
            break;
          }
        }
      }
    }
    return res;
  }

  public int countLatticePointsV2(int[][] circles) {
    Set<String> res = new HashSet<>();
    for (int i = 0; i < circles.length; i++) {
      int[] currentCircle = circles[i];
      int r = currentCircle[2];
      int x = currentCircle[0];
      int y = currentCircle[1];
      int xMin = x - r;
      int xMax = x + r;
      int yMin = y - r;
      int yMax = y + r;
      for (int j = xMin; j <= xMax; j++) {
        for (int k = yMin; k <= yMax; k++) {
          if (inCircle(new int[]{j, k}, currentCircle)) {
            res.add(j + "," + k);
          }
        }
      }
    }
    return res.size();
  }

  public int countLatticePointsV1(int[][] circles) {
    Set<String> res = new HashSet<>();
    for (int i = 0; i < circles.length; i++) {
      int[] currentCircle = circles[i];
      for (int j = -100; j <= 200; j++) {
        for (int k = -100; k <= 200; k++) {
          if (inCircle(new int[]{j, k}, currentCircle)) {
            res.add(j + "," + k);
          }
        }
      }
    }
    return res.size();
  }

  //判断点是否在圆内 点坐标的范围x: [-100, 200], y: [-100, 200]
  private boolean inCircle(int[] point, int[] circle) {
    int x1 = point[0];
    int y1 = point[1];
    int x2 = circle[0];
    int y2 = circle[1];
    int r = circle[2];
    double dis = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
    return dis <= Math.pow(r, 2);
  }
}
