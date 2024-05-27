package com.zzc.leetcode_may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-09 10:53
 */
public class ThreeNums {

    @Test
    public void testFun() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeNums(nums));
    }


    public List<List<Integer>> threeNums(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int current = nums[i];
            while (right > left) {
                if (current + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(current);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else if (current + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
