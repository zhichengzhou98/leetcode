package com.topic.slidwindow;

/**
 * @author zc.zhou
 * @Description 3208. 交替组 II 滑动窗口
 * @create 2024-11-26 21:19
 */
public class NumberOfAlternatingGroups {

  public int numberOfAlternatingGroups(int[] colors, int k) {
    int res = 0;
    int left = 0;
    int size = colors.length;
    while (left < size) {
      int right = left + 1;
      // 满足条件时 right 右移直到不满足条件
      while (right < size + k - 1 && colors[right % size] != colors[(right-1) % size]) {
        right++;
      }
      // [left,right - 1] 都是交替的 -> 一共（r - 1 - l + 1） 个数， k个一组
      // -> 共 （r - 1 - l + 1） - （k - 1）组
      res = res + Math.max(0, right - k - left + 1);
      left = right;
    }
    return res;
  }
  public int numberOfAlternatingGroupsV1(int[] colors, int k) {
    int res = 0;
    int left = 0;
    int size = colors.length;
    int[] tar = new int[size + k - 1];
    for (int i = 0; i < tar.length; i++) {
      tar[i] = colors[i % size];
    }
    while (left < size) {
      int right = left + 1;
      // 满足条件时 right 右移直到不满足条件
      while (right < tar.length && tar[right] != tar[right-1]) {
        right++;
      }
      // [left,right - 1] 都是交替的 -> 一共（r - 1 - l + 1） 个数， k个一组
      // -> 共 （r - 1 - l + 1） - （k - 1）组
      res = res + Math.max(0, right - k - left + 1);
      left = right;
    }
    return res;
  }
}
