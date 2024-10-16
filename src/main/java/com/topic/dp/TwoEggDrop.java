package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1884. 鸡蛋掉落-两枚鸡蛋
 * 887鸡蛋掉落
 * @create 2024-10-13 16:43
 */
public class TwoEggDrop {
  @Test
  void testFun() {
    System.out.println(twoEggDrop(1000));
    System.out.println(superEggDrop(2, 1000));
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
        dp[i][1] = Math.min(dp[i][1], Math.max(
            1 + dp[j - 1][0], 1 + dp[i - j][1]
        ));
      }
    }
    return dp[n][1];
  }

  //o(k*n²)
  public int superEggDropV1(int k, int n) {
    //dp[i][j]: 表示楼层0-i 需要判断的次数
    //j: 表示使用第j + 1个鸡蛋
    //使用一个鸡蛋时，只能从低楼层依次往高楼层尝试 故dp[i][1] = i
    int[][] dp = new int[n + 1][k];
    Arrays.fill(dp[1], 1);
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = i;
      for (int j = 1; j < k; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        //考虑第(j)个鸡蛋(索引j-1)选择从哪一个楼层开始
        //从m楼扔下
        //如果鸡蛋未碎， 需要检查[m + 1, i]楼层，还剩j个鸡蛋
        //鸡蛋碎了，需要检查[0, m-1]楼层，还剩j-1个鸡蛋
        for (int m = 1; m <= i; m++) {
          dp[i][j] = Math.min(dp[i][j], Math.max(
              //TODO: dp[m-1][j-1]随m增大而增大 dp[i-m][j]随m增大而减小
              //求V字形数据的最小值
              //162 寻找峰值
              1 + dp[m - 1][j - 1], 1 + dp[i - m][j]
          ));
        }
      }
    }
    return dp[n][k - 1];
  }

  //o(k*n*logn) 答案错误
  public int superEggDrop(int k, int n) {
    //dp[i][j]: 表示楼层0-i 需要判断的次数
    //j: 表示使用第j + 1个鸡蛋
    //使用一个鸡蛋时，只能从低楼层依次往高楼层尝试 故dp[i][1] = i
    int[][] dp = new int[n + 1][k];
    Arrays.fill(dp[1], 1);
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = i;
      for (int j = 1; j < k; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        //考虑第(j)个鸡蛋(索引j-1)选择从哪一个楼层开始
        //从m楼扔下
        //如果鸡蛋未碎， 需要检查[m + 1, i]楼层，还剩j个鸡蛋
        //鸡蛋碎了，需要检查[0, m-1]楼层，还剩j-1个鸡蛋
        int left = 1;
        int right = i;
        if (i == 1) {
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[1 - 1][j - 1], dp[i - (1)][j]) + 1);
          continue;
        }
        int med = (right - left) / 2 + left;
        while (right > left) {
          int after = Math.max(dp[med - 1 + 1][j - 1], dp[i - (med + 1)][j]) + 1;
          int curVal = Math.max(dp[med - 1][j - 1], dp[i - (med)][j]) + 1;
          if (after > curVal) {
            right = med;
          } else if (after < curVal) {
            left = med + 1;
          } else {
            break;
          }
          med = (right - left) / 2 + left;
        }
        dp[i][j] = Math.min(dp[i][j], Math.max(dp[med - 1][j - 1], dp[i - (med)][j]) + 1);
      }
    }
    return dp[n][k - 1];
  }
}
