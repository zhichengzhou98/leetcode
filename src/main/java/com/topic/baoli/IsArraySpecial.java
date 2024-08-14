package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3152 判断query的起点和终点是否落在同一个区间
 * 分割nums的区间，将不同区间里的值依次增大，相同区间的值相同
 * @create 2024-08-14 9:11
 */
public class IsArraySpecial {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    boolean[] res = new boolean[queries.length];
    int[] temp = new int[nums.length];
    int current = 0;
    for (int i = 1; i < nums.length; i++) {
      if ((nums[i] + nums[i - 1]) % 2 == 0) {

        current++;
      }
      temp[i] = current;
    }
    for (int i = 0; i < queries.length; i++) {
      res[i] = temp[queries[i][0]] == temp[queries[i][1]];
    }
    return res;
  }
}
