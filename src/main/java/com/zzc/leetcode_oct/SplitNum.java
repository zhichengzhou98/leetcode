package com.zzc.leetcode_oct;

import java.sql.SQLOutput;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-09 12:02
 */
public class SplitNum {
    public static void main(String[] args) {
        System.out.println(splitNum(4253));
    }
    public static int splitNum(int num) {
        //统计每个数字出现的次数
        int[] numCnt = new int[10];
        while (num > 0) {
            numCnt[num % 10]++;
            num /= 10;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i < numCnt.length;) {
            while (numCnt[i] > 0) {
                if (num1 > num2) {
                    num2 = num2 * 10 + i;
                }else {
                    num1 = num1 * 10 + i;
                }
                numCnt[i]--;
            }
            i++;
        }
        return num2 + num1;
    }
}
