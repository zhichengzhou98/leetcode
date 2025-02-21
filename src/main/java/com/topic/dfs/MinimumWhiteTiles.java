package com.topic.dfs;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2209. 用地毯覆盖后的最少白色砖块
 * @create 2025-02-21 20:02
 */
public class MinimumWhiteTiles {
  String floor;
  int carpetLen;

  // 0: 黑色 1: 白色
  public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
    this.floor = floor;
    this.carpetLen = carpetLen;
    int len = floor.length();
    int[][] memo = new int[numCarpets + 1][len];
    // 当地毯数为0时
    for (int i = 0; i < len; i++) {
      char curChar = floor.charAt(i);
      if (i == 0) {
        if (curChar == '1') {
          memo[0][i] = 1;
        } else {
          memo[0][i] = 0;
        }
      } else {
        if (curChar == '1') {
          memo[0][i] = memo[0][i - 1] + 1;
        } else {
          memo[0][i] = memo[0][i - 1];
        }
      }
    }
    for (int i = 1; i < numCarpets + 1; i++) {
      Arrays.fill(memo[i], -1);
    }
    return dfs(numCarpets, len - 1, memo);

  }

  /**
   * @param numCarpets 剩余的地毯数
   * @param curIndex   覆盖的当前位置
   * @param memo       缓存
   * @return [0, curIndex]没有被覆盖的数目
   */
  private int dfs(int numCarpets, int curIndex, int[][] memo) {
    if (curIndex < 0) {
      return 0;
    }
    if (memo[numCarpets][curIndex] != -1) {
      return memo[numCarpets][curIndex];
    }
    // 当前位置覆盖 [curIndex - carpetLen + 1 ,curIndex] 都被覆盖
    int res = dfs(numCarpets - 1, curIndex - carpetLen, memo);

    // 当前位置不覆盖
    int tmp = dfs(numCarpets, curIndex - 1, memo);
    // 判断当前位置是否为白色(1)
    if (floor.charAt(curIndex) == '1') {
      tmp = tmp + 1;
    }
    res = Math.min(res, tmp);
    memo[numCarpets][curIndex] = res;
    return res;
  }
}
