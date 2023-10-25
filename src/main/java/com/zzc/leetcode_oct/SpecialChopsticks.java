package com.zzc.leetcode_oct;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-25 21:05
 */
public class SpecialChopsticks {
    public static void main(String[] args) {
        System.out.println(specialChopsticks(new int[]{1000}));
    }
    public static int specialChopsticks(int[] chopsticks) {
        int[] possibleEigenvalues = new int[101];
        for (int i = 0; i < chopsticks.length; i++) {
            int length = chopsticks[i];
            for (int j = 1; j <= Math.min(100, length); j++) {
                possibleEigenvalues[j]++;
            }
        }
        //遍历possibleEigenvalues
        for (int i = 1; i < possibleEigenvalues.length; i++) {
            if (possibleEigenvalues[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
