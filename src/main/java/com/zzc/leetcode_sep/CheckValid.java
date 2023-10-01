package com.zzc.leetcode_sep;

import com.zzc.utils.ArrayUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-30 19:16
 */
public class CheckValid {
    public static void main(String[] args) throws IOException {
        int[][] array = ArrayUtils.generate("array", int[][].class);
        System.out.println(checkValid(array));
    }

    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        //遍历行
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= 0 || matrix[i][j] > n) {
                    return false;
                }else {
                    set.add(matrix[i][j]);
                }
            }
            if (set.size() < n) {
                return false;
            }
        }
        //遍历列
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] <= 0 || matrix[j][i] > n) {
                    return false;
                }else {
                    set.add(matrix[j][i]);
                }
            }
            if (set.size() < n) {
                return false;
            }
        }
        return true;
    }
}
