package com.topic.enumerate;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description 3128 直角三角形 枚举直角顶点
 * @create 2024-08-02 9:22
 */
public class NumberOfRightTriangles {
  @Test
  void testFun() throws IOException {
    int[][] grid = ArrayUtils.generate("array", int[][].class);
    System.out.println(numberOfRightTriangles(grid));
  }

  //o(n²)
  public long numberOfRightTriangles(int[][] grid) {
    long cnts = 0L;
    int row = grid.length;
    int line = grid[0].length;

    //每一列1的个数
    int[] lines = new int[line];
    //每一行1的个数
    int[] rows = new int[row];
    for (int i = 0; i < line; i++) {
      //第i列
      for (int j = 0; j < row; j++) {
        //第j行
        if (grid[j][i] == 1) {
          //递增
          lines[i]++;
          rows[j]++;
        }
      }
    }
    //枚举直角顶点
    //遍历grid
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < line; j++) {
        //第一个点[i, j]
        if (grid[i][j] == 1) {
          cnts += (long) (lines[j] - 1) * (rows[i] - 1);
        }
      }
    }
    return cnts;
  }


  //超时o(n³)
  public long numberOfRightTrianglesV1(int[][] grid) {
    long cnts = 0L;
    int row = grid.length;
    int line = grid[0].length;

    //queues[i]表示第i列所有1的行号
    HashSet<Integer>[] lists = new HashSet[line];
    for (int i = 0; i < line; i++) {
      //第i列
      lists[i] = new HashSet<>();
      for (int j = 0; j < row; j++) {
        //第j行
        if (grid[j][i] == 1) {
          //递增
          lists[i].add(j);
        }
      }
    }
    //[i][j]: 第i列但是不包括第j行的1的数量
    int[][] lineCnts = new int[line][row];
    for (int i = 0; i < line; i++) {
      //第i列所有的1的集合
      HashSet<Integer> set = lists[i];
      for (int j = 0; j < row; j++) {
        lineCnts[i][j] = set.size();
        if (set.contains(j)) {
          lineCnts[i][j] -= 1;
        }
      }
    }
    //遍历grid
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < line; j++) {
        //第一个点[i, j]
        if (grid[i][j] == 1) {
          //往后遍历下一个为1的点
          for (int k = j + 1; k < line; k++) {
            if (grid[i][k] == 1) {
              //此时第j, k 两列上的1都能构成直角三角形
              cnts += lineCnts[j][i];
              cnts += lineCnts[k][i];
            }
          }
        }
      }
    }
    return cnts;
  }
}
