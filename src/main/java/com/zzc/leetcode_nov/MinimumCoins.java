package com.zzc.leetcode_nov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-26 11:49
 */
public class MinimumCoins {
    int[] prices;

    Map<String, Integer> map;
    public int minimumCoins(int[] prices) {
        this.prices = prices;
        map = new HashMap<>();
        int maxIndex = prices.length- 1;
        return Math.min(dfs(maxIndex, 0), dfs(maxIndex, 1));
    }

    public int dfs(int index, int buyOrNot) {
        String key = index + "," + buyOrNot;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == 0) {
            if (buyOrNot == 0) {
                map.put(key, Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }else if (buyOrNot == 1){
                map.put(key, prices[index]);
                return prices[index];
            }
        }
        int res = Integer.MAX_VALUE;
        if (buyOrNot == 0) {
            //第index个物品不买
            int begin = index / 2;
            for (int i = begin; i < index; i++) {
                res = Math.min(res, dfs(i, 1));
            }
        }else if (buyOrNot == 1) {
            res = Math.min(dfs(index-1, 0), dfs(index-1, 1)) + prices[index];
        }
        map.put(key, res);
        return res;
    }
}
