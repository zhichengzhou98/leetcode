package com.zzc.weekcompetition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description TODO 差分数组
 * @create 2023-09-10 10:31
 */
public class NumberOfPoints {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            int start = list.get(0);
            int end = list.get(1);
            for (int j = start; j <= end; j++) {
                res.add(j);
            }
        }
        return res.size();
    }
}
