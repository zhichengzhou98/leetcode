package com.topic.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/** 3283
 * @author zc.zhou
 * @Description 从起点到终点的最小移到次数。 移到方向为象棋中马的移到方向。 n, m为棋盘边界
 * @create 2024-09-09 11:19
 */
public class MinSteps {

  @Test
  void testFun() {
    int[] start = {0, 0};
    int[] end = {49, 48};
    System.out.println(minStep(start, end));
  }

  int m = 49;
  int n = 49;

  public int minStep(int[] start, int[] end) {
    boolean[][] isVisited = new boolean[m + 1][n + 1];
    //当前移到步数
    int cur = 0;
    Queue<int[]> q = new ArrayDeque<>();

    //移到的方向
    int[][] dirs = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2},
        {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};

    q.offer(start);
    isVisited[start[0]][start[1]] = true;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] currentPos = q.poll();
        int curPosX = currentPos[0];
        int curPosY = currentPos[1];
        if (curPosX == end[0] && curPosY == end[1]) {
          //到达终点
          return cur;
        }
        //currentPos下一次的方向
        for (int[] dis : dirs) {
          int nextX = curPosX + dis[0];
          int nextY = curPosY + dis[1];
          if (nextX >= 0 && nextX <= m && nextY >= 0 && nextY <= n && !isVisited[nextX][nextY]) {
            isVisited[nextX][nextY] = true;
            q.offer(new int[]{nextX, nextY});
          }
        }
      }
      cur++;
    }
    return cur;
  }
}
