package com.topic.dfs;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-17 22:43
 */
public class MaximumValueSum {
  List<Long> res;
  @Test
  void testFun() throws IOException {
    int[][] g = ArrayUtils.generate("array", int[][].class);
    System.out.println(maximumValueSum(g));
  }

  public long maximumValueSum(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    long maxSum = Long.MIN_VALUE;

    //枚举第一辆车的位置
    for (int i1 = 0; i1 < m; i1++) {
      for (int j1 = 0; j1 < n; j1++) {
        Queue<int[]> pq = generate(board);
        //第二辆车的位置

        while (pq.peek()[0] == i1 || pq.peek()[1] == j1) {
          pq.poll();
        }
        int[] point2 = pq.poll();
        int maxI2 = point2[0];
        int maxJ2 = point2[1];
        long secondMax = board[maxI2][maxJ2];
        //第二辆车 第二大的位置
        while (pq.peek()[0] == i1 || pq.peek()[1] == j1) {
          pq.poll();
        }
        int[] point2_2 = pq.poll();
        int secI2 = point2_2[0];
        int secJ2 = point2_2[1];
        long secondMax2 = board[secI2][secJ2];
        //第三两车
        while (pq.peek()[0] == i1 || pq.peek()[1] == j1) {
          pq.poll();
        }
        boolean f1 = false;
        boolean f2 = false;
        int[] point3 = new int[2];
        int[] point3_2 = new int[2];
        if (secI2 != maxI2 && secJ2 != maxJ2) {
          point3 = new int[]{secI2, secJ2};
          point3_2 = new int[]{maxI2, maxJ2};
        }
        while (true) {
          while (!pq.isEmpty() && (pq.peek()[0] == i1 || pq.peek()[1] == j1)) {
            pq.poll();
          }
          if (pq.isEmpty()) {
            break;
          }
          int[] current = pq.peek();
          if (!f1 && current[0] != maxI2 && current[1] != maxJ2) {
            f1 = true;
            point3 = current;
          }
          if (!f2 && current[0] != secI2 && current[1] != secJ2) {
            f2 = true;
            point3_2 = current;
          }
          if (f1 && f2) {
            break;
          } else {
            pq.poll();
          }
        }
        long temp = Math.max(secondMax + board[point3[0]][point3[1]],
            secondMax2 +board[point3_2[0]][point3_2[1]] );
        long sum = board[i1][j1] + temp;
        maxSum = Math.max(maxSum, sum);
        System.out.println(maxSum);
      }
    }
    return maxSum;
  }

  public Queue<int[]> generate(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> board[b[0]][b[1]] -board[a[0]][a[1]]);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        pq.offer(new int[]{i, j});
      }
    }
    return pq;
  }
}
