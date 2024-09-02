package com.topic.dp.zhuangya;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3276状压DP 时间复杂度
 * @create 2024-09-01 11:27
 */
public class MaxScore {
  @Test
  void testFun() throws IOException {
    List<List<Integer>> grid1 = ArrayUtils.generate("array1", List.class, List.class,
        Integer.class);
    System.out.println(maxScore(grid1));
  }

  //状压dp
  public int maxScore(List<List<Integer>> grid) {
    //grid中最大值
    int maxVal = Integer.MIN_VALUE;
    //grid中val出现得行号：如果 1 在 1 3 5 行出现 -> map值为：10101
    Map<Integer, Integer> valLineMap = new HashMap<>();
    int m = grid.size();
    int n = grid.get(0).size();
    for (int i = 0; i < m; i++) {
      // 第m行
      for (int j = 0; j < n; j++) {
        int key = grid.get(i).get(j);
        maxVal = Math.max(key, maxVal);
        Integer value = valLineMap.getOrDefault(key, 0);
        valLineMap.put(key, value | (1 << (i)));
      }
    }
    int[][] memo = new int[101][1 << m];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }
    return dfsV1(maxVal, 0, memo, valLineMap);
  }

  /**
   * 时间复杂度 i * j * while次数
   * m * n * 2^m * m
   * @param i    表示从[1...i]这些数当中选
   * @param j    表示已经选过的行数 j 从 0 到 2^10 - 1
   * @param memo
   * @param map  数值i出现的行数
   * @return 最大值
   */
  private int dfsV1(int i, int j, int[][] memo, Map<Integer, Integer> map) {
    if (i <= 0) {
      return 0;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    //不选i
    int res = dfsV1(i - 1, j, memo, map);
    //选i
    Integer i1 = map.get(i);
    int currentRow = 0;
    while (i1 != null && i1 >= 1) {
      //判断该选哪一行的i
      //j & (1 << currentRow)) != (1 << currentRow) <=> j & (1 << currentRow)) == 0
      if (i1 % 2 == 1 && (j & (1 << currentRow)) == 0) {
        //不包含
        int tempJ = j | (1 << currentRow);
        res = Math.max(res, i + dfsV1(i - 1, tempJ, memo, map));
      }
      i1 /= 2;
      currentRow++;
    }
    memo[i][j] = res;
    return res;
  }


  Map<String, Integer> map;

  public int maxScoreV1(List<List<Integer>> grid) {
    long start = System.currentTimeMillis();
    Set<Integer> set = new HashSet<>();
    map = new HashMap<>();
    int sum = dfs(grid, 0, set, "");
    System.out.println(System.currentTimeMillis() - start);
    return sum;
  }

  /**
   * <p>100 99 98 97 96
   * <p>90 89 88 87 86
   * <p>80 79 78 77 76
   * <p>70 69 68 67 66
   * <p>60 59 58 57 56
   * <p>回溯法：n^m
   * <p>如果每个值都不一样 map并没有起到优化作用
   *
   * @param grid
   * @param row
   * @param set
   * @param str  表示选中的数的位置 选中第0行第0个 -> 1, 同时选择第一行第1个 -> 2,1,
   * @return
   */
  private int dfs(List<List<Integer>> grid, int row, Set<Integer> set, String str) {
    String key = row + "," + str;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (row >= grid.size()) {
      return 0;
    }
    int res = 0;
    for (int col = 0; col < grid.get(row).size(); col++) {
      int value = grid.get(row).get(col);
      if (!set.contains(value)) {
        set.add(value);
        //更新str
        res = Math.max(res, value + dfs(grid, row + 1, set, (value + 1) + "," + str));
        set.remove(value);
      }
    }
    res = Math.max(res, dfs(grid, row + 1, set, 0 + "," + str));
    map.put(key, res);
    return res;
  }
}
