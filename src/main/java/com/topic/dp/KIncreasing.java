package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2111
 * @create 2024-09-10 13:29
 */
public class KIncreasing {
  @Test
  void testFun() {
    List<Integer> list = List.of(12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3);
    int[] arr = {5, 4, 3, 2, 1};
    System.out.println(kIncreasing(arr, 1));
    System.out.println(getMaxLenNonDesc(list));
  }

  public int kIncreasing(int[] arr, int k) {
    int res = 0;
    List[] lists = new List[k];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<Integer>();
    }
    //把arr分组
    for (int i = 0; i < arr.length; i++) {
      int tmp = i % k;
      lists[tmp].add(arr[i]);
    }
    //保证lists中每个链表都是非递减的
    for (int i = 0; i < lists.length; i++) {
      res = res + lists[i].size() - getMaxLenNonDesc(lists[i]);
    }
    return res;
  }

  /**
   * 获取最长非递减子序列 => 300 最长递增子序列
   * @param nums
   * @return
   */
  public int getMaxLenNonDesc(List<Integer> nums) {
    List<Integer> dp = new ArrayList<>();
    //dp[i] -> i 表示以dp[i]为结尾的最长非递减子序列的长度
    dp.add(nums.get(0));
    for (int i = 1; i < nums.size(); i++) {
      //查找左边界 找到第一个比num[i]大的索引  不需要取等
      //非递减子序列 => 相同的数字可以出现多次 => 二分法中check函数不能取等号（找严格大于等于target的index） => 判断边界时就不需要等号
      int current = nums.get(i);
      if (current >= dp.get(dp.size() - 1)) {
        //大于等于最大值 直接放到右边
        dp.add(current);
      } else {
        int index = leftBoundary(dp, current);
        //更新当前index的值为current
        dp.set(index, current);
      }
    }
    return dp.size();
  }

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
    return current > tar;
  }

  /**
   * 第300题 o(nlogn)
   * o(n²)
   * @param list 获取list的最长非递减序列的长度
   * @return 最长非递减序列的长度
   */
  private int getMaxLenNonDescV1(List<Integer> list) {
    //dp[i]表示以i结尾最长的非递减子序列
    int[] dp = new int[list.size()];
    Arrays.fill(dp, 1);
    int maxRes = 1;
    for (int i = 1; i < dp.length; i++) {
      int cur = list.get(i);
      for (int j = 0; j < i; j++) {
        int pre = list.get(j);
        if (cur >= pre) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
          maxRes = Math.max(maxRes, dp[i]);
        }
      }
    }
    return maxRes;
  }
}
