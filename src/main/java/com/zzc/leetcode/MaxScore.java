package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-13 12:12
 */
public class MaxScore {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
    public static int maxScore(String s) {
        int [] leftScore = new int[s.length() - 1];
        int [] rightScore = new int[s.length() - 1];
        if (s.charAt(0) == '0') {
            leftScore[0] = 1;
        }else {
            leftScore[0] = 0;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftScore[i] = leftScore[i - 1] + 1;
            }else {
                leftScore[i] = leftScore[i - 1];
            }
        }
        if (s.charAt(s.length() - 1) == '1') {
            rightScore[rightScore.length - 1] = 1;
        }else {
            rightScore[rightScore.length - 1] = 0;
        }
        for (int i = s.length() - 2; i >= 1 ; i--) {
            if (s.charAt(i) == '1') {
                rightScore[i-1] = rightScore[i] + 1;
            }else {
                rightScore[i-1] = rightScore[i];
            }
        }
        int max = 0;
        for (int i = 0; i < leftScore.length; i++) {
            max = Math.max(max, rightScore[i] + leftScore[i]);
        }
        return max;
    }
}
