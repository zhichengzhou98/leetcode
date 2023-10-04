package com.zzc.weekcompetition;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-04 18:28
 */
public class MinSizeSubarray {
    public static void main(String[] args) {
        int[] arr = {1,11,6,4,13};
        System.out.println(minSizeSubarray(arr, 22));
    }
    public static int minSizeSubarray(int[] nums, int target) {
        if (nums.length == 1) {
            if (target % nums[0] == 0) {
                return target / nums[0];
            }
            return -1;
        }
        int len = nums.length;
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //新数组
        int[] numsPro = new int[nums.length + nums.length - 2];
        for (int i = 0; i < numsPro.length; i++) {
            numsPro[i] = nums[i % (nums.length)];
        }
        //前缀和
        long[] preSum = new long[numsPro.length + 1];
        preSum[0] = 0;
        //key 为前缀和的值, value为索引，由于nums[i] >= i, key不重复
        Map<Long, Integer> map = new HashMap<>();
        map.put(preSum[0], 0);
        for (int i = 1; i <= numsPro.length; i++) {
            preSum[i] = preSum[i - 1] + numsPro[i - 1];
            map.put(preSum[i], i);
        }
        int res = 0;
        res += (target / sum) * len;
        target %= sum;
        if (target == 0) {
            return res;
        }
        int i = preSum.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (i >=0) {
            long currentSum = preSum[i];
            if (currentSum < target) {
                break;
            }
            if (map.containsKey(currentSum - target)) {
                int index = map.get(currentSum - target);
                minDiff = Math.min(minDiff, i - index);
            }
            i--;
        }
        if (minDiff == Integer.MAX_VALUE) {
            return -1;
        }

        return res + minDiff;
    }
}
