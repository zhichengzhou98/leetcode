package com.topic.baoli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 729. 我的日程安排表 I
 * @create 2025-01-02 20:32
 */
public class MyCalendar {
  List<int[]> data;

  public MyCalendar() {
    data = new ArrayList<>();
  }

  public boolean book(int startTime, int endTime) {
    if (data.isEmpty()) {
      data.add(new int[]{startTime, endTime});
      return true;
    }
    boolean flag = true;
    for (int[] arr : data) {
      int b = arr[0];
      int e = arr[1];
      if (endTime > b && startTime < e) {
        flag = false;
        break;
      }
    }
    if (flag) {
      data.add(new int[]{startTime, endTime});
    }
    return flag;
  }
}
