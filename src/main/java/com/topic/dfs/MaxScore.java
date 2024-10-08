package com.topic.dfs;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
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
    //System.out.println(1 << 10);
    System.out.println(maxScore(grid1));
  }

  private int sum = 0;
  Map<String, Integer> map;
  public int maxScore(List<List<Integer>> grid) {
    long start = System.currentTimeMillis();
    Set<Integer> set = new HashSet<>();
    map = new HashMap<>();
    //sum = dfsV3(grid, 0, set, "");

    //return dfsV2(grid, 0, set);
    dfs(grid, 0, 0, set);
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
   * @param grid
   * @param row
   * @param set
   * @param str 表示选中的数的位置 选中第0行第0个 -> 1, 同时选择第一行第1个 -> 2,1,
   * @return
   */
  private int dfsV3(List<List<Integer>> grid, int row, Set<Integer> set, String str) {
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
        res = Math.max(res, value + dfsV3(grid, row + 1, set, (value + 1) + "," + str));
        set.remove(value);
      }
    }
    res = Math.max(res, dfsV3(grid, row + 1, set, 0 + "," + str));
    map.put(key, res);
    return res;
  }

  private int dfsV2(List<List<Integer>> grid, int row, Set<Integer> set) {
    List<Integer> list = set.stream().sorted().toList();
    StringBuilder sb = new StringBuilder(String.valueOf(row));
    for (Integer integer : list) {
      sb.append(",").append(integer);
    }
    String key = sb.toString();
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
        res = Math.max(res, value + dfsV2(grid, row + 1, set));
        set.remove(value);
      }
    }
    res = Math.max(res, dfsV2(grid, row + 1, set));
    map.put(key, res);
    return res;
  }

  private void dfs(List<List<Integer>> grid, int row, int current, Set<Integer> set) {
    List<String> list = set.stream().sorted().map(String::valueOf).toList();
    String str = String.join( ",",list);
    int max = Integer.MIN_VALUE;
    String key = row +"," + current + "," + str;
    if (row >= grid.size()) {
      sum = Math.max(current, sum);
      return;
    }
    for (int col = 0; col < grid.get(row).size(); col++) {
      int value = grid.get(row).get(col);
      if (!set.contains(value)) {
        current += value;
        set.add(value);
        //递归
        dfs(grid, row + 1, current, set);
        sum = Math.max(current, sum);
        //回溯
        set.remove(value);
        current -= value;
      }
    }
    dfs(grid, row + 1,current, set);
    sum = Math.max(current, sum);
  }
}
