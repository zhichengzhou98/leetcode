package com.topic.dp;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 1884. 鸡蛋掉落-两枚鸡蛋
 * @create 2024-10-13 16:43
 */
public class TwoEggDrop {
  @Test
  void testFun() {
    System.out.println(twoEggDrop(2));
  }
  //o(n²)
  public int twoEggDrop(int n) {
    //dp[i][j]: 表示楼层0-i 需要判断的次数
    //j==0: 使用一个鸡蛋 j==1: 使用两个鸡蛋
    //使用一个鸡蛋时，只能从低楼层依次往高楼层尝试 故dp[i][1] = i
    int[][] dp = new int[n + 1][2];
    dp[1][0] = 1;
    dp[1][1] = 1;
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = i;
      dp[i][1] = Integer.MAX_VALUE;
      //考虑第一个鸡蛋选择从哪一个楼层开始
      //从j楼扔下
      //如果鸡蛋未碎， 需要检查[j + 1, i]楼层，还剩两个鸡蛋
      //鸡蛋碎了，需要检查[0, j-1]楼层，还剩1个鸡蛋
      for (int j = 1; j <= i; j++) {
        dp[i][1] = Math.min(dp[i][1],Math.max(
            1 + dp[j-1][0], 1 + dp[i-j][1]
        ));
      }
    }
    return dp[n][1];
  }
}
