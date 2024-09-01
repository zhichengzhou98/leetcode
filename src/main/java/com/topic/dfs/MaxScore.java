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
 * @Description 状压DP
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
    Set<Integer> set = new HashSet<>();
    map = new HashMap<>();
    return dfsV2(grid, 0, set);
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
