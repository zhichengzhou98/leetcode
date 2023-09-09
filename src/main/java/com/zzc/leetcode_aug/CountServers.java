package com.zzc.leetcode_aug;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-24 21:06
 */
public class CountServers {
    public static void main(String[] args) {
        System.out.println(countServers(new int[][]{{1,0},{1,1}}));
    }

    public static int countServers(int[][] grid) {
        int count = 0;
        //用来记录出现服务器的点
        HashSet<String> set = new HashSet<>();
        //按行遍历
        for (int i = 0; i < grid.length; i++) {
            HashSet<String> strings = new HashSet<>();
            int[] row = grid[i];
            int temp = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    temp++;
                    strings.add(i + "," + j);
                }
            }
            if (temp >= 2) {
                count += temp;
                set.addAll(strings);
            }
        }

        //按列遍历
        for (int i = 0; i < grid[0].length; i++) {
            int n = grid.length;
            int temp = 0;
            int dul = 0;
            for (int j = 0; j < n; j++) {
                if(grid[j][i] == 1) {
                    temp++;
                }
                if (set.contains(j + "," + i)){
                    dul++;
                }
            }

            if (temp >= 2) {
                count += temp;
                count -= dul;
            }
        }
        return count;
    }
}
