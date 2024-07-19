package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-19 9:43
 */
public class MinimumLevels {
  public int minimumLevels(int[] possible) {
    //统计总的分数
    int sum = 0;
    for (int num : possible) {
      if (num == 1) {
        sum += 1;
      } else {
        sum -= 1;
      }
    }
    int aSum = possible[0] == 1 ? 1 : -1;
    int bSum = sum - aSum;
    //当前关卡的索引
    int current = 0;
    while (true) {
      if (aSum > bSum) {
        //关卡数
        if (current == possible.length - 1) {
          return -1;
        }
        return current + 1;
      }
      //需要进行下一个关卡
      current++;
      if (current >= possible.length) {
        break;
      }
      int currentScore = possible[current] == 1 ? 1 : -1;
      aSum += currentScore;
      bSum -= currentScore;
    }
    return -1;
  }
}
