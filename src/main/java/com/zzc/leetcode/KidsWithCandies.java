package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-13 12:37
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxValue = 0;

        for (int i = 0; i < candies.length; i++) {
            maxValue = Math.max(maxValue, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                res.add(true);
            }else {
                res.add(false);
            }
        }
        return res;
    }
}
