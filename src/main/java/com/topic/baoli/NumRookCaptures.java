package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 999 可以被一步捕获的棋子数
 * @create 2024-12-06 13:44
 */
public class NumRookCaptures {
  public int numRookCaptures(char[][] board) {
    int res = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'R') {
          // 向上
          for (int k = i - 1; k >= 0; k--) {
            if (board[k][j] == 'p') {
              res++;
              break;
            } else if (board[k][j] == 'B') {
              break;
            }
          }
          // 向下
          for (int k = i + 1; k < board.length; k++) {
            if (board[k][j] == 'p') {
              res++;
              break;
            } else if (board[k][j] == 'B') {
              break;
            }
          }

          // 向左
          for (int k = j - 1; k >= 0; k--) {
            if (board[i][k] == 'p') {
              res++;
              break;
            } else if (board[i][k] == 'B') {
              break;
            }
          }

          // 向右
          for (int k = j + 1; k < board[i].length; k++) {
            if (board[i][k] == 'p') {
              res++;
              break;
            } else if (board[i][k] == 'B') {
              break;
            }
          }
          return res;
        }
      }
    }

    return res;
  }
}

