package com.topic.bitoperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2438 二的幂数组中查询范围内的乘积
 * @create 2024-08-01 17:44
 */
public class ProductQueries {

  @Test
  void testFun() {
    //System.out.println(Math.pow(2, 29));
    List<Integer> list = generatePowers((int) Math.pow(2, 29) - 1);
    System.out.println(list);
    double[] doubles = new double[list.size() + 1];
    doubles[0] = 1D;
    for (int i = 1; i < doubles.length; i++) {
      doubles[i] = doubles[i - 1] * list.get(i - 1);
    }
    System.out.println((int) (doubles[doubles.length - 1] / doubles[doubles.length - 2]));
  }

  private static final int MOD = (int) (Math.pow(10, 9) + 7);

  public int[] productQueries(int n, int[][] queries) {
    List<Integer> powers = generatePowers(n);
    double[] doubles = new double[powers.size() + 1];
    doubles[0] = 1D;
    for (int i = 1; i < doubles.length; i++) {
      doubles[i] = doubles[i - 1] * powers.get(i - 1);
    }
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int begin = queries[i][0];
      int end = queries[i][1];
      res[i] = (int) ((doubles[end + 1] / doubles[begin]) % MOD);
    }
    return res;
  }

  private List<Integer> generatePowers(int n) {
    int bit = 0;
    List<Integer> res = new ArrayList<>();
    while (n > 0) {
      if (n % 2 != 0) {
        res.add(1 << bit);
      }
      bit++;
      n /= 2;
    }
    return res;
  }
}
