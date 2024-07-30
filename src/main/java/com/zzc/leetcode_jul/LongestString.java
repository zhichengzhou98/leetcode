package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2745
 * @create 2024-07-30 14:12
 */
public class LongestString {
  @Test
  void testFun() {
    System.out.println(longestString(9, 9 , 34));
  }
  //AA BB AB -> AAA BBB
  public int longestString(int x, int y, int z) {
    //AB不影响AA BB 生成的最大字符串长度
    if (x == y) {
      return 2 * z + 2 * x * 2;
    }
    return 2 * (Math.min(x, y) * 2 + 1) + 2 * z;
  }
}
