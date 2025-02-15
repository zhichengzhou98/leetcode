package com.topic.baoli;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1706. 球会落何处 注意行和列别搞反了
 * @create 2025-02-15 10:10
 */
public class FindBall {
  @Test
  void testFun() throws IOException {
    int[][] array = ArrayUtils.generate("array", int[][].class);
    System.out.println(Arrays.toString(findBall(array)));
  }

  public int[] findBall(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int curI = i;
      boolean flag = false;
      // 第 i 个球， 从第0行开始
      for (int j = 0; j < m; j++) {
        // 当前位置为 j, curI
        int cur = grid[j][curI];
        if (cur == 1) {
          // 向右 判断右边挡板
          if (curI + 1 >= n || grid[j][curI + 1] == -1) {
            // 第i个球不能往下
            res[i] = -1;
            flag = true;
            break;
          } else {
            // 往右
            curI++;
          }
        } else {
          // 往左 判断左边挡板
          if (curI - 1 < 0 || grid[j][curI - 1] == 1) {
            // 第i个球不能往下
            res[i] = -1;
            flag = true;
            break;
          } else {
            // 往右
            curI--;
          }
        }
      }
      if (!flag) {
        res[i] = curI;
      }

    }
    return res;
  }
}
