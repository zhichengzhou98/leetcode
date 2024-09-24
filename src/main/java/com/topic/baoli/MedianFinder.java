package com.topic.baoli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 295. 数据流的中位数 二分法 TODO list.add(index, num) 并非o(1)时间复杂度
 * @create 2024-09-24 19:30
 */
public class MedianFinder {
  List<Integer> list;
  int n;

  public MedianFinder() {
    list = new ArrayList<>();
    n = 0;
  }

  public void addNum(int num) {
    if (n == 0 || num >= list.get(n - 1)) {
      list.add(num);
    } else {
      //二分法找到要插入的位置 查找左边界 大于当前num的索引
      int index = leftBoundary(num);
      //插入时间复杂度并非o(1)
      list.add(index, num);
    }
    n++;
  }


  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  //使用之前需要检查右边界是否满足 => 右边界都不满足（右边界小于（等于） target），区间所有值都不满足
  //如果checkMed返回true时 取到等号， 检查边界时就不需要取到等号
  private int leftBoundary(int target) {
    int l = 0;
    int r = n - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (list.get(med) > target) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }

  public double findMedian() {
    if (n % 2 == 0) {
      return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
    } else {
      return list.get(n / 2);
    }
  }
}
