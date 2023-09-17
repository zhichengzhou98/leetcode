package com.zzc.weekcompetition;

import java.util.List;

/**
 * @author zc.zhou
 * @Description 二分答案
 * @create 2023-09-17 11:00
 */
public class MaxNumberOfAlloys {
    public static void main(String[] args) {

    }

    public int maxNumberOfAlloys(
            int n,
            int k,
            int budget,
            List<List<Integer>> composition,
            List<Integer> stock,
            List<Integer> cost) {
        int res = 0;
        for (int i = 0; i < composition.size(); i++) {
            //计算第i台机器的最大的生产数量
            List<Integer> counts = composition.get(i);
            long l = 0;
            long r = (int) (2 * Math.pow(10, 8) + 1);
            long med = (r - l + 1 )/ 2 + l;
            while (l < r) {
                if (checkMedRight(med, budget, counts, stock, cost)) {
                    l = med;
                }else {
                    r = med - 1;
                }
                med = (r - l + 1 ) / 2 + l;
            }
            res = (int) Math.max(res, med);
        }

        return res;
    }

    private boolean checkMedRight(long med, int budget, List<Integer> counts, List<Integer> stock,List<Integer> cost) {
        double money = 0;
        for (int i = 0; i < counts.size(); i++) {
            //需要第i个材料
            int require = counts.get(i);
            //库存
            int stockI = stock.get(i);
            //单价
            int priceI = cost.get(i);
            //库存不够需要购买
            if (med * require > stockI) {
                money = money + ((double) med * require - stockI) * priceI;
            }
        }
        return money <= budget;
    }


    public int maxNumberOfAlloys1(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        //考虑库存时，计算每组的花费


        for (int i = 0; i < composition.size(); i++) {
            int maxCount = Integer.MIN_VALUE;
            List<Integer> list = composition.get(i);
            int bug = 0;
            for (int j = 0; j < list.size(); j++) {
                bug += list.get(i) * maxCount - stock.get(j);
            }
            if (bug < budget) {
                maxCount++;
            }

        }

        return 0;
    }
}
