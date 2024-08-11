package com.competition;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-03 22:27
 */
public class WeekCompetition0803 {
  @Test
  void testFun() throws IOException {
    int[][] pick = ArrayUtils.generate("array", int[][].class);
    System.out.println(minFlips(pick));
  }


  public int minFlips(int[][] grid) {
    int m = grid.length;//行
    int n = grid[0].length;
    int res = 0;
    boolean flag2 = false;
    //可以增加1的数量
    boolean flag1 = false;
    for (int i = 0; i < m / 2; i++) {
      //第i行
      int left = 0;//[i , left]
      int right = grid[0].length - 1;//[i, right]
      //
      int line = m - i - 1; //[m - i - 1, left]
      //[n - i - 1, right]
      int p1 = grid[i][left];
      int p2 = grid[i][right];
      int p3 = grid[line][left];
      int p4 = grid[line][right];
      int sum = p1 + p2 + p3 + p4;
      if (sum == 0 || sum == 4) {
        //已经满足
      } else if (sum == 1) {
        //把为1的点改为0
        grid[i][left] = 0;
        grid[i][right] = 0;
        grid[line][left] = 0;
        grid[line][right] = 0;
        res++;
      } else if (sum == 2) {
        //把两个1改成0
        grid[i][left] = 0;
        grid[i][right] = 0;
        grid[line][left] = 0;
        grid[line][right] = 0;
        if (i == line || left == right) {
          res += 1;
          flag1 = true;
          continue;
        }
        flag2 = true;
        res += 2;
      } else if (sum == 3) {
        //把1个0改成1
        grid[i][left] = 1;
        grid[i][right] = 1;
        grid[line][left] = 1;
        grid[line][right] = 1;
        res++;
      }
    }
    int ones = countOne(grid);
    if (ones % 4 == 0) {
      return res;
    } else if (ones % 4 == 1) {
      //多了一个1
      return res + 1;
    } else if (ones % 4 == 2) {
      //多了两个1
      if (flag1) {
        return res;
      }
      return res + 2;
    }
    //多了3个1
    if (flag2) {
      return res + 1;
    }
    if (m % 2 == 1) {
      //检查中间一行有没有0
      for (int i = 0; i < grid[0].length; i++) {
        if (grid[m / 2][i] == 0) {
          return res + 1;
        }
      }
    }
    if (n % 2 == 1) {
      for (int[] ints : grid) {
        if (ints[n / 2] == 0) {
          return res + 1;
        }
      }
    }
    return res + 3;
  }

  //统计1的个数
  private int countOne(int[][] grid) {
    int res = 0;
    for (int[] ints : grid) {
      for (int j : ints) {
        if (j == 1) {
          res++;
        }
      }
    }
    return res;
  }


  public int minFlipsV1(int[][] grid) {
    int res1 = 0;
    //按行统计
    for (int i = 0; i < grid.length; i++) {
      int left = 0;
      int right = grid[0].length - 1;
      while (right > left) {
        if (grid[i][left] != grid[i][right]) {
          res1++;
        }
        right--;
        left++;
      }
    }
    if (res1 == 0) {
      return res1;
    }
    //按列统计
    int res2 = 0;
    for (int i = 0; i < grid[0].length; i++) {
      int left = 0;
      int right = grid.length - 1;
      while (right > left) {
        if (grid[left][i] != grid[right][i]) {
          res2++;
        }
        left++;
        right--;
      }
    }
    return Math.min(res2, res1);
  }


  public int winningPlayerCount(int n, int[][] pick) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int i = 0; i < pick.length; i++) {
      int person = pick[i][0];
      int ball = pick[i][1];
      if (map.containsKey(person)) {
        Map<Integer, Integer> integerMap = map.get(person);
        if (integerMap == null) {
          integerMap = new HashMap<>();
          integerMap.put(ball, 1);
        } else if (integerMap.containsKey(ball)) {
          integerMap.put(ball, integerMap.get(ball) + 1);
        } else {
          integerMap.put(ball, 1);
        }
      } else {
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(ball, 1);
        map.put(person, temp);
      }
    }
    return (int) map.entrySet().stream().filter(e -> {
      Integer p = e.getKey();
      Map<Integer, Integer> value = e.getValue();
      return value.values().stream().max(Integer::compareTo).get() >= p + 1;
    }).count();
  }
}

