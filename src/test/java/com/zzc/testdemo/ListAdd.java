package com.zzc.testdemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-24 20:53
 */
public class ListAdd {
  @Test
  void testFun() {
    long start = System.currentTimeMillis();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 1e5; i++) {
      list.add(list.size() / 2, i);
      //list.add(i);
    }
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
