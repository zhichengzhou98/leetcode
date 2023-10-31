package com.zzc.weekcompetition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-29 10:35
 */
public class MinSum {
    @Test
    public void test() {
        //[0,7,28,17,18]
        //[1,2,6,26,1,0,27,3,0,30]
        System.out.println(minSum(new int[]{0,7,28,17,18}, new int[]{1,2,6,26,1,0,27,3,0,30}));
    }
    public long minSum(int[] nums1, int[] nums2) {
        int cnt1 = zeroCnt(nums1);
        int cnt2 = zeroCnt(nums2);
        long sum1 = Arrays.stream(nums1).asLongStream().sum();
        long sum2 = Arrays.stream(nums2).asLongStream().sum();
        if (cnt1 == 0 && cnt2 == 0) {
            return sum2 == sum1 ? sum2 : -1;
        }
        if (cnt1 == 0) {
            if (sum1 < sum2 + cnt2) {
                return -1;
            }
            return Math.max(sum1+cnt1, sum2+cnt2);
        }
        if (cnt2 == 0) {
            if (sum2 < sum1 + cnt1) {
                return -1;
            }

        }
        return Math.max(sum1+cnt1, sum2+cnt2);
    }

    public int zeroCnt(int[] nums1) {
        int res = 0;
        for(int i: nums1) {
            if (i == 0) {
                res++;
            }
        }
        return res;
    }
}
