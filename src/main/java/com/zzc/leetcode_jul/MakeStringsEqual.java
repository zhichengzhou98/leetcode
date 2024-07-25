package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-25 14:05
 */
public class MakeStringsEqual {
  public boolean makeStringsEqual(String s, String target) {
    //如果target全为0， s也必须全为0
    if (checkZero(target)) {
      return checkZero(s);
    }
    return !checkZero(s);
  }

  public boolean checkZero(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        return false;
      }
    }
    return true;
  }
}
