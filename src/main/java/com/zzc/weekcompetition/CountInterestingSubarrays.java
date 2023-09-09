package com.zzc.weekcompetition;

import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 11:29
 */
public class CountInterestingSubarrays {
    public static void main(String[] args) {

    }
    public long getCount(List<Integer> nums, int modulo, int k, int sum) {
        int l = 0;
        int r = 0;
        int res = 0;
        while (l <nums.size() && r < nums.size()) {
            int count = 0;
            while (nums.get(l) % modulo != k) {
                l++;
            }
            if (l < nums.size()) {
                count++;
            }
            if (count == sum) {
                r = l;
                while (r <nums.size() && nums.get(r) % modulo != k) {
                    res++;
                    r++;
                }
                if (r == nums.size()) {
                    return res;
                }
                l++;
                while (l < r && nums.get(l) % modulo != k) {
                    l++;
                    res++;
                }
            }else {

            }
        }

        return res;
    }
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0L;
        int l = 0;
        int r = l;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % modulo == k) {
                sum++;
            }
        }
        if (sum % modulo == k) {
            res = res + getCount(nums, modulo, k, sum);
        }
        return res;
    }
}
