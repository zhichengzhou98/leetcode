package com.topic.sort;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 825. 适龄的朋友 计数 + 前缀和
 * @create 2024-11-17 08:38
 */
public class NumFriendRequests {
  @Test
  void testFun() {
    int[] ages = {16,17,18};
    System.out.println(numFriendRequests(ages));
  }
  public int numFriendRequests(int[] ages) {
    int[] cnts = new int[121];
    // 统计每个年龄出现的人数
    for (int age : ages) {
      cnts[age]++;
    }
    // cnts 前缀和
    int[] sumCnts = new int[121];
    sumCnts[0] = cnts[0];
    for (int i = 1; i < sumCnts.length; i++) {
      sumCnts[i] = sumCnts[i - 1] + cnts[i];
    }
    int res = 0;
    // 遍历cnts
    for (int i = 15; i < cnts.length; i++) {

      // i 表示 x 的年龄
      // y <= x
      // y > 0.5x + 7
      // x > 0.5x + 7 => x > 14
      int yMin = (int) (Math.floor(0.5 * i) + 7 + 1);
      int tmp = sumCnts[i] - sumCnts[yMin-1];
      // 不能发给自己
      tmp -= 1;
      res += tmp * cnts[i];
    }
    return res;
  }
}
