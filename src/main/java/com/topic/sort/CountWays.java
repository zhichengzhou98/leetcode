package com.topic.sort;

import java.util.Collections;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2860 排序 + 枚举
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] < nums.length
 * @create 2024-09-04 16:09
 */
public class CountWays {
  public int countWays(List<Integer> nums) {
    int res = 0;
    //将nums升序排列
    Collections.sort(nums);
    //[0, 1]
    //全不选
    if (nums.get(0) > 0) {
      res++;
    }
    //寻找分组点
    for (int i = 0; i < nums.size() - 1; i++) {
      //当前选中人数
      int count = i + 1;
      if (count > nums.get(i) && count < nums.get(i + 1)) {
        res++;
      }
    }
    //全选
    if (nums.get(nums.size()-1) < nums.size()) {
      res++;
    }
    return res;
  }
}
