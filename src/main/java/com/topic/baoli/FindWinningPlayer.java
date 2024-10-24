package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3175. 找到连续赢 K 场比赛的第一位玩家
 * @create 2024-10-24 9:28
 */
public class FindWinningPlayer {
  @Test
  void testFun() {
    int[] s = {4,2,6,3,9};
    System.out.println(findWinningPlayer(s, 2));
  }

  public int findWinningPlayer(int[] skills, int k) {
    // 遍历
    // 队首元素的索引
    int max = 0;
    // 获胜的次数
    int cnts = 0;
    for (int i = 1; i < skills.length; i++) {
      int current = skills[i];
      if (skills[max] > current) {
        cnts++;
      } else {
        // 更新获胜的人 以及获胜的次数
        max = i;
        cnts = 1;
      }
      if (cnts == k) {
        return max;
      }
    }
    return max;
  }
}
