package com.topic.presum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description [2080]区间内查询数字的频率 哈希表+二分
 * @create 2025-02-18 16:08
 */
public class RangeFreqQuery {

  public static void main(String[] args) {
    int[] arr = {8, 4, 2, 5, 4, 5, 8, 6, 2, 3};
    RangeFreqQuery query = new RangeFreqQuery(arr);
    int[] q1 = {0, 3, 5};
    int[] q2 = {5, 6, 2};
    int[] q3 = {6, 8, 4};
    int[] q4 = {2, 8, 3};
    int[] q5 = {4, 5, 1};
    int[] q6 = {2, 4, 2};
    System.out.println(query.query1(q1));
    System.out.println(query.query1(q2));
    System.out.println(query.query1(q3));
    System.out.println(query.query1(q4));
    System.out.println(query.query1(q5));
    System.out.println(query.query1(q6));
  }

  /**
   * 1 <= arr.length <= 10⁵
   * 1 <= arr[i], value <= 10⁴
   * 0 <= left <= right < arr.length
   * 调用 query 不超过 10⁵ 次。
   *
   * @param arr
   */
  List[] lists;

  public RangeFreqQuery(int[] arr) {
    // 初始化lists
    int n = arr.length;
    int maxSize = (int) (1e4 + 1);
    lists = new List[maxSize];
    for (int i = 0; i < maxSize; i++) {
      lists[i] = new ArrayList();
    }
    for (int i = 0; i < n; i++) {
      lists[arr[i]].add(i);
    }
  }

  public int query1(int[] q) {
    return this.query(q[0], q[1], q[2]);
  }

  public int query(int left, int right, int value) {
    // 值为value的索引列表 递增 -> 二分法
    List<Integer> list = lists[value];
    // right -> 查找小于等于right的右边界 -> 判断左边界
    // left -> 查找大于等于left的左边界 -> 判断右边界
    if (list.isEmpty() || list.get(0) > right || list.get(list.size() - 1) < left) {
      return 0;
    }
    int rightIndex = rightBoundary(list, right);
    int leftIndex = leftBoundary(list, left);
    return rightIndex - leftIndex + 1;
  }


  public boolean checkMed(int med, int target) {
    if (med >= target) {
      return true;
    }
    return false;
  }

  //查找左边界: 满足checkMed的最小值  大于（等于）target的最小值（取等于时， checkMed判断条件也需要取等于）
  //使用之前需要检查右边界是否满足 => 右边界都不满足（右边界小于（等于） target），区间所有值都不满足
  //如果checkMed返回true时 取到等号， 检查边界时就不需要取到等号
  public int leftBoundary(List<Integer> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l) / 2 + l;
    while (l < r) {
      if (checkMed(nums.get(med), target)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }

  private int rightBoundary(List<Integer> nums, int target) {
    int l = 0;
    int r = nums.size() - 1;
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(nums.get(med), target)) {
        //满足条件时 => 如果题目要求小于等，则checkMedRight 在小于等于时返回true
        l = med;
      } else {
        r = med - 1;
      }
      med = (r - l + 1) / 2 + l;
    }
    return med;
  }

  private boolean checkMedRight(int med, int target) {
    //[1, 2, 3, 4, 5, 8] target => 8
    // √  √  √  √  √  √
    if (med > target) {
      return false;
    }
    //满足题目要求时 返回true
    //med <= target => 题目要求找 小于等于target的值
    return true;
  }
}
