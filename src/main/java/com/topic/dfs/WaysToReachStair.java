package com.topic.dfs;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-20 18:22
 */
public class WaysToReachStair {
  public int waysToReachStair(int k) {
    return 0;
  }
  /*private int dfs(int current, int target, int jump, boolean lastBackFlag) {
    if (current == target) {
      if (jump - 1 >= 0) {
        int temp = (int) Math.pow(2, jump - 1);
        int res = 1 + dfs(current - temp, target, jump - 1, )
        return 1 + dfs(current + 1, target, jump) + dfs(current - temp, target, jump - 1);
      }else {
        return 1 + dfs(current + 1, target, jump);
      }
    } else if (current > target) {

    }
  }*/
}

