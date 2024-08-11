package com.topic.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-11 11:55
 */
public class MaxUncrossedLines {

  Map<Integer, List<Integer>> map;
  Map<String, Integer> res;
  int[] n1;
  int[] n2;
  public int maxUncrossedLines(int[] nums1, int[] nums2) {
    n1 = nums1;
    n2 = nums2;
    //记录nums2每个数值出现的索引
    map = new HashMap<>();
    res = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      int num = nums2[i];
      if (map.containsKey(num)) {
        map.get(num).add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(num, list);
      }
    }

    return dfs(0, 0);
  }

  private int dfs(int p1, int p2) {
    if(p1 >= n1.length || p2 >= n2.length) {
      return 0;
    }
    String key = p1 + "," + p2;
    if (res.containsKey(key)) {
      return res.get(key);
    }
    //获取nums1中当前的值
    int num1 = n1[p1];
    //当前数值没有匹配的
    if (!map.containsKey(num1) ) {
      return dfs(p1 + 1, p2);
    }
    List<Integer> list = map.get(num1);
    //当前数值没有匹配的
    if (list.get(list.size() - 1) < p2) {
      return dfs(p1 + 1, p2);
    }
    //当前数值有匹配的 求list中大于等于p2的最小值 二分查左边界
    int nextP2 = leftBoundary(list, p2);
    //不匹配当前的
    int res1 = dfs(p1 + 1, p2);
    //匹配当前的
    int res2 = 1 + dfs(p1 + 1, nextP2 + 1);
    res.put(key, Math.max(res1, res2));
    return Math.max(res1, res2);
  }

  public int leftBoundary(List<Integer> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (nums.get(med)>= target) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return nums.get(med);
  }
}
