package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description 999. 可以被一步捕获的棋子数 R(车) B(象) p .
 * @create 2023-07-17 14:48
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int[] location = getLocation(board);
        //left
        for (int i = location[1] - 1; i >= 0; ) {
            while (i >= 0 && board[location[0]][i] == '.') {
                i--;
            }
            if (i >= 0 && board[location[0]][i] == 'p') {
                count++;
                break;
            }
            if (i >= 0 && board[location[0]][i] == 'B') {
                break;
            }
        }
        //right
        for (int i = location[1] + 1; i < board[0].length; ) {
            while (i < board[0].length && board[location[0]][i] == '.') {
                i++;
            }
            if (i < board[0].length && board[location[0]][i] == 'p') {
                count++;
                break;
            }
            if (i < board[0].length && board[location[0]][i] == 'B') {
                break;
            }
        }
        // down
        for (int i = location[0] + 1; i < board.length; ) {
            while (i < board.length && board[i][location[1]] == '.') {
                i++;
            }
            if (i < board.length && board[i][location[1]] == 'p') {
                count++;
                break;
            }
            if (i < board.length && board[i][location[1]] == 'B') {
                break;
            }
        }
        //up
        for (int i = location[0] - 1; i >= 0; ) {
            while (i >= 0 && board[i][location[1]] == '.') {
                i--;
            }
            if (i >= 0 && board[i][location[1]] == 'p') {
                count++;
                break;
            }
            if (i >= 0 && board[i][location[1]] == 'B') {
                break;
            }
        }

        return count;
    }

    public int[] getLocation(char[][] board) {
        int[] location = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
