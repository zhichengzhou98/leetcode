package com.zzc.binarySearch;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 12:24
 */
public class MaximumMinutes {
  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 9, 3};
    System.out.println(maxValue(arr));
  }

  public static long maxValue(int[] nums) {
    long[] arr = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      arr[i] = nums[i];
    }
    long max = Integer.MIN_VALUE;
    if (nums.length == 1) {
      return nums[0];
    }
    long temp = 0;
    for (int i = nums.length - 1; i >= 1; i--) {
      long pre = arr[i - 1];
      long current = arr[i];
      if (current >= pre) {
        temp = current + pre;
        arr[i - 1] = temp;
      } else {
        max = Math.max(max, temp);
        temp = 0;
      }

    }
    return Math.max(arr[0], temp);
  }
}
