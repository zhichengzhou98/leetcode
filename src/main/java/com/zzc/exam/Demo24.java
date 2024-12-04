package com.zzc.exam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-12-04 13:13
 */
public class Demo24 {
  @Test
  void testFun() {
    System.out.println(count());
  }

  private int count() {
    int res = 0;
    List<int[]> list = generate();
    System.out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      int[] pA = list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
        int[] pB = list.get(j);
        for (int k = j + 1; k < list.size(); k++) {
          int[] pC = list.get(k);
          if (square(pA, pB, pC) == 4.0) {
            res++;
          }
        }
      }
    }
    return res;
  }

  private double square(int[] a, int[] b, int[] c) {
    int x1 = a[0];
    int y1 = a[1];
    int x2 = b[0];
    int y2 = b[1];
    int x3 = c[0];
    int y3 = c[1];
    return 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
  }

  private List<int[]> generate() {
    int n = 7;
    ArrayList<int[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        list.add(new int[]{i, j});
      }
    }
    return list;
  }
}
