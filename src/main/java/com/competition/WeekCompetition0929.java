package com.competition;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-29 10:29
 */
public class WeekCompetition0929 {
  @Test
  void testFun() {
    String s1 = "ieaouqqieaouqq";
    System.out.println(countOfSubstrings(s1, 1));
  }

  public long countOfSubstrings(String word, int k) {
    long l1 = cntK(word, k);
    long l2 = cntK(word, k + 1);
    return l1 - l2;
  }

  /**
   * 滑动窗口，必须满足一种单调性，right右移满足，left右移不满足
   * 如果right右移可能满足条件 也可能不满足，则不能使用滑动窗口
   *
   * @param word
   * @param k    区间中的非元音字母的个数
   * @return
   */
  private long cntK(String word, int k) {
    long count = 0L;
    Map<Character, Integer> mapIndex = new HashMap<>();
    mapIndex.put('a', 0);
    mapIndex.put('e', 1);
    mapIndex.put('i', 2);
    mapIndex.put('o', 3);
    mapIndex.put('u', 4);
    //窗口中非元音字母出现的索引
    //0-4：元音字母个数 5:非元音字母个数
    int[] cnts = new int[6];
    int left = 0;
    //滑动窗口
    //枚举右端点
    for (int right = 0; right < word.length(); right++) {
      char c = word.charAt(right);
      cnts[mapIndex.getOrDefault(c, 5)]++;
      //当满足条件时 左端点左移 直到不满足条件
      while (checkCnts(cnts, k)) {
        //满足条件
        //left右移动
        cnts[mapIndex.getOrDefault(word.charAt(left), 5)]--;
        left++;
      }
      //左端点从[0, left - 1]都满足
      count += left;
    }
    return count;
  }

  private boolean checkCnts(int[] cnts, int k) {
    for (int i = 0; i < cnts.length - 1; i++) {
      if (cnts[i] <= 0) {
        return false;
      }
    }
    return cnts[5] >= k;
  }

  public int countOfSubstringsV1(String word, int k) {
    int count = 0;
    int n = word.length();
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    for (int i = 0; i < n; i++) {
      int cnts = 0;
      Set<Character> founded = new HashSet<>();
      for (int j = i; j < n; j++) {
        char c = word.charAt(j);
        if (set.contains(c)) {
          founded.add(c);
        } else {
          cnts++;
        }
        if (founded.size() == 5 && cnts == k) {
          count++;
        }
      }
    }
    return count;
  }

  public char kthCharacter(int k) {
    StringBuilder sb = new StringBuilder("a");
    while (sb.length() < k) {
      StringBuilder nextPart = new StringBuilder();
      for (char c : sb.toString().toCharArray()) {
        nextPart.append(c == 'z' ? 'a' : (char) (c + 1));
      }
      sb.append(nextPart);
    }
    return sb.charAt(k - 1);
  }
}
