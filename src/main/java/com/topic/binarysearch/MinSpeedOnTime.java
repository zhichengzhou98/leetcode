package com.topic.binarysearch;

/**
 * @author zc.zhou
 * @Description 1870. 准时到达的列车最小时速
 * @create 2024-10-02 13:09
 */
public class MinSpeedOnTime {

  int[] dist;
  double hour;
  public int minSpeedOnTime(int[] dist, double hour) {
    int size = dist.length;
    if (hour <= size - 1) {
      return -1;
    }
    int l = 1;
    int r = (int) 1e7;
    this.dist = dist;
    this.hour = hour;
    //二分查找左边界
    return leftBoundary(l, r);
  }

  public boolean checkMed(int speed) {
    double needTime = 0.0;
    for (int i = 0; i < dist.length - 1; i++) {
      needTime += Math.ceil((double) dist[i] / speed);
    }
    needTime += (double) dist[dist.length - 1] / speed;
    return needTime <= hour;
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  //使用之前需要检查右边界是否满足 => 右边界都不满足（右边界小于（等于） target），区间所有值都不满足
  //如果checkMed返回true时 取到等号， 检查边界时就不需要取到等号
  public int leftBoundary(int l, int r) {
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (checkMed(med)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }
}
