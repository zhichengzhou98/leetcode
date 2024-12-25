package com.topic.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 3218. 切蛋糕的最小总开销 I 贪心
 * @create 2024-12-25 20:22
 */
public class MinimumCost {
  public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
    // 行切了多少下
    int rowCnt = 0;
    // 列切了多少下
    int columnCnt = 0;
    // 行需要切的队列 单调递减
    Queue<Integer> rowQueue = new PriorityQueue<>((a, b) -> b - a);
    for(int h : horizontalCut) {
      rowQueue.offer(h);
    }
    Queue<Integer> columnQueue = new PriorityQueue<>((a, b) -> b - a);
    for(int v : verticalCut) {
      columnQueue.offer(v);
    }
    int res = 0;
    while (!rowQueue.isEmpty() && !columnQueue.isEmpty()) {
      Integer row = rowQueue.peek();
      Integer col = columnQueue.peek();
      if (row >= col) {
        // 先切行
        res += (columnCnt + 1) * row;
        rowCnt++;
        rowQueue.poll();
      }else {
        res += (rowCnt + 1) * col;
        columnCnt++;
        columnQueue.poll();
      }
    }
    while (!columnQueue.isEmpty()) {
      Integer col = columnQueue.poll();
      res += (rowCnt + 1) * col;
      columnCnt++;
    }
    while (!rowQueue.isEmpty()) {
      Integer row = rowQueue.poll();
      res += (columnCnt + 1) * row;
      rowCnt++;
    }
    return res;
  }

  // 3219. 切蛋糕的最小总开销 II
  public long minimumCostV1(int m, int n, int[] horizontalCut, int[] verticalCut) {
    // 行切了多少下
    int rowCnt = 0;
    // 列切了多少下
    int columnCnt = 0;
    // 行需要切的队列 单调递减
    Queue<Integer> rowQueue = new PriorityQueue<>((a, b) -> b - a);
    for(int h : horizontalCut) {
      rowQueue.offer(h);
    }
    Queue<Integer> columnQueue = new PriorityQueue<>((a, b) -> b - a);
    for(int v : verticalCut) {
      columnQueue.offer(v);
    }
    long res = 0;
    while (!rowQueue.isEmpty() && !columnQueue.isEmpty()) {
      Integer row = rowQueue.peek();
      Integer col = columnQueue.peek();
      if (row >= col) {
        // 先切行
        res += (columnCnt + 1L) * row;
        rowCnt++;
        rowQueue.poll();
      }else {
        res += (rowCnt + 1L) * col;
        columnCnt++;
        columnQueue.poll();
      }
    }
    while (!columnQueue.isEmpty()) {
      Integer col = columnQueue.poll();
      res += (rowCnt + 1L) * col;
      columnCnt++;
    }
    while (!rowQueue.isEmpty()) {
      Integer row = rowQueue.poll();
      res += (columnCnt + 1L) * row;
      rowCnt++;
    }
    return res;
  }
}
