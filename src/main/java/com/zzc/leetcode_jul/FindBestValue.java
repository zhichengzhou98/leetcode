package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-30 10:26
 */
public class FindBestValue {
  @Test
  void testFun() {
    int[] arr = {1547, 83230, 57084, 93444, 70879};
    System.out.println(findBestValue(arr, 71237));
  }

  private int find(List<Integer> list, int target) {
    int len = list.size();
    int first = list.get(0);
    if (target <= len * first) {
      int value = target / len;
      return Math.abs(target - (value + 1) * len) <
          Math.abs(target - value * len) ? (value + 1) : value;
    }
    target -= list.remove(0);
    return find(list, target);
  }

  //[4, 10, 20] -> 14
  //1 2 3 -> 15
  public int findBestValue(int[] arr, int target) {
    Arrays.sort(arr);
    List<Integer> collect = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
    int sum = Arrays.stream(arr).sum();
    if (target >= sum) {
      return collect.get(collect.size() - 1);
    }
    return find(collect, target);
  }

  //[4, 10, 20] -> 14
  //1 2 3 -> 15
  public int findBestValueV2(int[] arr, int target) {
    Arrays.sort(arr);
    int len = arr.length;
    int first = arr[0];
    int last = arr[len - 1];
    //前缀和
    int[] preSum = new int[len];
    preSum[0] = first;
    for (int i = 1; i < len; i++) {
      preSum[i] = preSum[i - 1] + arr[i];
    }
    if (target >= preSum[len - 1]) {
      return last;
    }
    if (target <= len * first) {
      int value = target / len;
      int value1 = value + 1;

      int delt = Math.abs(target - value * len);
      int delt1 = Math.abs(target - value1 * len);
      return delt1 < delt ? value1 : value;
    }
    //value一定是arr中的值
    int delt = Math.abs(target - len * first);
    int res = first;
    //枚举value
    int temp = 0;
    for (int i = first; i <= last; i++) {
      //找到数组arr中第一个大于等于i的下标
      while (temp < len && arr[temp] < i) {
        temp++;
      }
      if (temp < len) {
        //从temp项开始 值都是i
        int tempSum = (len - temp) * i;
        if (temp > 0) {
          tempSum += preSum[temp - 1];
        }
        int tempDelt = Math.abs(target - tempSum);
        if (tempDelt < delt) {
          res = i;
          delt = tempDelt;
        }
      } else {
        break;
      }
    }
    return res;
  }
}
