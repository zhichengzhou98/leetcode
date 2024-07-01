package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-01 22:09
 */
public class Dp01 {
  public static void main(String[] args) {
    int[] arr = new int[20240702];
    for (int i = 1; i < arr.length; i++) {
      if (i % 2 == 0) {
        arr[i] = Math.min(arr[i - 1] + 1, arr[i / 2] + 1);

      } else {
        arr[i] = arr[i - 1] + 1;
      }
    }
    System.out.println(arr[20240701]);
  }
}
