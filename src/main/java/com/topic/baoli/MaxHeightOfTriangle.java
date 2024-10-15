package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3200 三角形的最大高度
 * @create 2024-10-15 9:08
 */
public class MaxHeightOfTriangle {
  public int maxHeightOfTriangle(int red, int blue) {
    return Math.max(maxHeight(new int[]{red, blue}), maxHeight(new int[]{blue, red}));
  }

  private int maxHeight(int[] balls) {
    int n = 1;
    int h = 0;
    int index = 0;
    while (balls[index]>= n) {
      balls[index] -= n;
      n++;
      index = (index + 1) % 2;
      h++;
    }
    return h;
  }
}
