package com.topic.backtrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description [2597]美丽子集的数目 回溯
 * @create 2025-03-07 15:09
 */
public class BeautifulSubsets {
  @Test
  public void test() {
    int[] arr = {2, 4, 6};
    System.out.println(beautifulSubsets(arr, 2));
  }

  int res = 0;
  int[] nums;

  int k;

  public int beautifulSubsets(int[] nums, int k) {
    this.nums = nums;
    this.k = k;
    dfs(0, new ArrayList<>());
    // 减去全不选的情况
    return res - 1;
  }

  public void dfs(int index, List<Integer> added) {
    if (index == nums.length) {
      res++;
      return;
    }
    int cur = nums[index];
    List<Integer> list = new ArrayList<>(added);
    boolean canSelect = true;
    // 选或者不选
    for (int num : list) {
      if (Math.abs(num - cur) == k) {
        canSelect = false;
        break;
      }
    }
    if (canSelect) {
      list.add(cur);
      dfs(index + 1, list);
      //回溯
      list.remove(list.size() - 1);
    }
    dfs(index + 1, list);
  }
}
