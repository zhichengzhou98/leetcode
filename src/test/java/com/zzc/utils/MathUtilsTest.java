package com.zzc.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-22 18:04
 */
class MathUtilsTest {

  @Test
  void parse10ToBinaryStr() {
    System.out.println(MathUtils.parse10ToBinaryStr(2345561));
  }

  @Test
  void parseBinaryStrTo10() {
    System.out.println(MathUtils.parseBinaryStrTo10("1000111100101001011001"));
  }

  @Test
  void getFactors() {
    for (int i = 1; i < 50; i++) {
      System.out.println(MathUtils.getFactors(i));
    }
  }
}