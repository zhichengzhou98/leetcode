package com.zzc.utils;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-12 9:32
 */
public class MathUtils {
  private MathUtils(){}

  //多个int的最大/最小值
  public static int max(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.max(res, num);
    }
    return res;
  }

  public static int min(int... nums) {
    int res = nums[0];
    for (int num : nums) {
      res = Math.min(res, num);
    }
    return res;
  }
  //进制转化
  //10进制数 -> 二进制字符串
  public static String parse10ToBinaryStr(long num) {
    return Long.toBinaryString(num);
  }

  //二进制字符串 -> 10进制数
  public static long parseBinaryStrTo10(String str) {
    return Long.parseLong(str, 2);
  }
}
