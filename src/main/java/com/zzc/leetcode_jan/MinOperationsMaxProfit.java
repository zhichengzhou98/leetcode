package com.zzc.leetcode_jan;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-01 9:54
 */
public class MinOperationsMaxProfit {
    @Test
    public void test() {
        int[] customers = {10, 9, 6};
        System.out.println(minOperationsMaxProfit(customers, 6, 4));
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        //res[0]: 利润 res[1]: 利润最大时的轮转次数
        int[] res = new int[]{0, -1};
        //等待的游客
        int waiter = 0;
        //上次的利润
        int lastProfit = 0;
        // 当前轮转次数
        int cnts = 0;
        while (waiter > 0 || cnts < customers.length) {
            if (cnts < customers.length) {
                //有人上车
                waiter += customers[cnts];
            }
            //最多的上车游客
            int maxCustomer = Math.min(waiter, 4);
            //更新利润
            lastProfit = lastProfit + maxCustomer * boardingCost - runningCost;
            //更新等待的游客
            waiter -= maxCustomer;
            cnts++;
            //更新res
            if (lastProfit > res[0]) {
                res[0] = lastProfit;
                res[1] = cnts;
            }
        }
        return res[1];
    }

    public int minOperationsMaxProfit1(int[] customers, int boardingCost, int runningCost) {
        //res[0]: 利润 res[1]: 轮转次数
        int[] res = new int[]{0, -1};
        //等待的游客
        int waiter = 0;
        //上次的利润
        int lastProfit = 0;
        int cnts = 0;
        for (int i = 0; i < customers.length; i++) {
            int current = customers[i];
            waiter += current;
            //最多的上车游客
            int maxCustomer = Math.min(waiter, 4);
            //更新利润
            lastProfit = lastProfit + maxCustomer * boardingCost - runningCost;
            //更新等待的游客
            waiter -= maxCustomer;
            cnts++;
            //更新res
            if (lastProfit > res[0]) {
                res[0] = lastProfit;
                res[1] = cnts;
            }
        }
        while (waiter > 0) {
            //最多的上车游客
            int maxCustomer = Math.min(waiter, 4);
            //更新利润
            lastProfit = lastProfit + maxCustomer * boardingCost - runningCost;
            //更新等待的游客
            waiter -= maxCustomer;
            cnts++;
            //更新res
            if (lastProfit > res[0]) {
                res[0] = lastProfit;
                res[1] = cnts;
            }
        }

        return res[1];
    }
}
