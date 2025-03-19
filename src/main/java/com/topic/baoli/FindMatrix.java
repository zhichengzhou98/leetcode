package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description [2610]转换二维数组
 * @create 2025-03-19 14:47
 */
public class FindMatrix {
  @Test
  public void testFun() {
    int[] arr = {1, 3, 4, 1, 2, 3, 1};
    System.out.println(findMatrix(arr));
  }

  public List<List<Integer>> findMatrix(int[] nums) {
    Arrays.sort(nums);
    int cur = nums[0];
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    list.add(cur);
    res.add(list);
    int size = 1;
    int curIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num == cur) {
        curIndex++;
        if (curIndex >= size) {
          List<Integer> list1 = new ArrayList<>();
          list1.add(num);
          res.add(list1);
          size++;
        } else {
          List<Integer> list1 = res.get(curIndex);
          list1.add(num);
        }
      } else {
        curIndex = 0;
        res.get(curIndex).add(num);
      }
      cur = nums[i];
    }
    return res;
  }
}
