package com.topic.baoli;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 2940. 找到 Alice 和 Bob 可以相遇的建筑
 * @create 2024-08-10 15:54
 */
public class LeftmostBuildingQueries {
  @Test
  void testFun() throws IOException {
    int[][] q = ArrayUtils.generate("array", int[][].class);
    int[] h = {437992900, 321950464, 955829263, 119824723, 720294563, 725847098};
    System.out.println(Arrays.toString(leftmostBuildingQueries(h, q)));
  }

  Map<String, Integer> map;
  //单调栈
  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    map = new HashMap<>();
    int[] res = new int[queries.length];
    //记录原来每个queries的索引
    int[][] newQueries = new int[queries.length][3];
    for (int i = 0; i < queries.length; i++) {
      //查询（0， 3）和（3， 0）结果一样 不妨按位置升序排列
      int max = Math.max(queries[i][1], queries[i][0]);
      int min = Math.min(queries[i][1], queries[i][0]);
      newQueries[i] = new int[]{max, min, i};
    }
    //将newQueries排序，先按左边索引降序，再按右边索引降序
    Arrays.sort(newQueries, (a, b) -> {
      if (a[0] == b[0]) {
        return b[1] - a[1];
      }
      return b[0] - a[0];
    });
    //单调栈 + 二分法
    int lastIndex = heights.length - 1;
    //0: 高度 1: index
    LinkedList<int[]> stack = new LinkedList<>();
    for (int[] query : newQueries) {
      //a >= b
      int a = query[0];
      int b = query[1];
      int index = query[2];
      String key = a + "," + b;
      if (map.containsKey(key)) {
        res[index] = map.get(key);
        continue;
      }
      //初始化
      res[index] = -1;
      //更新栈 倒着放
      //把a + 1， lastIndex位置的高度放入单调递减栈
      for (int j = lastIndex; j >= a + 1; j--) {
        int[] node = new int[]{heights[j], j};
        while (!stack.isEmpty() && stack.peek()[0] < heights[j]) {
          stack.poll();
        }
        stack.offerFirst(node);
      }
      lastIndex = a;
      if (a == b || heights[a] > heights[b]) {
        //在右边的高建筑相遇 a > b
        res[index] = a;
        map.put(key, res[index]);
        continue;
      }
      int maxHeight = Math.max(heights[a], heights[b]);
      if (stack.isEmpty()) {
        map.put(key, res[index]);
        continue;
      }
      //找到stack中大于maxHeight的最小值  -> 寻找左边界
      //检查右端点
      if (maxHeight >= stack.getLast()[0]) {
        //没有满足的
        map.put(key, res[index]);
        continue;
      }
      //二分
      res[index] = leftBoundary(stack, maxHeight);
      map.put(key, res[index]);
    }
    return res;
  }

  public int leftBoundary(LinkedList<int[]> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (nums.get(med)[0] > target) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return nums.get(med)[1];
  }

  //暴力 o(n²)
  public int[] leftmostBuildingQueriesV1(int[] heights, int[][] queries) {
    int[] res = new int[queries.length];
    Arrays.fill(res, -1);
    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];
      int maxIndex = Math.max(a, b);
      int minIndex = Math.min(a, b);
      int maxHeight = Math.max(heights[a], heights[b]);
      if (a == b) {
        //最高点在右边  直接在右边相遇 ×
        //1 2 1 2  -> 0, 1
        //
        res[i] = b;
        continue;
      }
      if (maxHeight > heights[minIndex]) {
        //在右边的搞建筑相遇
        res[i] = maxIndex;
        continue;
      }
      for (int j = maxIndex + 1; j < heights.length; j++) {
        if (heights[j] > maxHeight) {
          res[i] = j;
          break;
        }
      }
    }
    return res;
  }
}

