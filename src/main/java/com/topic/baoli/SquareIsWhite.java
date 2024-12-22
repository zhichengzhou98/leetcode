package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 1812 判断国际象棋棋盘中一个格子的颜色
 * @create 2024-12-09 9:32
 */
public class SquareIsWhite {
  public boolean squareIsWhite(String coordinates) {
    return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '0'))
        % 2 == 0;
  }
}
