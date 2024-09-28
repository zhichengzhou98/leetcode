package com.competition;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-28 22:23
 */
public class WeekCompetition0928 {
  @Test
  void testFun() {
    String s1 = "accbbaeddkddddeeed";
    String s2 = "eddedd";
    System.out.println(Arrays.toString(validSequence(s1, s2)));
  }

  public int[] validSequence(String word1, String word2) {
    arr1 = word1.toCharArray();
    arr2 = word2.toCharArray();
    res = new ArrayList<>();
    boolean flag = dfsV1(0, 0, true);
    if (flag) {
      return res.stream().mapToInt(Integer::intValue).toArray();
    }
    return new int[0];
  }

  char[] arr1;
  char[] arr2;
  List<Integer> res;

  /**
   * 能否找到符合条件的index序列
   *
   * @param l1        word1中的位置
   * @param l2        word2中的位置
   * @param canChange 是否能替换
   * @return
   */
  private boolean dfsV1(int l1, int l2, boolean canChange) {
    if (l2 == arr2.length) {
      //已经遍历完
      return true;
    }
    if (arr2.length - l2 > arr1.length - l1) {
      //word2剩下的字符比word1剩下的字符多 不能满足
      return false;
    }
    char c2 = arr2[l2];
    char c1 = arr1[l1];
    //贪心
    if (c1 == c2) {
      res.add(l1);
      boolean tmp = dfsV1(l1 + 1, l2 + 1, canChange);
      return handleResult(tmp);
    } else {
      //首字母不相等
      if (canChange) {
        //能替换
        //假设替换第一个字母
        res.add(l1);
        boolean tmp = dfsV1(l1 + 1, l2 + 1, false);
        if (tmp) {
          return tmp;
        }
        //不能替换 回溯
        res.remove(res.size() - 1);
      }
      int index = findFirst(l1, c2);
      if (index == -1) {
        return false;
      }
      res.add(index);
      boolean tmp = dfsV1(index + 1, l2 + 1, canChange);
      return handleResult(tmp);
    }
  }

  private boolean handleResult(boolean flag) {
    if (flag) {
      return flag;
    }
    res.remove(res.size() - 1);
    return flag;
  }

  /**
   * 找到word1中从begin开始第一个等于target的字符
   *
   * @param begin  从begin开始找
   * @param target 目标字符
   * @return -1 没找到
   */
  private int findFirst(int begin, char target) {
    while (begin < arr1.length && arr1[begin] != target) {
      begin++;
    }
    if (begin < arr1.length) {
      return begin;
    }
    return -1;
  }


  public long maximumTotalSum(int[] maximumHeight) {
    Arrays.sort(maximumHeight);
    int size = maximumHeight.length;
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
