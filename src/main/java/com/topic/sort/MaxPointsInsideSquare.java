package com.topic.sort;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3143. 正方形中的最多点数
 * @create 2024-08-03 12:45
 */
public class MaxPointsInsideSquare {
  @Test
  void testFun() throws IOException {
    int[][] points = ArrayUtils.generate("array", int[][].class);
    System.out.println(maxPointsInsideSquare(points, "abdca"));
  }

  //正方行的边长由小到大
  public int maxPointsInsideSquare(int[][] points, String s) {
    //把索引按照正方形边长排序
    Integer[] indexs = new Integer[points.length];
    for (int i = 0; i < indexs.length; i++) {
      indexs[i] = i;
    }
    Arrays.sort(indexs, Comparator.comparingInt(a -> getSquareLenOfPoint(points[a])));
    Set<Integer> set = new HashSet<>();
    //temps[i][0]: 正方形边长，temps[i][1]： 标签
    int[][] temps = new int[indexs.length][2];
    for (int i = 0; i < temps.length; i++) {
      Integer index = indexs[i];
      int len = getSquareLenOfPoint(points[index]);
      int label = s.charAt(index) - 'a';
      temps[i] = new int[]{len, label};
    }
    int len = -1;
    for (int[] temp : temps) {
      int label = temp[1];
      if (set.contains(label)) {
        len = temp[0];
        break;
      }
      set.add(label);
    }
    if (len == -1) {
      return points.length;
    }
    int finalLen = len;
    return (int) Arrays.stream(temps).filter(arr -> arr[0] < finalLen).count();
  }

  private int getSquareLenOfPoint(int[] point) {
    return Math.max(Math.abs(point[0]), Math.abs(point[1]));
  }
}
