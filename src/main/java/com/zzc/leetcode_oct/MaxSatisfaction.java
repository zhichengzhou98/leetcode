package com.zzc.leetcode_oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-22 12:15
 */
public class MaxSatisfaction {
    public static void main(String[] args) {

    }

    public int maxSatisfaction(int[] satisfaction) {
        int sum = 0;
        Arrays.sort(satisfaction);
        List<Integer> list = new ArrayList<>();
        for (int i = satisfaction.length - 1; i >= 0 ; i--) {
            int sat = satisfaction[i];
            if (sat + sum >= 0) {
                list.add(sat);
                sum += sat;
            }else {
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer sat = list.get(i);
            res = res + sat * (list.size() - i);
        }
        return res;
    }
}
