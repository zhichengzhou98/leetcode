package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 2717.半有序排列
 * @create 2024-12-11 8:58
 */
public class SemiOrderedPermutation {
  public int semiOrderedPermutation(int[] nums) {
    int n = nums.length;
    // 计算1和n所在的index
    int index1 = 0;
    int indexN = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        index1 = i;
      } else if (nums[i] == n) {
        indexN = i;

      }
    }
    if (indexN < index1) {
      res--;
    }
    res = res + (index1) + (n - 1) - indexN;
    return res;
  }
}
