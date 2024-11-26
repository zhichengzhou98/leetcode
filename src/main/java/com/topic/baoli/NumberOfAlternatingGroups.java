package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3206 交替组 I o(3*n)
 * @create 2024-11-26 8:42
 */
public class NumberOfAlternatingGroups {
  public int numberOfAlternatingGroups(int[] colors) {
    int res = 0;
    int size = colors.length;
    // 遍历
    for (int i = 0; i < size; i++) {
      if (colors[i] == colors[(i + 2) % size] && colors[i] != colors[(i + 1) % size]) {
        res++;
      }
    }
    return res;
  }
}
