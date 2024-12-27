package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 3159.查询数组中元素的出现位置
 * @create 2024-12-27 8:58
 */
public class OccurrencesOfElement {
  @Test
  void test() {
    int[] nums = {1, 3, 1, 7};
    int[] q = {1, 3, 2, 4};
    System.out.println(Arrays.toString(occurrencesOfElement(nums, q, 1)));
  }

  public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
    List<Integer> index = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == x) {
        index.add(i);
      }
    }
    int[] res = new int[queries.length];
    for (int i = 0; i < res.length; i++) {
      int q = queries[i];
      if (q <= index.size()) {
        res[i] = index.get(q - 1);
      } else {
        res[i] = -1;
      }
    }
    return res;
  }
}
