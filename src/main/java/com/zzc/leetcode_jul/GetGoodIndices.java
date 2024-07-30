package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2961
 * @create 2024-07-30 9:16
 */
public class GetGoodIndices {
  //[ai, bi, ci, mi]
  //((ai^bi % 10)^ci) % mi == target
  public List<Integer> getGoodIndices(int[][] variables, int target) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < variables.length; i++) {
      int[] v = variables[i];
      if (check(v, target)) {
        res.add(i);
      }
    }
    return res;
  }

  private boolean check(int[] v, int target) {
    int temp = exponentiationBySquaringWithMod(v[0], v[1], 10);
    return exponentiationBySquaringWithMod(temp, v[2], v[3]) == target;
  }

  //快速幂 a的b次幂
  private int exponentiationBySquaringWithMod(int a, int b, int mod) {
    if (b == 1) {
      return a % mod;
    }

    //由于此题mod值比较小 y*y不会超过int, 因此返回值设置为int没有问题
    if (b % 2 == 0) {
      int y = exponentiationBySquaringWithMod(a, b / 2, mod);
      return y * y % mod;
    }
    int y = exponentiationBySquaringWithMod(a, (b - 1) / 2, mod);
    return y * y % mod * a % mod;
  }

}
