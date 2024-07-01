package com.zzc.leetcode_mar;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-27 22:29
 */
public class MissingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = 0;
        for(int i : rolls) {
            sum += i;
        }
        int total = mean * (n + rolls.length);
        int left = total - sum;
        if (left < n || left > 6 * n) {
            return new int[0];
        }
        int value = left / n;
        int i = left % n;
        for (int j = 0; j < n; j++) {
            res[j] = value;
            if (j < i){
                res[j]++;
            }
        }
        return res;
    }
}
