package com.topic.baoli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 1656. 设计有序流
 * @create 2025-02-24 22:33
 */
public class OrderedStream {
  String[] arr;
  int p;

  public OrderedStream(int n) {
    arr = new String[n];
    p = 0;
  }

  public List<String> insert(int idKey, String value) {
    // 插入数据
    arr[idKey - 1] = value;
    List<String> res = new ArrayList<>();
    while (p < arr.length && arr[p] != null) {
      res.add(arr[p]);
      p++;
    }
    return res;
  }
}
