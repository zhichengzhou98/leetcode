package com.zzc.leetcode_jul;

import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3227
 * @create 2024-07-26 16:03
 */
public class DoesAliceWin {
  //leetcoder
  public boolean doesAliceWin(String s) {
    //统计字符串中元音字母的个数
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}
