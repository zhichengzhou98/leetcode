package com.topic.binarysearch;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 3288 最长上升路径的长度 TODO
 * @create 2024-09-20 17:52
 */
public class MaxPathLength {
  @Test
  void testFun() throws IOException {
    // [[5,0],[9,3],[9,8]]
    int[][] coordinates = ArrayUtils.generate("array", int[][].class);
    System.out.println(maxPathLength(coordinates, 0));
  }

  public int maxPathLength(int[][] coordinates, int k) {
    int[] current = coordinates[k];
    //按横坐标升序排列
    Arrays.sort(coordinates, Comparator.comparingInt(a -> a[0]));
    //current之前的纵坐标的集合
    List<Integer> before = new ArrayList<>();
    for (int[] nums : coordinates) {
      if (nums[0] >= current[0]) {
        break;
      }
      if (nums[1] < current[1]) {
        before.add(nums[1]);
      }

    }
    //current之后的纵坐标的集合
    List<Integer> after = new ArrayList<>();
    for (int[] nums : coordinates) {
      if (nums[0] <= current[0]) {
        continue;
      }
      if (nums[1] > current[1]) {
        after.add(nums[1]);
      }
    }
    //求 before after的最长递增子序列
    return longestIncreasingSubsequence(before) + longestIncreasingSubsequence(after) + 1;
  }

  private int longestIncreasingSubsequence(List<Integer> list) {
    if (list.isEmpty()) {
      return 0;
    }
    List<Integer> dp = new ArrayList<>();
    dp.add(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      int current = list.get(i);
      //找到dp中大于等于current的第一个索引 => 二分查找左边界
      //检查右边界
      if (current > dp.get(dp.size() - 1)) {
        dp.add(current);
        continue;
      }
      int index = leftBoundary(dp, current);
      //替换当前值为current
      dp.set(index, current);
    }
    return dp.size();
  }

  private boolean checkMed(int med, int target) {
    if (med >= target) {
      return true;
    }
    return false;
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  //使用之前需要检查右边界是否满足 => 右边界都不满足（右边界小于（等于） target），区间所有值都不满足
  //如果checkMed返回true时 取到等号， 检查边界时就不需要取到等号
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
}
