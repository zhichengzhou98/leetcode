package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-26 16:40
 */
public class MaxOperations {
  @Test
  void testFun() {
    System.out.println(maxOperations("00001001101000"));
  }

  public int maxOperations(String s) {
    //统计前缀1的数量
    int[] res = new int[s.length()];
    if (s.charAt(0) == '1') {
      res[0]++;
    }
    for (int i = 1; i < s.length(); i++) {
      res[i] = res[i - 1];
      if (s.charAt(i) == '1') {
        res[i] += 1;
      }
    }
    int cnts = 0;
    int index = s.length() - 1;
    while (index >= 0) {
      //跳过1
      while (index >= 0 && s.charAt(index) == '1') {
        index--;
      }
      //找到连续0的首个0，统计0前面1的个数
      if (index >=0 ) {
        while (index >= 0 && s.charAt(index) == '0') {
          index--;
        }
        //此时index位置字符为 1, res[index]刚好把这个位置的 1 统计到了
        if (index >= 0) {
          cnts += res[index];
          //下一轮继续找
          index--;
        }
      }
    }
    return cnts;
  }
}
