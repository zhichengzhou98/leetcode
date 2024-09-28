package com.competition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-28 22:23
 */
public class WeekCompetition0928 {
  @Test
  void testFun() {
    String s1 = "cedccdccccce";
    String s2 = "dfk";
    System.out.println(Arrays.toString(validSequence(s1, s2)));
  }

  public int[] validSequence(String word1, String word2) {
    arr1 = word1.toCharArray();
    arr2 = word2.toCharArray();
    this.word1 = word1;
    this.word2 = word2;
    return dfs(0, 0, true);
  }

  String word1;
  String word2;
  char[] arr1;
  char[] arr2;

  private int[] dfs(int l1, int l2, boolean flag) {
    char c2 = arr2[l2];
    char c1 = arr1[l1];
    if (arr2.length - l2 > arr1.length - l1) {
      return new int[0];
    }
    int[] res = new int[arr2.length - l2];
    //int leftWord2 =
    //贪心
    if (c1 == c2) {
      if (l2 == arr2.length - 1) {
        return new int[]{0};
      }
      int[] tmp = dfs(l1 + 1, l2 + 1, flag);
      if (tmp.length == 0) {
        return tmp;
      }
      res[0] = 0;
      for (int i = 0; i < tmp.length; i++) {
        res[1 + i] = tmp[i] + 1;
      }
      return res;
    } else {
      //假设替换第一个字母
      if (flag) {
        res[0] = 0;
        if (l2 == arr2.length - 1) {
          return new int[]{0};
        }
        int[] tmp = isSubSeq(this.word1.substring(l1 + 1), this.word2.substring(l2 +1));
        if (tmp.length == 0) {
          //不能替换
          //找到word1中第一个word2[0]
          int index = l1;
          while (index < arr1.length && arr1[index] != c2) {
            index++;
          }
          if (index >= arr1.length) {
            return new int[0];
          }
          res[0] = index;
          tmp = dfs(index +1, l2 + 1, true);
          if (tmp.length == 0) {
            return tmp;
          }
          for (int i = 0; i < tmp.length; i++) {
            res[1 + i] = tmp[i] + index + 1;
          }
          return res;
        } else {
          for (int i = 0; i < tmp.length; i++) {
            res[1 + i] = tmp[i] + 1;
          }
          return res;
        }
      }else {
        int index = l1;
        while (index < arr1.length && arr1[index] != c2) {
          index++;
        }
        if (index >= arr1.length) {
          return new int[0];
        }
        res[0] = index;
        int[] tmp = dfs(l1+ 1, l2 +1, false);
        for (int i = 0; i < tmp.length; i++) {
          res[1 + i] = tmp[i] + index + 1;
        }
        return res;
      }
    }
  }


  /**
   * 判断seq是不是s的子序列
   *
   * @param s
   * @param seq
   * @return
   */
  public int[] isSubSeq(String s, String seq) {
    if (seq.length() > s.length()) {
      return new int[0];
    }
    int[] res = new int[seq.length()];
    int i = 0;
    int p1 = 0;
    int p2 = 0;
    while (p1 < seq.length()) {
      char c = seq.charAt(p1);
      while (p2 < s.length() && s.charAt(p2) != c) {
        p2++;
      }
      if (p2 == s.length()) {
        return new int[0];
      } else {
        res[i] = p2;
        i++;
        p1++;
        p2++;
      }
    }
    return res;
  }

  public long maximumTotalSum(int[] maximumHeight) {
    Arrays.sort(maximumHeight);
    int size = maximumHeight.length;
    TreeSet<Integer> treeSet = new TreeSet<>();
    long totalSum = 0;
    int max = Integer.MAX_VALUE;
    for (int i = size - 1; i >= 0; i--) {
      max = Math.min(max, maximumHeight[i]);
      if (max < 1) {
        return -1;
      }
      totalSum += max;
      max--;
    }
    return totalSum;
  }
}
