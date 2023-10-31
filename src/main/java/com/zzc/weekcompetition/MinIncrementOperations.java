package com.zzc.weekcompetition;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-29 11:04
 */
public class MinIncrementOperations {
    @Test
    public void test() {
        //[2,3,0,0,2]
        //4
        System.out.println(minIncrementOperations(new int[]{2, 3, 0, 0, 2}, 4));
    }

    public long minIncrementOperations(int[] nums, int k) {
        long[][] res = new long[nums.length][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = Math.max(0, k - nums[j]);
            }
            long min = Math.max(res[i][0], res[i][1]);
            res[i][3] = Math.min(min, res[i][2]);
        }
        res[3][0] = Math.min(res[1][1], res[2][1]);
        res[3][1] = res[2][2];
        long min = Math.min(res[0][0], res[1][0]);
        res[3][2] = Math.max(0, k - nums[3]) + Math.min(min, res[0][3]);
        min = Math.min(res[3][1], res[3][0]);
        res[3][3] = Math.min(min, res[3][2]);
        for (int i = 4; i < nums.length; i++) {
            int num = nums[i];
            if (num >= k) {
                res[i][0] = min(res[i - 2][2], res[i - 1][1]);
                res[i][1] = min(res[i - 1][2]);
                res[i][2] = res[i - 3][4];
            } else {
                res[i][0] = min(res[i - 2][2], res[i - 1][1]);
                res[i][1] = min(res[i - 1][2]);
                res[i][2] = k - num + res[i - 3][3];
            }
        }
        return res[nums.length - 1][3];
    }

    public long min(long... arr) {
        long min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    /*public long minIncrementOperations(int[] nums, int k) {
        long[] res = new long[nums.length];
        int min1 = Math.max(0, k - nums[0]);
        int min2 = Math.min(Math.max(0, k - nums[1]), min1);
        int min3 = Math.min(min2, k - nums[2]);
        res[2] = min3;
        for (int i = 0; i <= 1; i++) {
            res[i] = res[2];
        }
        for (int i = 3; i < nums.length; i++) {
            int num = nums[i];
            if (num >= k) {
                res[i] = Math.min(res[i - 1], res[i - 2]);
            } else {
                long min = res[i - 2] + k - num;
                min = Math.min(min, res[i - 1]);
                res[i] = min;

            }
        }
        return res[nums.length - 1];
    }*/
}
