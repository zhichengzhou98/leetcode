package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description 740 贪心 × 只能保证局部最优解
 * @create 2024-08-12 10:52
 */
public class DeleteAndEarn {

  @Test
  void testFun(){
    int[] arr = new int[]{4,10,10,8,1,4,10,9,7,6};

    System.out.println(deleteAndEarn(arr));
  }

  public int deleteAndEarn(int[] nums) {
    Arrays.sort(nums);
    //选或不选 dp[i][j] -> j: 0 不选
    int[][] dp = new int[nums.length][2];
    dp[0][0] = 0;
    dp[0][1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int pre = nums[i - 1];
      //当前数字不选，前一个数字选或不选都行
      if (num == pre + 1) {
        //相同的数字要么都选 要么都不选
        //当前数字选
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = dp[i - 1][0] + num;
      } else if (num == pre) {
        dp[i][0] = dp[i - 1][0];
        dp[i][1] = dp[i - 1][1] + num;
      } else {
        //当前数字选
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + num;
      }
    }
    return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
  }

  public int deleteAndEarnV2(int[] nums) {
    //相同的数字要么都选 要么都不选
    Map<Integer, Integer> valueCnts = new HashMap<>();
    for (int num : nums) {
      valueCnts.put(num, valueCnts.getOrDefault(num, 0) + 1);
    }
    //把nums去重
    List<Integer> list = valueCnts.keySet().stream().sorted().toList();
    //选或不选 dp[i][j] -> j: 0 不选
    int[][] dp = new int[list.size()][2];
    dp[0][0] = 0;
    dp[0][1] = list.get(0) * valueCnts.get(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      int num = list.get(i);
      int pre = list.get(i-1);
      //当前数字不选，前一个数字选或不选都行
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      if (num == pre + 1) {
        //相同的数字要么都选 要么都不选
        //当前数字选
        dp[i][1] = dp[i - 1][0] + num * valueCnts.get(num);
      } else {
        //当前数字选
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + num * valueCnts.get(num);
      }
    }
    return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
  }
  //[2, 2, 3, 3, 3, 4]
  public int deleteAndEarnV1(int[] nums) {

    //优先队列 大顶堆 0表示元素的值 value表示次数
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
    Map<Integer, Integer> valueCnts = new HashMap<>();
    for (int num : nums) {
      valueCnts.put(num, valueCnts.getOrDefault(num, 0) + 1);
    }
    valueCnts.entrySet().forEach(entry -> {
      int[] arr = new int[]{entry.getKey(), entry.getValue()};
      pq.offer(arr);
    });
    int res = 0;
    while (!pq.isEmpty()) {
      //取出最大的元素
      int[] max = pq.poll();
      int temp1 = max[0] * max[1];
      if (pq.isEmpty()) {
        res += temp1;
        return res;
      } else if (max[0] > pq.peek()[0] + 1){
        res += temp1;
      } else if (max[0] == pq.peek()[0] + 1) {
        //取出第二大的值
        int[] second = pq.poll();
        int temp2 = second[0] * second[1];
        if (pq.isEmpty()) {
          res += Math.max(temp1, temp2);
          return res;
        } else if (second[0] > pq.peek()[0] + 1) {
          res += Math.max(temp1, temp2);
        } else if(second[0] == pq.peek()[0] + 1) {
          int[] min = pq.poll();
          int temp3 = min[0] * min[1];
          if (temp1 + temp3 > temp2) {
            //需要判断下一个数是不是 min - 1，
            if (!pq.isEmpty() && pq.peek()[0] + 1== min[0]) {
              pq.poll();
            }
          }
          res += Math.max(temp1 + temp3, temp2);
        }
      }
    }
    return res;
  }
}
