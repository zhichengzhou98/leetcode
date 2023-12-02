package com.zzc.leetcode_nov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-01 21:01
 */
public class FirstCompleteIndex {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //key: 值 value: 坐标
        Map<Integer, int[]> map = new HashMap();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});

            }
        }
        int[] mArr = new int[m];
        int[] nArr = new int[n];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            mArr[pos[0]]++;
            nArr[pos[1]]++;
            if (mArr[pos[0]] == n || nArr[pos[1]] == m) {
                return i;
            }
        }
        return index;
    }
}
