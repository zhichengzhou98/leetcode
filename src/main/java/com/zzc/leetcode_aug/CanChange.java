package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-21 21:19
 */
public class CanChange {
    public boolean canChange(String start, String target) {
        int len = start.length();
        int i = 0;
        int j = 0;
        while (i < len && j <len) {
            while (i < len && start.charAt(i)=='_') {
                i++;
            }

            while (j < len && target.charAt(j)=='_') {
                j++;
            }
            if (i < len && j < len) {
                if (start.charAt(i) !=  target.charAt(j)) {
                    return false;
                }else if (start.charAt(i) == 'L' && i < j) {
                    return false;
                }else if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
            }else if ((i >= len && j < len) || (j >= len && i < len)) {
                return false;
            }
            i++;
            j++;
        }
        while (i < len && start.charAt(i)=='_') {
            i++;
        }
        if (i < len && start.charAt(i) != '_') {
            return false;
        }
        while (j < len && target.charAt(j)=='_') {
            j++;
        }
        if (j < len && target.charAt(j) != '_') {
            return false;
        }
        return true;
    }
}
