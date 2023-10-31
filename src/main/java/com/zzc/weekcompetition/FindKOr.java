package com.zzc.weekcompetition;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-29 10:31
 */
public class FindKOr {
    @Test
    public void test() {
        System.out.println(isIOne(2, 0));
        System.out.println(findKOr(new int[]{2,12,1,11,4,5}, 6));
    }
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (isIOne(nums[j], i)) {
                    cnt++;
                }
                if (cnt >= k) {
                    break;
                }
            }
            if (cnt >= k) {
                res = res + (int) Math.pow(2, i);
            }
        }
        return res;
    }

    //判断第i位是否为1
    public boolean isIOne(int num, int i) {
        int num1 = 1 << i;
        return (num1 & num) == num1;
    }
}
