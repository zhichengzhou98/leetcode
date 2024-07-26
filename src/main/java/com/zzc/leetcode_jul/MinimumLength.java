package com.zzc.leetcode_jul;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-26 17:59
 */
public class MinimumLength {
  public int minimumLength(String s) {
    //统计每个字符出现的次数
    int[] cnts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      cnts[s.charAt(i) - 'a']++;
    }
    int res = 0;
    for (int i = 0; i < cnts.length; i++) {
      while (cnts[i] >= 3) {
        cnts[i] -= 2;
      }
      res += cnts[i];
    }
    return res;
  }
}
