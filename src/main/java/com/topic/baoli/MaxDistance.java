package com.topic.baoli;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 624. 数组列表中的最大距离
 * @create 2025-02-19 20:33
 */
public class MaxDistance {
  @Test
  void testFun() throws IOException {
    List<List<Integer>> array = ArrayUtils.generate("array", List.class, List.class, Integer.class);
    System.out.println(maxDistance(array));
  }

  public int maxDistance(List<List<Integer>> arrays) {
    // 0: 最大值 1: 次大值 2: 最大值索引 3: 次大值索引
    int[] max = new int[4];
    int[] min = new int[4];
    List<Integer> list0 = arrays.get(0);
    int size0 = list0.size();
    List<Integer> list1 = arrays.get(1);
    int size1 = list1.size();
    if (list0.get(size0 - 1) > list1.get(size1 - 1)) {
      max[0] = list0.get(size0 - 1);
      max[2] = 0;
      max[1] = list1.get(size1 - 1);
      max[3] = 1;
    } else {
      max[1] = list0.get(size0 - 1);
      max[3] = 0;
      max[0] = list1.get(size1 - 1);
      max[2] = 1;
    }
    int min0 = list0.get(0);
    int min1 = list1.get(0);
    if (min0 < min1) {
      min[0] = min0;
      min[1] = min1;
      min[2] = 0;
      min[3] = 1;
    } else {
      min[1] = min0;
      min[0] = min1;
      min[3] = 0;
      min[2] = 1;
    }
    for (int i = 2; i < arrays.size(); i++) {
      List<Integer> list = arrays.get(i);
      Integer first = list.get(0);
      Integer last = list.get(list.size() - 1);
      if (last > max[0]) {
        max[1] = max[0];
        max[3] = max[2];
        max[0] = last;
        max[2] = i;
      } else if (last > max[1]) {
        max[1] = last;
        max[3] = i;
      }
      if (first < min[0]) {
        min[1] = min[0];
        min[3] = min[2];
        min[0] = first;
        min[2] = i;
      } else if (first < min[1]) {
        min[1] = first;
        min[3] = i;
      }
    }
    if (min[2] != max[2]) {
      return max[0] - min[0];
    }
    return Math.max(max[0] - min[1], max[1] - min[0]);
  }
}
