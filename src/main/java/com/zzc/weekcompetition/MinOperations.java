package com.zzc.weekcompetition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zc.zhou
 * @Description  TODO: 8021. 使子序列的和等于目标的最少操作次数
 * @create 2023-08-27 10:51
 */
public class MinOperations {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(8);
        System.out.println(minOperations(arr, 7));
    }

     public static int minOperations(List<Integer> nums, int target) {
        long sum = 0L;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        if (target > sum) {
            return -1;
        }else if (target == sum) {
            return 0;
        }
        nums.sort((a, b) -> a -b);
        int cnt = 0;
        while (target > 0) {
            int t = nums.get(nums.size()-1);
            nums.remove(nums.size()-1);
            if (sum - t >= target) {
                sum -= t;
            }else if (t > target) {

                nums.add(t >> 1);
                nums.add(t >> 1);
                cnt++;
            }else {
                target = target -t;
                sum = sum -t;
            }
        }
        return cnt;
    }
   /* public int minOperations(List<Integer> nums, int target) {
        long sum = 0L;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        if (target > sum) {
            return -1;
        }else if (target == sum) {
            return 0;
        }
        int[] sortedArray = nums.stream().sorted().mapToInt(Integer::intValue).toArray();
        int[] targetBit = new int[31];
        int[] numsBit = new int[31];
        //将 target 按位拆解
        int i = 0;
        while (target > 0) {
            targetBit[i] = target % 2;
            i++;
            target /= 2;
        }

        return 0;
    }*/
}
