package com.zzc.leetcode_may;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 滑动窗口，不定长滑窗 ×（数组中的元素有可能为负，无法确定左右端点哪个移动）
 * @create 2024-05-13 15:53
 */
public class SubarraySum {

    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        //前缀和
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    //前缀和 + hash优化
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        Map<Integer, Integer> valueCntsMap = new HashMap<>();
        //valueCntsMap.put(0, 1);
        for (int i = 0; i < prefixSum.length; i++) {
            int target =prefixSum[i] - k;
            res += valueCntsMap.getOrDefault(target, 0);
            valueCntsMap.put(prefixSum[i], valueCntsMap.getOrDefault(prefixSum[i], 0) + 1);
        }
        return res;
    }
}
