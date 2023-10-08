package com.zzc.weekcompetition;

import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-08 16:07
 */
public class MaxSum1 {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 30));
    }

    private static int MOD = (int) (Math.pow(10, 9) + 7);
    public int maxSum(List<Integer> nums, int k) {
        //遍历nums， 获取每个数二进制1
        int[] bits = new int[30];
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            int j = 0;
            while (num > 0) {
                int bit = num % 2;
                bits[j] += bit;
                num /= 2;
                j++;
            }
        }
        //重新构造k个数
        long res = 0;
        for (int i = 1; i <= k; i++) {
            int num = 0;
            for (int j = bits.length - 1; j >= 0 ; j--) {
                if (bits[j] >= 1) {
                    bits[j]--;
                    num = num * 2 + 1;
                }else {
                    num = num * 2;
                }
            }
            res = (res + (long) num * num % MOD) % MOD;
        }
        return (int) res;
    }
}
