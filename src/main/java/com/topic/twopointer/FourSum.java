package com.topic.twopointer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 18. 四数之和
 * @create 2024-12-04 20:52
 */
public class FourSum {
  @Test
  void testFun() {
    int[] nums = {1000000000,1000000000,1000000000,1000000000};
    System.out.println(fourSum(nums, -294967296));
  }
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    // 枚举起点
    for (int i = 0; i < nums.length - 3; i++) {
      while (i < nums.length - 3 && i > 0 && nums[i] == nums[i-1]) {
        i++;
      }
      if (i == nums.length - 3) {
        break;
      }
      long first = nums[i];
      // 枚举第二个点
      for (int j = i + 1; j < nums.length - 2; j++) {
        while (j < nums.length - 2 && j > i + 1 && nums[j] == nums[j-1]) {
          j++;
        }
        if (j == nums.length - 2) {
          break;
        }
        long second = nums[j];
        // 双指针
        int left = j + 1;
        int right = nums.length - 1;
        while (right > left) {
          while (right > left && left > j + 1 && nums[left] == nums[left-1]) {
            left++;
          }
          if (left >= right) {
            break;
          }
          if (nums[right] + nums[left] == target - first - second) {
            res.add(List.of((int)first, (int)second, nums[left], nums[right]));
            right--;
            left++;
          } else if (nums[right] + nums[left] > target - first - second) {
            right--;
          } else {
            left++;
          }
        }
      }
    }
    return res;
  }
}
