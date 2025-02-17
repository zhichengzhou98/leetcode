package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description [1287]有序数组中出现次数超过25%的元素
 * @create 2025-02-17 9:01
 */
public class FindSpecialInteger {
  @Test
  void testFun() {
    int[] arr = {1, 2, 3, 3};
    System.out.println(findSpecialInteger(arr));
  }

  public int findSpecialInteger(int[] arr) {
    int n = arr.length;
    int cnts = 0;
    if (n % 4 == 0) {
      cnts = n / 4 + 1;
    } else {
      cnts = (n + 3) / 4;
    }
    for (int i = 0; i < arr.length; i++) {
      if (i + cnts - 1 < n) {
        if (arr[i + cnts - 1] == arr[i]) {
          return arr[i];
        }
      } else {
        return arr[i];
      }
    }
    return arr[n - 1];
  }
}
