package com.zzc.leetcode_oct;

import com.zzc.utils.ArrayUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-09 20:42
 */
public class SolveSudoku {
    public static void main(String[] args) throws IOException {
        SolveSudoku sSK = new SolveSudoku();
        char[][] array2 = ArrayUtils.generate("array2", char[][].class);
        sSK.solveSudoku(array2);
        System.out.println(array2);
    }
    public void solveSudoku(char[][] board) {
        //为填充的位置
        Stack<int[]> stack = new Stack<>();
        map = new HashMap<>();
        map.put("00", 0);
        map.put("01", 1);
        map.put("02", 2);
        map.put("10", 3);
        map.put("11", 4);
        map.put("12", 5);
        map.put("20", 6);
        map.put("21", 7);
        map.put("22", 8);
        lists = new List[9];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int[] pos = new int[]{i, j};
                int index = countIndex(pos);
                lists[index].add(pos);
                if (board[i][j] == '.') {
                    stack.push(new int[]{i, j});
                }
            }
        }
        dfs(stack, board);
    }

    //计算当前坐标属于哪个9宫格
    // 0 1 2
    // 3 4 5
    // 6 7 8
    public int countIndex(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        return map.get(String.valueOf(x/3) + (y / 3));
    }
    List<int[]>[] lists;
    Map<String, Integer> map;
    private boolean flag = false;

    public void dfs(Stack<int[]> stack, char[][] board) {
        if (stack.isEmpty()) {
            flag = true;
            return;
        }
        //还有位置没有填充完
        int[] pos = stack.pop();
        int x = pos[0];
        int y = pos[1];
        Set<Character> set = new HashSet<>(Set.of(
                '1', '2', '3',
                '4', '5', '6',
                '7', '8', '9'
        ));
        //横向遍历
        for (char c : board[x]) {
            set.remove(c);
        }
        //纵向遍历
        for (int i = 0; i < board.length; i++) {
            char c = board[i][y];
            set.remove(c);
        }
        //移除所在的九宫格中的数字
        int index = countIndex(pos);
        List<int[]> poss = lists[index];
        for (int i = 0; i < poss.size(); i++) {
            int[] posInCell = poss.get(i);
            set.remove(board[posInCell[0]][posInCell[1]]);
        }
        if (set.isEmpty()) {
            //没有元素可以填充
            return;
        }
        for (Character c : set) {
            //当前位置填充字符c
            board[x][y] = c;
            //递归
            dfs(stack, board);
            if (flag) {
                //递归结束 填充完成
                return;
            }
            board[x][y] = '.';
        }
        //回溯
        //board[x][y] = '.';
    }
}
