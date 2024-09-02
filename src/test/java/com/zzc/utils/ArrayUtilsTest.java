package com.zzc.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-02 17:36
 */
class ArrayUtilsTest {

  @Test
  void generate() throws IOException {
    List<Integer> o = ArrayUtils.generate("array", List.class, List.class, Integer.class);
    System.out.println(o);
  }
}