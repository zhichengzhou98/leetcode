package com.zzc.weekcompetition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 10:37
 */
public class CountWays {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,2,7,1,2,2,4,7);
        System.out.println(countWays(nums));
    }
    public static int countWays(List<Integer> nums) {
        int res = 0;
        List<Integer> sorted = nums.stream().sorted().collect(Collectors.toList());
        if (sorted.get(0) > 0) {
            res++;
        }
        for (int i = 0; i < sorted.size(); i++) {
            int current = sorted.get(i);
            if (i + 1 < sorted.size()) {
                Integer next = sorted.get(i +1);
                if (i + 1 < next && i +1 > current) {
                    res++;
                }
            }else if (i +1 > current) {
                res++;
            }
        }
        return res;
    }
}
