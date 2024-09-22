package com.competition;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import jdk.swing.interop.SwingInterOpUtils;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-22 10:28
 */
public class WeekCompetition0922 {
  @Test
  void testFun() {
    int[] w = {2, 1, 1};
    //System.out.println(minNumberOfSeconds(4, w));
    System.out.println(validSubstringCount("bbbb","b"));
  }

  public long validSubstringCount(String word1, String word2) {
    //滑动窗口
    if (word1.length() < word2.length()) {
      return 0L;
    }
    //word2每个字符的数量
    int[] cnt2 = new int[26];
    int[] cnt1 = new int[26];
    for (int i = 0; i < word2.length(); i++) {
      int index = word2.charAt(i) - 'a';
      cnt2[index]++;
    }
    long res = 0L;
    int left = 0;
    int right = 0;
    cnt1[word1.charAt(right) - 'a']++;

    while(left <= right && right <word1.length()) {
      while (checkValid(cnt1, cnt2) && left <= right && right < word1.length()) {
        //满足条件时
        //更新res
        res = res + word1.length() - right;
        //left左移
        if (left + 1 <= right) {
          cnt1[word1.charAt(left) - 'a']--;
          left++;
        } else {
          right++;
          left = right;
        }
      }
      //right 右移动知道满足条件
      while (!checkValid(cnt1, cnt2)) {
        if (right + 1 <word1.length()) {
          right++;
          cnt1[word1.charAt(right) - 'a']++;
        } else {
          return res;
        }
      }
    }
    return res;
  }

  private boolean checkValid(int[] cnt1, int[] cnt2) {
    for (int i = 0; i < cnt1.length; i++) {
      if (cnt2[i] >cnt1[i]) {
        return false;
      }
    }
    return true;
  }


  int mountainHeight;
  int[] workerTimes;

  //二分答案求左边界
  public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    this.mountainHeight = mountainHeight;
    this.workerTimes = workerTimes;
    //最小workTime
    int min = workerTimes[0];
    int max = workerTimes[0];
    for (int time : workerTimes) {
      min = Math.min(min, time);
      max = Math.max(max, time);
    }
    //左边界
    long left = 1;
    long right = (long) 1e17;

    return leftBoundary(left, right);
  }

  public boolean checkMed(long med) {
    //统计med时间各个工人完成的高度
    long sum = 0;
    for(int w : workerTimes) {
      sum += (long) (Math.sqrt(2.0 * med / w + 0.25) -0.5);
    }
    return sum >= mountainHeight;
  }

  public long leftBoundary(long l, long r) {
    long med = (r - l) / 2 + l;
    while (l < r) {
      if (checkMed(med)) {
        r = med;
      } else {
        l = med + 1;
      }
      med = (r - l) / 2 + l;
    }
    return med;
  }

  public boolean reportSpam(String[] message, String[] bannedWords) {
    HashSet<String> set = new HashSet<>();


    for (String word : bannedWords) {
      set.add(word);
    }
    int count = 0;
    for (String word : message) {
      if (set.contains(word)) {
        count++;
        if (count >= 2) {
          return true;
        }
      }
    }
    return false;
  }
}
