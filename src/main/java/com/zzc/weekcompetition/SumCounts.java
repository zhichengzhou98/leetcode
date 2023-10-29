package com.zzc.weekcompetition;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-28 22:31
 */
public class SumCounts {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        System.out.println(sumCounts(List.of(2,2)));
    }
    private static int MOD = (int) (Math.pow(10, 9) + 7);
    public int sumCounts(List<Integer> nums) {
        int size = nums.size();
        int res = 0;
        for (int begin = 0; begin < size; begin++) {
            for (int end = begin; end < size; end++) {
                //统计begin 到 end之间不同元素的个数
                res = res + diff(begin, end, nums) * diff(begin, end, nums) % MOD;
            }
        }
        return res;
    }

    public int diff(int begin, int end, List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i <= Math.min(nums.size() - 1, end) ; i++) {
            set.add(nums.get(i));
        }
        return set.size();
    }
}
