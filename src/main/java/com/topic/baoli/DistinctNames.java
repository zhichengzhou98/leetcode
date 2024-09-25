package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 2306 公司命名
 * @create 2024-09-25 9:16
 */
public class DistinctNames {
  @Test
  void testFun() {
    //String[] ideas = {"coffee", "donuts", "time", "toffee"};
    String[] ideas = {"aaa","baa","caa","bbb","cbb","dbb"};
    System.out.println(distinctNames(ideas));
  }

  public long distinctNames(String[] ideas) {
    long res = 0L;
    Set[] sets = new Set[26];
    //按字符串首字母分组
    for (int i = 0; i < sets.length; i++) {
      sets[i] = new HashSet<String>();
    }
    for (String str : ideas) {
      sets[str.charAt(0) - 'a'].add(str);
    }
    for (int i = 0; i < sets.length; i++) {
      Set<String> setI = sets[i];
      for (int j = i + 1; j < sets.length; j++) {
        int sizeI = setI.size();
        Set<String> setJ = sets[j];
        int sizeJ = setJ.size();
        //来自不同的分组
        for (String strI : setI) {
          String newStr = (char) ('a' + j) + strI.substring(1);
          if (setJ.contains(newStr)) {
            sizeI--;
          }
        }
        for (String strJ : setJ) {
          String newStr = (char) ('a' + i) + strJ.substring(1);
          if (setI.contains(newStr)) {
            sizeJ--;
          }
        }
        res = res + (long) sizeI * sizeJ * 2;
      }
    }
    return res;
  }
}
