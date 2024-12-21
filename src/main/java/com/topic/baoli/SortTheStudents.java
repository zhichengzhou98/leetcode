package com.topic.baoli;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2545. 根据第 K 场考试的分数排序 自定义排序
 * @create 2024-12-21 17:43
 */
public class SortTheStudents {
  public int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (a, b)-> b[k] - a[k]);
    return score;
  }
}
