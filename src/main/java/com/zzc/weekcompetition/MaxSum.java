package com.zzc.weekcompetition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 22:45
 */
public class MaxSum {
    public static void main(String[] args) {
        System.out.println(maxSum(List.of(5,9,9,2,4,5,4), 1,3));
    }

    public static long maxSum(List<Integer> nums, int m, int k) {
        int l = 0;
        int r = l + k - 1;
        long maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        if (r < nums.size()) {

            for (int i = 0; i <= r; i++) {
                map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                sum += nums.get(i);
            }
            if (map.keySet().size() >= m) {
                maxSum = Math.max(sum, maxSum);
            }
        }
        while (r < nums.size()) {
            int count = map.get(nums.get(l));
            if (count == 1) {
                map.remove(nums.get(l));
            }else {
                map.put(nums.get(l), count - 1);
            }
            sum -= nums.get(l);
            l++;
            r++;
            if (r >= nums.size()) {
                break;
            }
            map.put(nums.get(r), map.getOrDefault(nums.get(r), 0) + 1);
            sum += nums.get(r);
            if (map.keySet().size() >= m) {
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
