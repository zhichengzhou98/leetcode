package com.topic.baoli;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2274. 不含特殊楼层的最大连续楼层数
 * @create 2025-01-06 20:10
 */
public class MaxConsecutive {
  public int maxConsecutive(int bottom, int top, int[] special) {
    int res = 0;
    Arrays.sort(special);
    for (int i = 1; i < special.length; i++) {
      res = Math.max(special[i] - special[i-1] - 1,res);
    }
    res = Math.max(res, special[0] -bottom);
    res = Math.max(res, top - special[special.length - 1]);
    return res;
  }
}
