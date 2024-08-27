package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 3134
 * @create 2024-08-27 10:05
 */
public class MedianOfUniquenessArray {

  @Test
  void testFun() {
    for (int i = 100; i < 110; i++) {
      String str = String.format("数组长度为%d, 中位数位置为%d", i, size(i));
      System.out.println(str);
    }
  }

  //求数组长度与中位数出现位置的对应的关系
  private int size(int len) {
    return ((len + 1) * len / 2 - 1) / 2;
  }

  public int medianOfUniquenessArray(int[] nums) {

    return 0;
  }

}
