package com.zzc.leetcode_jan;

import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-24 22:42
 */
public class MaximumSumOfHeights {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] res = new long[maxHeights.size()];
        for (int i = 0; i < maxHeights.size(); i++) {
            //以第i个元素为顶
            int pre = maxHeights.get(i);
            res[i] += pre;

            for (int j = i - 1; j >= 0; j--) {
                int current = maxHeights.get(j);
                if (current <= pre) {
                    pre = current;
                }
                res[i] += pre;
            }
            pre = maxHeights.get(i);
            for (int j = i + 1; j < maxHeights.size(); j++) {
                int current = maxHeights.get(j);
                if (current <= pre) {
                    pre = current;
                }
                res[i] += pre;
            }
        }
        return Arrays.stream(res).max().getAsLong();
    }
}
