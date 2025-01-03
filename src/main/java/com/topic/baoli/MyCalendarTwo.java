package com.topic.baoli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 731.我的日程安排表II todo
 * @create 2025-01-03 9:05
 */
public class MyCalendarTwo {
  List<int[]> data;

  public MyCalendarTwo() {
    data = new ArrayList<>();
  }

  public boolean book(int startTime, int endTime) {
    if (data.isEmpty()) {
      data.add(new int[]{startTime, endTime});
      return true;
    }
    int cnt = 0;
    for (int[] arr : data) {
      int b = arr[0];
      int e = arr[1];
      if (endTime > b && startTime < e) {
        cnt++;
        if (cnt == 2) {
          break;
        }
      }
    }
    if (cnt < 2) {
      data.add(new int[]{startTime, endTime});
      return true;
    }
    return false;
  }
}
