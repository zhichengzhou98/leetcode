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


  public int minFlips(int[][] grid) {
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

