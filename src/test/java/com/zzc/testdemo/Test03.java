package com.zzc.testdemo;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-30 21:55
 */
public class Test03 {
  @Test
  void testFun() {
    long counts = (long) Math.pow(10, 9);
    double sum = 0.0d;
    for (long i = 0L; i < counts; i++) {
      sum += distance();
    }
    System.out.println(sum / counts);
  }

  //计算任意两点的距离
  private double distance() {
    double x1 = Math.random();
    double y1 = Math.random();
    double x2 = Math.random();
    double y2 = Math.random();
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }
}
