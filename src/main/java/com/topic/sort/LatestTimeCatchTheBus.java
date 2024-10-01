package com.topic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description 2332
 * @create 2024-09-18 11:06
 */
public class LatestTimeCatchTheBus {
  @Test
  void testFun() {
    /*int[] buses = {5};
    int[] passengers = {7,8};*/
    /*int[] buses = {3};
    int[] passengers = {2, 4};*/
    /*int[] buses = {20, 30, 10};
    int[] passengers = {19, 13, 26, 4, 25, 11, 21};*/
    int[] buses = {10,20};
    int[] passengers = {2,17,18,19};
    /*int[] buses = {2};
    int[] passengers = {2};*/
    System.out.println(latestTimeCatchTheBus(buses, passengers, 2));
  }


  public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    Arrays.sort(buses);
    Arrays.sort(passengers);
    Set<Integer> passengerSet = new HashSet<>();
    for(int p : passengers) {
      passengerSet.add(p);
    }
    int res = 0;
    int left = 0;
    for (int i = 0; i < buses.length; i++) {
      int curBus = buses[i];
      //统计能上当前车的乘客
      int cnts = 0;
      int right = left;
      while (cnts < capacity && right < passengers.length && passengers[right] <= curBus) {
        right++;
        cnts++;
      }
      int current;
      if (cnts >= capacity) {
        //当前车满员 乘客为[left, right - 1]
        //插队到right - 1之前
        current = passengers[right - 1] - 1;
      } else {
        //当前车没有满员
        current = curBus;
      }
      left = right;
      for (int j = current; j > res; j--) {
        if (!passengerSet.contains(j)) {
          res = j;
          break;
        }
      }
    }
    return res;
  }

  public int latestTimeCatchTheBusV1(int[] buses, int[] passengers, int capacity) {
    Arrays.sort(buses);
    Arrays.sort(passengers);
    Set<Integer> passengerSet = Arrays.stream(passengers).boxed().collect(Collectors.toSet());
    int res = passengers[0] - 1;
    int left = 0;
    for (int i = 0; i < buses.length; i++) {
      int curBus = buses[i];
      //找右边界 在passengers中 小于等于curBus
      // 检查区间端点
      // 没有人能赶上当前这趟车
      if (left >= passengers.length || passengers[left] > curBus) {
        //更新res
        res = curBus;
        continue;
      }
      //二分
      int right = rightBoundary(passengers, curBus, left);
      int j;
      //[left, right] 之中的人都能赶上 但是最多只能上capacity个人
      if (capacity <= right - left + 1) {
        //更新之后的右边界
        right = left + capacity - 1;
        j = passengers[right] - 1;
      } else {
        j = curBus;
      }

      while (j >= 0) {
        if (!passengerSet.contains(j)) {
          res = j;
          break;
        }
        j--;
      }
      left = right + 1;
    }
    return res;
  }

  //查找右边界 小于等于 target的最大值  checkMedRight 小于等于时为true！！！
  public int rightBoundary(int[] nums, int target, int l) {
    int r = nums.length - 1;
    int med = (r - l + 1) / 2 + l;
    while (l < r) {
      if (checkMedRight(nums[med], target)) {
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
    return med <= target;
  }
}
