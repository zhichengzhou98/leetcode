package com.zzc.leetcode_dec;

import com.zzc.utils.ArrayUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-08 20:15
 */
public class MaxTaxiEarnings {
    public static void main(String[] args) throws IOException {
        int[][] array = ArrayUtils.generate("array", int[][].class);
        MaxTaxiEarnings mTE = new MaxTaxiEarnings();
        System.out.println(mTE.maxTaxiEarnings(5, array));
    }

    Map<Integer, Long> map;
    int maxDes;
    //二分
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        map = new HashMap<>();
        maxDes = rides[rides.length - 1][0];
        return dfs(0, rides);
    }

    public long dfs(int current, int[][] rides) {
        if (map.containsKey(current)) {
            return map.get(current);
        }
        if (current >= rides.length) {
            map.put(current, 0L);
            return 0L;
        }
        //
        int[] ride = rides[current];
        long a = ride[2] + ride[1] - ride[0];
        //查找左边界 >= ride[1] 的下标
        if (ride[1] <= maxDes) {
            int next = leftBoundary(rides, ride[1], current);
            a += dfs(next, rides);
        }
        long b = dfs(current + 1, rides);
        long max = Math.max(a, b);
        map.put(current, max);
        return max;
    }

    public int leftBoundary(int[][] nums, int target, int left){
        int l = left;
        int r = nums.length - 1;
        int med = (r - l) / 2 + l;
        while (l < r) {
            int current = nums[med][0];
            if (current >= target) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }
}
