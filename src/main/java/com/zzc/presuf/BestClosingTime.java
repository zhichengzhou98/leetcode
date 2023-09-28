package com.zzc.presuf;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 12:28
 */
public class BestClosingTime {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYYY"));
    }
    public static int bestClosingTime(String customers) {
        //前缀 第 i 小时关门时， 0 - i 的代价， 统计前缀 N 的个数
        int[] preCost = new int[customers.length() + 1];
        preCost[0] = 0;
        for (int i = 1; i < preCost.length; i++) {
            preCost[i] = preCost[i - 1] + (customers.charAt(i - 1) == 'N' ? 1 : 0);
        }
        //后缀 第 i 小时关门 i - len - 1 的代价， 统计前缀 Y 的个数
        int [] sufCost = new int[customers.length() + 1];
        sufCost[sufCost.length - 1] = 0;
        for (int i = sufCost.length - 2; i >= 0 ; i--) {
            sufCost[i] = sufCost[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int minCost = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < preCost.length; i++) {
            if (preCost[i] + sufCost[i] < minCost) {
                index = i;
                minCost = preCost[i] + sufCost[i];
            }
        }
        return index;
    }
}
