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
   * 第300题 o(nlogn)
   * o(n²)
   * @param list 获取list的最长非递减序列的长度
   * @return 最长非递减序列的长度
   */
  private int getMaxLenNonDesc(List<Integer> list) {
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
