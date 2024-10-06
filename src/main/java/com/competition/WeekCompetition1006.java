package com.competition;

import com.zzc.utils.MathUtils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-06 10:23
 */
public class WeekCompetition1006 {
  @Test
  void testFun() {
    String s = Integer.toBinaryString(127);
    long l = MathUtils.parseBinaryStrTo10("111111111111111111111");
    System.out.println(l);
    //System.out.println("111111111111111111111");
  }

  public int[][] constructGridLayout(int n, int[][] edges) {
    //建图
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
    }
    //只有一条边的节点个数
    List<Integer> list1 = new ArrayList<>();
    //有两条边的节点个数
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> list4 = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      if (graph[i].size() == 1) {
        list1.add(i);
      } else if (graph[i].size() == 2) {
        list2.add(i);
      } else if (graph[i].size() == 3) {
        list3.add(i);
      } else {
        list4.add(i);
      }
    }
    int[][] res;
    if (list1.size() == 2) {
      //二维数组为 1 * n
      res = new int[1][n];
      int[] tmp = res[0];
      tmp[0] = list1.get(0);
      tmp[n - 1] = list1.get(1);
      int preNode = tmp[0];
      for (int i = 1; i < n - 1; i++) {
        List<Integer> next = graph[preNode];
        for(int node : next) {
          if (node != preNode) {
            tmp[i] = node;
            break;
          }
        }
      }
    }

    return new int[0][0];
  }

  public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] invocation : invocations) {
      graph[invocation[0]].add(invocation[1]);
    }

    //可疑的方法
    Set<Integer> keyi = new HashSet<>();
    boolean[] visited = new boolean[n];
    dfs(k, graph, visited, keyi);
    List<Integer> result = new ArrayList<>();
    for (int[] i : invocations) {
      //调用方
      int invoke = i[0];
      //被调用方
      int invoked = i[1];
      if (keyi.contains(invoked) && !keyi.contains(invoke)) {
        //不能移除
        for (int j = 0; j < n; j++) {
          result.add(j);
        }
        return result;
      }
    }
    for (int i = 0; i < n; i++) {
      if (!keyi.contains(i)) {
        result.add(i);
      }
    }
    return result;
  }

  private void dfs(int method, List<Integer>[] graph, boolean[] visited, Set<Integer> set) {
    visited[method] = true;
    set.add(method);
    for (int next : graph[method]) {
      if (!visited[next]) {
        dfs(next, graph, visited, set);
      }
    }
  }

  public int maxGoodNumber(int[] nums) {
    int max = Integer.MIN_VALUE;
    max = Math.max(generate(nums), max);
    max = Math.max(generate(new int[]{nums[0], nums[2], nums[1]}), max);
    max = Math.max(generate(new int[]{nums[1], nums[2], nums[0]}), max);
    max = Math.max(generate(new int[]{nums[1], nums[0], nums[2]}), max);
    max = Math.max(generate(new int[]{nums[2], nums[0], nums[1]}), max);
    max = Math.max(generate(new int[]{nums[2], nums[1], nums[0]}), max);
    return max;
  }

  private int generate(int[] nums) {
    StringBuilder sb = new StringBuilder();
    for (int num : nums) {
      sb.append(Integer.toBinaryString(num));
    }
    return Integer.parseInt(sb.toString(), 2);
  }
}
