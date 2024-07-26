package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-26 18:06
 */
public class LosingPlayer {
  //X -> 75 Y -> 10
  public String losingPlayer(int x, int y) {
    //false表示bob赢
    boolean flag = false;
    while (x >= 1 && y >= 4) {
      flag = !flag;
      y -= 4;
      x -= 1;
    }
    return flag ? "Alice" : "Bob";
  }
}
