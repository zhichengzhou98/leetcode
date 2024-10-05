package com.topic.binarysearch;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2187. 完成旅途的最少时间
 * @create 2024-10-05 08:13
 */
public class MinimumTime {

  @Test
  void testFun() {
    int[] times = {1,2,3};
    System.out.println(minimumTime(times, 5));
  }

  int[] time;
  int totalTrips;
  public long minimumTime(int[] time, int totalTrips) {
    int n = time.length;
    this.time = time;
    this.totalTrips = totalTrips;
    //最长的花费时间
    int maxTime = Integer.MIN_VALUE;
    int minTime = Integer.MAX_VALUE;
    for (int t : time) {
      maxTime = Math.max(t, maxTime);
      minTime = Math.min(t, minTime);
    }
    //评价每辆车需要完成的旅程数 上取整
    int tripes = (totalTrips - 1) / n + 1;
    //右边界
    long r = (long) tripes * maxTime;
    long l = (long) tripes * minTime;
    //二分查左边界
    return leftBoundary(l, r);
  }

  public boolean checkMed(long med) {
    long trips = 0;
    for (int t :time) {
      trips += med / t;
    }
    return trips >= totalTrips;
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  //使用之前需要检查右边界是否满足 => 右边界都不满足（右边界小于（等于） target），区间所有值都不满足
  //如果checkMed返回true时 取到等号， 检查边界时就不需要取到等号
  public long leftBoundary(long l, long r) {
    long med = ((r - l) >> 1) + l;
    while (l < r) {
      if (checkMed(med)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = ((r - l) >> 1) + l;
    }
    return med;
  }
}
