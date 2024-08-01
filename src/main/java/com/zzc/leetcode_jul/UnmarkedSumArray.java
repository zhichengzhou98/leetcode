package com.zzc.leetcode_jul;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3080 执行操作标记数组中的元素 优先队列
 * @create 2024-08-01 16:38
 */
public class UnmarkedSumArray {

  public long[] unmarkedSumArray(int[] nums, int[][] queries) {
    long sum = 0L;
    //只记录索引 使用优先队列
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
      if (nums[a] == nums[b]) {
        return a - b;
      }
      return nums[a] - nums[b];
    });
    //已被标记的索引
    Set<Integer> markedIndex = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      queue.offer(i);
    }
    long[] res = new long[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int index = queries[i][0];
      int k = queries[i][1];
      if (!markedIndex.contains(index)) {
        //标记该元素
        markedIndex.add(index);
        sum -= nums[index];
      }
      //当前index已经被标记
      while (k > 0 && !queue.isEmpty()) {
        //取出最小的k个元素
        int poll = queue.poll();
        if (!markedIndex.contains(poll)) {
          //如果这个元素没有被标记
          markedIndex.add(poll);
          sum -= nums[poll];
          k--;
        }
      }
      res[i] = sum;
    }
    return res;
  }

  public long[] unmarkedSumArrayV1(int[] nums, int[][] queries) {
    long sum = 0L;
    //记录值和对应的索引 使用优先队列
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });
    //已被标记的索引
    Set<Integer> markedIndex = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      queue.offer(new int[]{nums[i], i});
    }

    long[] res = new long[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int index = query[0];
      int k = query[1];
      if (!markedIndex.contains(index)) {
        //标记该元素
        markedIndex.add(index);
        sum -= nums[index];
      }
      //当前index已经被标记
      while (k > 0 && !queue.isEmpty()) {
        //取出最小的k个元素
        int[] poll = queue.poll();
        if (!markedIndex.contains(poll[1])) {
          //如果这个元素没有被标记
          markedIndex.add(poll[1]);
          sum -= poll[0];
          k--;
        }
      }
      res[i] = sum;
    }
    return res;
  }
}
