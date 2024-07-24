package com.zzc.leetcode_jul;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 3047
 * @create 2024-07-23 17:18
 */
public class LargestSquareArea {

  @Test
  void testFun() throws IOException {
    int[][] bottomLeft =  ArrayUtils.generate("array", int[][].class);
    int[][] topRight =  ArrayUtils.generate("array1", int[][].class);
    System.out.println(largestSquareArea(bottomLeft, topRight));
  }
  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    long res = Long.MIN_VALUE;
    for (int i = 0; i < bottomLeft.length; i++) {
      for (int j = i + 1; j < bottomLeft.length; j++) {
        int[] bottomLeft1 = bottomLeft[i];
        int[] bottomLeft2 = bottomLeft[j];
        int[] topRight1 = topRight[i];
        int[] topRight2 = topRight[j];
        long area = largestSquareAreSingle(bottomLeft1, topRight1, bottomLeft2, topRight2);
        res = Math.max(res, area);
      }
    }
    return res;
  }

  private long largestSquareAreSingle(int[] bottomLeft1, int[] topRight1, int[] bottomLeft2,
                                      int[] topRight2) {
    //长方形1的坐标
    int square1X1 = bottomLeft1[0];
    int square1Y1 = bottomLeft1[1];

    int square1X2 = topRight1[0];
    int square1Y2 = topRight1[1];
    //长方形2的坐标
    int square2X1 = bottomLeft2[0];
    int square2Y1 = bottomLeft2[1];

    int square2X2 = topRight2[0];
    int square2Y2 = topRight2[1];


    int deltX = delt(square1X1, square1X2, square2X1, square2X2);
    int deltY = delt(square1Y1, square1Y2, square2Y1, square2Y2);
    return (long) Math.min(deltX, deltY) * Math.min(deltX, deltY);
  }

  //求长方形坐标的交集
  private int delt(int square1X1, int square1X2, int square2X1, int square2X2) {
    if (square2X1 >= square1X2 || square1X1>= square2X2) {
      //横坐标没有交集
      return 0;
    }
    int res1 = Math.min(Math.abs(square1X2 - square1X1), Math.abs(square2X2 - square2X1));
    int res2 = Math.min(Math.abs(square1X2 - square2X1), Math.abs(square2X2 - square1X1));
    return Math.min(res1, res2);
  }
}
