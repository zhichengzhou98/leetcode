package com.topic.baoli;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 1338. 数组大小减半
 * @create 2024-12-15 19:08
 */
public class MinSetSize {
  public int minSetSize(int[] arr) {
    // 统计每个数出现的次数
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int size = arr.length;
    int cnt = 0;
    int res = 0;
    List<Integer> list =
        map.values().stream().sorted(Comparator.comparingInt(x -> -x)).toList();
    for (Integer integer : list) {
      res++;
      cnt += integer;
      if (cnt >= size / 2) {
        return res;
      }
    }
    return res;
  }
}
