package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-28 19:26
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][];
        boolean flag = true;
        int j = 0;
        for (int i = 0; i < intervals.length + 1; i++) {
            if (j == intervals.length) {
                res[i] = newInterval;
                break;
            }
            int[] curr = intervals[j];
            if (newInterval[0] <= curr[0] && flag) {
                res[i] = newInterval;
                i++;
                flag = false;
            }
            res[i] = curr;
            j++;
        }
        return merge(res);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int[] dest = intervals[0];
        list.add(dest);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= dest[1]) {
                //合并
                dest[1] = Math.max(dest[1], curr[1]);
            }else {
                list.add(curr);
                dest = curr;
            }
        }
        return list.toArray(new int[0][]);
    }

}
