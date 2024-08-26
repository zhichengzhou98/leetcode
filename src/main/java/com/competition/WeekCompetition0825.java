package com.competition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-25 10:17
 */
public class WeekCompetition0825 {
  @Test
  void testFun() {
    int[] arr = new int[]{889458628,338743558,875422936,684907163,233489834};
    System.out.println(Arrays.toString(getFinalState(arr, 246181588, 313380)));
    //System.out.println(countPairs(arr));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);

  public int[] getFinalState(int[] nums, int k, int multiplier) {
    int len = nums.length;

    //记录每个位置乘以multiplier的次数
    int[] cntArr = new int[len];

    if (multiplier == 1) {
      return nums;
    }
    //优先队列
    //0：nums[i] i: 1
    Queue<long[]> pq = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0]) {
        return Long.compare(a[1], b[1]);
      }
      return Long.compare(a[0], b[0]);
    });
    long max = Long.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      pq.offer(new long[]{nums[i], i});
    }
    //当堆顶元素小于最大值时
    while (pq.peek()[0] < max && k > 0) {
      long[] poll = pq.poll();
      poll[0] *= multiplier;
      cntArr[(int) poll[1]]++;
      k--;
      pq.offer(poll);
    }
    //剩下的操作次数会依次作用给每个数
    if (k > 0) {
      int cnts = k / len;
      //有cnts1个数需要多乘以一次multiplier
      int cnts1 = k % len;
      for (int i = 0; i < cntArr.length; i++) {
        cntArr[i] += cnts;
      }
      //记录每个位置乘以multiplier的次数
      //依次移除最小值
      //不需要再放回队列
      while (cnts1 > 0) {
        long[] poll = pq.poll();
        poll[0] = poll[0] * multiplier;
        cntArr[(int) poll[1]]++;
        cnts1--;
      }
    }
    //记录每个位置乘以multiplier的次数
    for (int i = 0; i < len; i++) {
      long tmp = exponentiationBySquaring(multiplier, cntArr[i]);
      nums[i] = (int) (tmp * nums[i] % MOD);
    }
    return nums;
  }

  public long exponentiationBySquaring(int a, int b) {
    //求a的b次幂
    if (b == 1) {
      return a % MOD;
    }

    if (b == 0) {
      return 1;
    }

    if (b % 2 == 0) {
      long x = exponentiationBySquaring(a, b / 2) % MOD;
      return x * x % MOD;
    }
    long y = exponentiationBySquaring(a, (b - 1) / 2) % MOD;
    return y * y % MOD * a % MOD;
  }

  public int countPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int res = 0;
    //统计每个数出现的次数
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      set.add(num);
    }
    List<Integer> list = map.values().stream().filter(v -> v >= 2).toList();
    for (int num : list) {
      if (num >= 2) {
        //自己和自己匹配
        res = res + (num - 1) * num / 2;
      }
    }
    List<Integer> list1 = map.keySet().stream().sorted((a, b) -> b - a).toList();
    for (int key : list1) {
      if (!set.contains(key)) {
        continue;
      }
      set.remove(key);
      int value = map.get(key);
      Set<Integer> temp = new HashSet<>();
      if (key >= 10) {
        String str = String.valueOf(key);
        int len = str.length();
        //任意交换两个字符
        // 对当前数字生成所有可能的交换形式
        for (int i = 0; i < len; i++) {
          for (int j = i + 1; j < len; j++) {
            char[] chars = str.toCharArray();
            // 交换第i和第j个位置的字符
            char tempChar = chars[i];
            chars[i] = chars[j];
            chars[j] = tempChar;

            int newInt = Integer.parseInt(new String(chars));
            if (temp.contains(newInt)) {
              continue;
            }
            temp.add(newInt);
            // 保存在哈希表中
            int cnts = map.getOrDefault(newInt, 0);
            if (set.contains(newInt) && newInt != key) {
              res = res + value * cnts;
            }

          }
        }
      }
    }
    return res;
  }

  public int[] getFinalStateV1(int[] nums, int k, int multiplier) {
    for (int i = 0; i < k; i++) {
      int min = 0;
      for (int j = 1; j < nums.length; j++) {
        if (nums[j] < nums[min]) {
          min = j;
        }
      }
      nums[min] *= multiplier;
    }
    return nums;
  }
}
