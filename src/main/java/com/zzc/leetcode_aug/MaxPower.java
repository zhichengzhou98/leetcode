package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-16 21:01
 */
public class MaxPower {
    public static void main(String[] args) {
        System.out.println(maxPower("1adasfsdss"));
    }

    public static int maxPower(String s) {
        int max = 1;
        int i = 0;
        int j;
        while (true) {
            if (i >= s.length()) {
                break;
            }
            j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            max = Math.max(max, Math.min(j,s.length()) - i);
            i = j;
        }


        return max;
    }
}
