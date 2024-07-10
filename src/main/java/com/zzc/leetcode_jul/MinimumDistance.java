package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author zc.zhou
 * @Description 3102
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
    //找出x最大 次大 最小 次小的点
    //找出y最大 次大 最小 次小的点
    //将曼哈顿距离转化为切比雪夫距离
    points = Arrays.stream(points).map(point -> new int[]{point[0] + point[1],
        point[0] - point[1]}).toArray(int[][]::new);
    Points pointsX = new Points();
    Points pointsY = new Points();
    int[] firstPoint = points[0];
    int[] secondPoint = points[1];
    if (firstPoint[0] >= secondPoint[0]) {
      pointsX.max = 0;
      pointsX.secondMax = 1;
      pointsX.min = 1;
      pointsX.secondMin = 0;
    } else {
      pointsX.max = 1;
      pointsX.secondMax = 0;
      pointsX.min = 0;
      pointsX.secondMin = 1;
    }
    if (firstPoint[1] >= secondPoint[1]) {
      pointsY.max = 0;
      pointsY.secondMax = 1;
      pointsY.min = 1;
      pointsY.secondMin = 0;
    } else {
      pointsY.max = 1;
      pointsY.secondMax = 0;
      pointsY.min = 0;
      pointsY.secondMin = 1;
    }
    //遍历剩下的点，更新pointsX， pointsY
    for (int i = 2; i < points.length; i++) {
      int currentX = points[i][0];
      int currentY = points[i][1];
      if (currentX >= points[pointsX.max][0]) {
        //比当前最大的还大
        pointsX.secondMax = pointsX.max;
        pointsX.max = i;
      } else if (currentX >= points[pointsX.secondMax][0]) {
        //比第二大还大
        pointsX.secondMax = i;
      }
      if (currentX < points[pointsX.min][0]) {
        pointsX.secondMin = pointsX.min;
        pointsX.min = i;
      } else if (currentX < points[pointsX.secondMin][0]) {
        pointsX.secondMin = i;
      }

      if (currentY >= points[pointsY.max][1]) {
        pointsY.secondMax = pointsY.max;
        pointsY.max = i;
      } else if (currentY >= points[pointsY.secondMax][1]) {
        //比第二大还大
        pointsY.secondMax = i;
      }
      if (currentY < points[pointsY.min][1]) {
        pointsY.secondMin = pointsY.min;
        pointsY.min = i;
      } else if (currentY < points[pointsY.secondMin][1]) {
        pointsY.secondMin = i;
      }
    }
    int res = Integer.MAX_VALUE;
    //移除x最大
    int xMaxIndex = pointsX.max;
    //x最大距离
    int maxX = points[pointsX.secondMax][0] - points[pointsX.min][0];
    int maxY = points[pointsY.max][1] - points[pointsY.min][1];
    if (xMaxIndex == pointsY.max) {
      maxY = points[pointsY.secondMax][1] - points[pointsY.min][1];
    }else if (xMaxIndex == pointsY.min) {
      maxY = points[pointsY.max][1] - points[pointsY.secondMin][1];
    }
    res = Math.min(res, Math.max(maxX, maxY));

    //移除最小的点
    int xMinIndex = pointsX.min;
    //x最大距离
    maxX = points[pointsX.max][0] - points[pointsX.secondMin][0];
    maxY = points[pointsY.max][1] - points[pointsY.min][1];
    if (xMinIndex == pointsY.max) {
      maxY = points[pointsY.secondMax][1] - points[pointsY.min][1];
    }else if (xMinIndex == pointsY.min) {
      maxY = points[pointsY.max][1] - points[pointsY.secondMin][1];
    }
    res = Math.min(res, Math.max(maxX, maxY));

    //移除y最大
    int yMaxIndex = pointsY.max;
    //y最大距离
    maxY = points[pointsY.secondMax][1] - points[pointsY.min][1];
    maxX = points[pointsX.max][0] - points[pointsX.min][0];
    if (yMaxIndex == pointsX.max) {
      maxX = points[pointsX.secondMax][0] - points[pointsX.min][0];
    }else if (yMaxIndex == pointsX.min) {
      maxX = points[pointsY.max][0] - points[pointsY.secondMin][0];
    }
    res = Math.min(res, Math.max(maxX, maxY));

    //移除y最小
    int yMinIndex = pointsY.min;
    //y最大距离
    maxY = points[pointsY.max][1] - points[pointsY.secondMin][1];
    maxX = points[pointsX.max][0] - points[pointsX.min][0];
    if (yMinIndex == pointsX.max) {
      maxX = points[pointsX.secondMax][0] - points[pointsX.min][0];
    }else if (yMinIndex == pointsX.min) {
      maxX = points[pointsY.max][0] - points[pointsY.secondMin][0];
    }
    res = Math.min(res, Math.max(maxX, maxY));
    return res;
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

//记录索引的位置
class Points {
  int max;
  int secondMax;
  int min;
  int secondMin;
}
