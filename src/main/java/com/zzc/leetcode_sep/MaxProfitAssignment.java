package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 9:29
 */
public class MaxProfitAssignment {
    public static void main(String[] args) {
        MaxProfitAssignment obj = new MaxProfitAssignment();
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(obj.maxProfitAssignment(difficulty, profit, worker));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 难度 与 利润的数组
        int[][] diffPro = new int[difficulty.length][2];
        for (int i = 0; i < diffPro.length; i++) {
            diffPro[i] = new int[]{difficulty[i], profit[i]};
        }
        //将diffPro按难度升序
        Arrays.sort(diffPro, (a, b)-> a[0] - b[0]);
        //难度<= key 的最大利润 value
        Map<Integer, Integer> map = new HashMap<>();
        int maxPro = diffPro[0][1];
        for (int i = 0; i < diffPro.length; i++) {
            int[] current = diffPro[i];
            //当前难度
            int diff = current[0];
            //当前利润
            int pro = current[1];
            //最大利润
            maxPro = Math.max(maxPro, pro);
            map.put(diff, maxPro);
        }
        Arrays.sort(difficulty);
        int res = 0;
        //遍历 worker
        for (int i = 0; i < worker.length; i++) {
            int target = worker[i];
            //难度小于等于 target 的最大值， 右边界
            if (difficulty[0] > target) {
                continue;
            }
            int diff = rightBoundary(difficulty, target);
            res = res + map.getOrDefault(diff, 0);
        }
        return res;
    }

    public boolean checkMed(int med,int target) {
        if (med > target) {
            return false;
        }
        return true;
    }

    public int rightBoundary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMed(nums[med], target)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return nums[med];
    }
}
