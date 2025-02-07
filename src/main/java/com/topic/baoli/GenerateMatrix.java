package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 59.螺旋矩阵II
 * @create 2025-02-07 15:39
 */
public class GenerateMatrix {
  @Test
  void testFun() {
    int[][] arr = generateMatrix(3);
    System.out.println(Arrays.deepToString(arr));
  }
  public int[][] generateMatrix(int n) {
    int[][] arr = new int[n][n];
    int cnts = n * n;
    int i = 0;
    int curI = 0;
    int curJ = 0;
    // 方向 右 -> 下 -> 左 -> 上
    int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    // 默认方向
    int curDir = 0;
    while (i < cnts) {
      arr[curI][curJ] = i + 1;
      i++;
      // 下个位置
      int nextI = dirs[curDir][0] + curI;
      int nextJ = dirs[curDir][1] + curJ;
      // 如果下个位置没有被填过 或没有超出边界 不需要换方向
      // 方向只需要换一次(不用写成循环)
      if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && arr[nextI][nextJ] == 0) {
        curI = nextI;
        curJ = nextJ;
      } else {
        curDir = (curDir + 1) % 4;
        curI += dirs[curDir][0];
        curJ += dirs[curDir][1];
      }
    }
    return arr;
  }
}
