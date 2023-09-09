package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description 1342. 将数字变成 0 的操作次数
 *
 * @create 2023-07-30 11:41
 */
public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(new NumberOfSteps().numberOfSteps1(123));
    }

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num >> 1;
                step = step + 1;
            }else {
                num--;
                step++;
            }
        }

        return step;
    }

    public int numberOfSteps1(int num) {
        if (num == 0) {
            return 0;
        }
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            if (i % 2  == 0) {
                res[i] = res[i/ 2] + 1;
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res[num];
    }
}
