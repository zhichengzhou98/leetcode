package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 809
 * @create 2024-07-25 14:42
 */
public class ExpressiveWords {
  @Test
  void testFun() {
    System.out.println(checkStr("dddiiiinnssssssoooo", "ddiinnso"));
  }

  //"dddiiiinnssssssoooo"
  //["dinnssoo","ddiinnso","ddiinnssoo"]
  public int expressiveWords(String s, String[] words) {
    int res = 0;
    for (String word : words) {
      if (checkStr(s, word)) {
        res++;
      }
    }
    return res;
  }

  //hhheeellooo hhello
  public boolean checkStr(String target, String source) {
    if (target.equals(source)) {
      return true;
    }
    if (source.length() > target.length()) {
      return false;
    }
    if (source.isEmpty() && !target.isEmpty()) {
      return false;
    }
    if (source.charAt(0) != target.charAt(0)) {
      return false;
    }
    char firstChar = source.charAt(0);
    int index = 1;
    while (index < source.length() && source.charAt(index) == firstChar) {
      index++;
    }
    //source一共有index个firstChar
    int index2 = 1;
    while (index2 < target.length() && target.charAt(index2) == firstChar) {
      index2++;
    }
    //target中有index2个firstChar
    if (index2 != index) {
      if (index2 < 3 || index2 < index) {
        return false;
      }
    }
    target = target.substring(index2);
    source = source.substring(index);
    return checkStr(target, source);
  }
}
