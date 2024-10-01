package com.topic.dp.zhuangya;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 3283
 * @create 2024-09-09 13:25
 */
public class MaxMoves {

  @Test
  void testFun() {
    int[][] p = {{1, 2}, {2, 4}};
    System.out.println(maxMoves(0, 0, p));
  }

  public int maxMoves(int kx, int ky, int[][] positions) {
    //把起点当成最后一个元素， 起点的索引为 len
    int len = positions.length;
    this.len = len;
    //1 -> 2, 2 -> 3
    maxJ = (1 << len) - 1;
    //统计任意两个点需要跳跃的次数
    map = new HashMap<>();
    for (int i = 0; i <= len; i++) {
      for (int j = 0; j <= len; j++) {
        String key1 = i + "," + j;
        String key2 = j + "," + i;
        int[] s;
        int[] e;
        if (i == len) {
          s = new int[]{kx, ky};
        } else {
          s = positions[i];
        }
        if (j == len) {
          e = new int[]{kx, ky};
        } else {
          e = positions[j];
        }
        int steps = minStep(s, e);
        map.put(key1, steps);
        map.put(key2, steps);
      }
    }
    int[][] memo = new int[1 << len][len + 1];
    for (int[] arr : memo) {
      Arrays.fill(arr, -1);
    }
    return dfsV1(0, 1, len, memo);
  }

  int maxJ;

  /**
   * @param j    已经走过的位置的2进制表示
   * @param flag 1 -> a回合 0 -> b回合
   * @param cur  当前位置，表示索引
   * @return
   */
  private int dfsV1(int j, int flag, int cur, int[][] memo) {
    if (j == maxJ) {
      return 0;
    }
    if (memo[j][cur] != -1) {
      return memo[j][cur];
    }
    int res = flag == 1 ? 0 : Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      if ((j & (1 << i)) == 0) {
        String key = cur + "," + i;
        int curStep = map.get(key);
        if (flag == 1) {
          //a的回合 求最大值
          res = Math.max(res, curStep + dfsV1(j | (1 << i), 0, i, memo));
        } else {
          //b的回合 求最小值
          res = Math.min(res, curStep + dfsV1(j | (1 << i), 1, i, memo));
        }
      }
    }
    memo[j][cur] = res;
    return res;
  }

  /**
   * @param n    表示positions中还剩多少个位置没有走到
   * @param j    已经走过的位置的2进制表示
   * @param flag 1 -> a回合 0 -> b回合
   * @param cur  当前位置，表示索引
   * @return
   */
  private int dfs(int n, int j, int flag, int cur, int[][][] memo) {
    if (n == 0) {
      return 0;
    }
    if (memo[n][j][cur] != -1) {
      return memo[n][j][cur];
    }
    int res = flag == 1 ? 0 : Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      if ((j & (1 << i)) == 0) {
        String key = cur + "," + i;
        int curStep = map.get(key);
        if (flag == 1) {
          //a的回合 求最大值
          res = Math.max(res, curStep + dfs(n - 1, j | (1 << i), 0, i, memo));
        } else {
          //b的回合 求最小值
          res = Math.min(res, curStep + dfs(n - 1, j | (1 << i), 1, i, memo));
        }
      }
    }
    memo[n][j][cur] = res;
    return res;
  }

  int m = 49;
  int n = 49;
  Map<String, Integer> map;
  int len;

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
