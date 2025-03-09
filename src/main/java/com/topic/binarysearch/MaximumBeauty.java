package com.topic.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2070. 每一个查询的最大美丽值 二分+排序
 * @create 2025-03-09 20:02
 */
public class MaximumBeauty {
  public int[] maximumBeauty(int[][] items, int[] queries) {
    // 按价格升序排列
    Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
    List<int[]> list = new ArrayList<>();
    int curPrice = items[0][0];
    int curBeauty = items[0][1];
    for (int i = 1; i < items.length; i++) {
      int price = items[i][0];
      int beauty = items[i][1];
      if (curPrice != price) {
        list.add(new int[]{curPrice, curBeauty});
        curPrice = price;
      }
      curBeauty = Math.max(beauty, curBeauty);
    }
    list.add(new int[]{curPrice, curBeauty});
    // 二分右边界 小于等于
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int q = queries[i];
      if (q < list.get(0)[0]) {
        res[i] = 0;
      } else {
        res[i] = rightBoundary(list, q);
      }
    }
    return res;
  }

  public int rightBoundary(List<int[]> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(nums.get(med)[0], target)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return nums.get(med)[1];
  }

  public boolean checkMedRight(int med, int target) {
    //[1, 2, 3, 4, 5, 8] target => 8
    // √  √  √  √  √  √
    if (med > target) {
      return false;
    }
    //满足题目要求时 返回true
    //med <= target => 题目要求找 小于等于target的值
    return true;
  }
}
