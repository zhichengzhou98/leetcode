package com.topic.diffarray;

import java.util.List;

/**
 * @author zc.zhou
 * @Description 2848. 与车相交的点 差分数组
 * @create 2024-09-15 08:16
 */
public class NumberOfPoints {
  /**
   * 1 <= nums.length <= 100
   * nums[i].length == 2
   * 1 <= starti <= endi <= 100
   * 时间复杂度 o(m + n) m: max(num[i])   n: nums.length
   * @param nums
   * @return
   */
  public int numberOfPoints(List<List<Integer>> nums) {
    int[] diff = new int[102];
    for(List<Integer> list : nums) {
      diff[list.get(0)]++;
      diff[list.get(1) + 1]--;
    }
    for (int i = 1; i < diff.length; i++) {
      diff[i] = diff[i- 1] + diff[i];
    }
    int cnts = 0;
    for (int i = 1; i <= 100; i++) {
      if (diff[i] >= 1) {
        cnts++;
      }
    }
    return cnts;
  }
}
