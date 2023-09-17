package com.zzc.weekcompetition;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-17 10:30
 */
public class SumIndicesWithKSetBits {
    public static void main(String[] args) {
        List<Integer> res = List.of(5,10,1,5,2);
        System.out.println(sumIndicesWithKSetBits(res, 1));
    }
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k  ) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
