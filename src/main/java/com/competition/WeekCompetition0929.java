package com.competition;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-29 10:29
 */
public class WeekCompetition0929 {
  @Test
  void testFun() {
    String s1 = "iqeaouqi";
    System.out.println(countOfSubstrings(s1, 2));
  }

  public long countOfSubstrings(String word, int k) {
    long count = 0L;
    Deque<Integer> aQ = new ArrayDeque<>();
    Deque<Integer> eQ = new ArrayDeque<>();
    Deque<Integer> iQ = new ArrayDeque<>();
    Deque<Integer> oQ = new ArrayDeque<>();
    Deque<Integer> uQ = new ArrayDeque<>();
    //窗口中非元音字母出现的索引
    List<Integer> unQ = new ArrayList<>();
    int left = 0;
    //滑动窗口
    //枚举右端点
    for (int right = 0; right < word.length(); right++) {
      char c = word.charAt(right);
      switch (c) {
        case 'a':
          aQ.addLast(right);
          break;
        case 'e':
          eQ.addLast(right);
          break;
        case 'i':
          iQ.addLast(right);
          break;
        case 'o':
          oQ.addLast(right);
          break;
        case 'u':
          uQ.addLast(right);
          break;
        default:
          unQ.add(right);
      }
      //当满足条件时 左端点左移 直到不满足条件
      while (checkCnts(aQ, eQ, iQ, oQ, uQ, unQ, k)) {
        //满足条件
        //求出最小left
        int min1 = Math.min(aQ.peekLast(), eQ.peekLast());
        int min2 = Math.min(iQ.peekLast(), oQ.peekLast());
        int min3 = Math.min(min1, min2);
        int min4 = Math.min(min3, uQ.peekLast());
        //移除unQ中size - k个元素
        int index = left;
        boolean flage = false;
        if (unQ.size() - 1 - k >= 0) {
          flage = true;
          index = unQ.get(unQ.size() - 1 - k);
        }
        if (min4 >= index) {
          //满足条件
          if (!unQ.isEmpty() && unQ.size() - k >= 0) {
            min4 = Math.min(min4, unQ.get(unQ.size() - k));
          }
          count += (index - min4);
          handle(aQ, eQ, iQ, oQ, uQ, unQ, index);
          if (flage) {
            left = index + 1;
          } else{
            left++;
          }
        } else {
          break;
        }
      }
    }
    return count;
  }

  //判断cnts是否全为0 没有大于0 -> true
  private void handle(Deque<Integer> aQ,
                      Deque<Integer> eQ,
                      Deque<Integer> iQ,
                      Deque<Integer> oQ,
                      Deque<Integer> uQ,
                      List<Integer> unQ, int min) {
    while (!aQ.isEmpty() && aQ.peekFirst() <= min) {
      aQ.pollFirst();
    }
    while (!eQ.isEmpty() && eQ.peekFirst() <= min) {
      eQ.pollFirst();
    }
    while (!iQ.isEmpty() && iQ.peekFirst() <= min) {
      iQ.pollFirst();
    }
    while (!oQ.isEmpty() && oQ.peekFirst() <= min) {
      oQ.pollFirst();
    }
    while (!uQ.isEmpty() && uQ.peekFirst() <= min) {
      uQ.pollFirst();
    }
    while (!unQ.isEmpty() && unQ.get(0) <= min) {
      unQ.remove(0);
    }
  }


  //判断cnts是否全为0 没有大于0 -> true
  private boolean checkCnts(Deque<Integer> aQ,
                            Deque<Integer> eQ,
                            Deque<Integer> iQ,
                            Deque<Integer> oQ,
                            Deque<Integer> uQ,
                            List<Integer> unQ, int k) {
    if (aQ.size() < 1) {
      return false;
    }
    if (eQ.size() < 1) {
      return false;
    }
    if (iQ.size() < 1) {
      return false;
    }
    if (oQ.size() < 1) {
      return false;
    }
    if (uQ.size() < 1) {
      return false;
    }
    return unQ.size() >= k;
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
