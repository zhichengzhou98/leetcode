package com.topic.baoli;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 997. 找到小镇的法官
 * @create 2024-09-22 07:56
 */
public class FindJudge {
  public int findJudge(int n, int[][] trust) {
    //统计节点的入度 出度
    int[] inDegree = new int[n +1];
    int[] outDegree = new int[n +1];

    for (int[] arr : trust) {
      outDegree[arr[0]]++;
      inDegree[arr[1]]++;
    }
    //法官的入度为n-1 出度为0
    for (int i = 1; i < inDegree.length; i++) {
      if (inDegree[i] == n - 1 && outDegree[i] == 0) {
        return i;
      }
    }
    return -1;
  }

  public int findJudgeV1(int n, int[][] trust) {
    Map<Integer, Set<Integer>> trustMap = new HashMap<>();
    int sum = 0;
    for (int[] arr : trust) {
      if (trustMap.containsKey(arr[0])) {
        trustMap.get(arr[0]).add(arr[1]);
      } else {
        sum += arr[0];
        Set<Integer> set = new HashSet<>();
        set.add(arr[1]);
        trustMap.put(arr[0], set);
      }
    }
    if (trustMap.keySet().size() != n - 1) {
      return -1;
    }
    int judge = (1 + n) * n / 2 - sum;
    for (Map.Entry<Integer, Set<Integer>> entry : trustMap.entrySet()) {
      if (!entry.getValue().contains(judge)) {
        return -1;
      }
    }
    return judge;
  }
}
