package com.competition;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-17 22:29
 */
public class WeekCompetition0817 {
  @Test
  void testFun() {
    int[] nums = {1,3,4};
    System.out.println(Arrays.toString(resultsArray(nums, 2)));
  }

  public int[] resultsArrayV1(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    for (int i = 0; i <= n - k; i++) {
      boolean isIncreasing = true;
      int maxValue = nums[i];
      for (int j = i + 1; j < i + k; j++) {
        if (nums[j] - nums[j - 1] != 1) {  // 检查是否连续
          isIncreasing = false;
          break;
        }
        maxValue = Math.max(maxValue, nums[j]);
      }
      if (isIncreasing) {
        res[i] = maxValue;
      } else {
        res[i] = -1;
      }
    }
    return res;
  }

  public int[] resultsArray(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      // 移除窗口的元素
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && (nums[deque.peekLast()] >= nums[i] || nums[i] - nums[deque.peekLast()] > 1)) {
        deque.pollLast();
      }
      deque.offerLast(i);
      // 只有当窗口大小达到 k 时才开始判断结果
      if (i >= k - 1) {
        if (deque.peekFirst() == i - k + 1 && nums[deque.peekLast()] - nums[deque.peekFirst()] == k - 1) {
          res[i - k + 1] = nums[deque.peekLast()];
        } else {
          res[i - k + 1] = -1;
        }
      }
    }
    return res;
  }
}
