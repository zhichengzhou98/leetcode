package com.topic.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 16. 最接近的三数之和
 * @create 2024-12-04 20:32
 */
public class ThreeSumClosest {
  @Test
  void testFun() {
    int[] res = {4,0,5,-5,3,3,0,-4,-5};
    System.out.println(threeSumClosest(res, -2));
  }
  public int threeSumClosest(int[] nums, int target) {
    int res = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      // 枚举起点
      int first = nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      while (right > left) {
        int tar = first + nums[left] + nums[right];
        if (tar == target) {
          return tar;
        } else if (tar > target) {
          if (tar - target < Math.abs(target - res)) {
            res = tar;
          }
          right--;
        } else {
          // tar < target
          if (target - tar < Math.abs(target - res)) {
            res = tar;
          }
          left++;
        }
      }
    }
    return res;
  }
}
