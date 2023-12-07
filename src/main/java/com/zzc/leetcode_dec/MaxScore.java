package com.zzc.leetcode_dec;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-03 12:18
 */
public class MaxScore {

    @Test
    public void test() {
        int[] arr = {1,79,80,1,1,1,200,1};
        System.out.println(maxScore(arr, 3));
    }
    //定长滑窗
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int sum = 0;
        for (int num : cardPoints) {
            sum += num;
        }
        if (len == 0) {
            return sum;
        }
        int min = 0;
        int current;
        for (int i = 0; i < len; i++) {
            min += cardPoints[i];
        }
        current = min;
        for (int i = len; i < cardPoints.length; i++) {
            int next = cardPoints[i];
            int before = cardPoints[i - len];
            current = current + next - before;
            min = Math.min(min, current);
        }
        return sum - min;
    }
}
