package com.topic.baoli;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2109
 * @create 2024-09-10 11:17
 */
public class AddSpaces {
  @Test
  void testFun() {
    String s = "LeetcodeHelpsMeLearn";
    int[] spaces = {8, 13, 15};
    System.out.println(addSpaces(s, spaces));
  }
  public String addSpaces(String s, int[] spaces) {
    int begin = 0;
    StringBuilder sb = new StringBuilder();
    for (int next : spaces) {
      sb.append(s, begin, next).append(" ");
      begin = next;
    }
    return sb.append(s,begin, s.length()).toString();
  }
}
