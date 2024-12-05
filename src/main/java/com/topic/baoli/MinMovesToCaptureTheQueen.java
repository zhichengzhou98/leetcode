package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3001 捕获黑皇后需要的最少移动次数
 * @create 2024-12-05 13:24
 */
public class MinMovesToCaptureTheQueen {
  @Test
  void testFun() {
    System.out.println(minMovesToCaptureTheQueen(1,6,3,3,5,6));
  }

  public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
    // 白车是否和黑皇后在同一直线
    if (a == e || b == f) {
      // 判断白象是否在它们之间
      if (a == e) {
        // 白象在它们之间
        if (c == a && d > Math.min(b, f) && d < Math.max(b, f)) {
          // 先移走白象
          return 2;
        } else {
          // 不在它们之间
          return 1;
        }
      } else {
        // b == f
        if (d == f && c > Math.min(a, e) && c < Math.max(a, e)) {
          // 先移走白象
          return 2;
        } else {
          // 不在它们之间
          return 1;
        }
      }
    } else {
      // 白车不和黑皇后在同一直线
      // 判断白象 黑皇后是否在同一斜线
      if (Math.abs(e - c) == Math.abs(d - f)) {
        // 在同一直线
        // 判断白车是否在它们之间
        if (a > Math.min(c, e) && a < Math.max(c, e)
            && b > Math.min(d, f) && b < Math.max(d, f) && Math.abs(a - c) == Math.abs(d - b)) {
          // 白车在它们之间
          return 2;
        }
        return 1;
      } else {
        return 2;
      }
    }
  }
}
