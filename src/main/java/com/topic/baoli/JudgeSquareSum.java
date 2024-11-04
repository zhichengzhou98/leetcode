package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 633 平方数之和
 * @create 2024-11-04 9:02
 */
public class JudgeSquareSum {
  public boolean judgeSquareSum(int c) {
    int max = (int) Math.sqrt(c) + 1;
    int min = (max >> 1) - 1;
    for (int i = min; i <= max ; i++) {
      int tmp = c - i * i;
      int a = (int) Math.sqrt(tmp);
      if (a * a == tmp) {
        return true;
      }
    }
    return false;
  }
}
