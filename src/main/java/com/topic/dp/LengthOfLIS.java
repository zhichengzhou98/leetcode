package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 300 最长递增子序列
 * @create 2024-09-18 14:40
 */
public class LengthOfLIS {
  @Test
  void testBinarySearch() {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 3, 7, 9, 11));
    int index = Collections.binarySearch(list, 3);
    System.out.println(index);
    if (index < 0) {
      index = -(index + 1);
    }
    //list.add(index, 6);
    System.out.println(list);
  }

  @Test
  void testLengthOfLIS() {
    int[] arr = {7, 7, 7, 7};
    System.out.println(lengthOfLIS(arr));
  }

  public int lengthOfLIS(int[] nums) {
    List<Integer> dp = new ArrayList<>();
    //dp[i] -> i 表示以dp[i]为结尾的最长递增子序列的长度
    dp.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      //查找左边界 找到第一个比num[i]大的索引  需要取等
      //严格递增 => 相同的数字只能出现一次 => 二分法中check函数需要取等号 => 判断边界时就不需要等号
      int current = nums[i];
      if (current > dp.get(dp.size() - 1)) {
        //大于最大值 直接放到右边
        dp.add(current);
      } else {
        int index = leftBoundary(dp, current);
        //更新当前index的值为current
        dp.set(index, current);
      }
    }
    return dp.size();
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  private int leftBoundary(List<Integer> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (checkMed(nums.get(med), target)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }

  private boolean checkMed(int current, int tar) {
    return current >= tar;
  }

  @Test
  void testLeftBoundary() {
    List<Integer> list = new ArrayList<>(List.of(3, 4, 5, 9));
    int index = leftBoundary(list, 8);
    list.add(index, 8);
    System.out.println(list);
  }

  public int lengthOfLISV1(int[] nums) {
    int res = 1;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    //dp[i] 表示以nums[i]为结尾的最长递增子序列的长度
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(res, dp[i]);
        }
      }
    }
    return res;
  }
}
