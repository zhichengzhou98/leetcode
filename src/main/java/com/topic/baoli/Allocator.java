package com.topic.baoli;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2502. 设计内存分配器
 * @create 2025-02-25 21:11
 */
public class Allocator {
  public static void main(String[] args) {
    Allocator all = new Allocator(10);
    System.out.println(all.allocate(1, 1));
  }
  int[] arr;
  public Allocator(int n) {
    arr = new int[n];
  }

  public int allocate(int size, int mID) {
    int left = 0;
    while (true) {
      // 寻找最左的端点
      while (left < arr.length && arr[left] != 0) {
        left++;
      }
      if (left == arr.length) {
        return -1;
      }
      int right = left;
      int tmp = size;
      while (right < arr.length && arr[right] == 0) {
        tmp--;
        right++;
        if (tmp == 0) {
          Arrays.fill(arr, left, right, mID);
          return left;
        }
      }
      left = right;
    }
  }

  public int freeMemory(int mID) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == mID) {
        res++;
        arr[i] = 0;
      }
    }
    return res;
  }
}
