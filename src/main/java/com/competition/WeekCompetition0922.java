package com.competition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    System.out.println(validSubstringCount("bb","b"));
  }

  public long validSubstringCountV1(String word1, String word2) {
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

  public long validSubstringCount(String word1, String word2) {
    //滑动窗口
    if (word1.length() < word2.length()) {
      return 0L;
    }
    //word2每个字符的数量
    int[] diff = new int[26];
    int cnt = 0;
    for (int i = 0; i < word2.length(); i++) {
      int index = word2.charAt(i) - 'a';
      diff[index]++;
    }
    for(int d : diff) {
      if (d >= 1) {
        cnt++;
      }
    }
    long res = 0L;
    int left = 0;
    int right = 0;
    diff[word1.charAt(right) - 'a']--;
    if (diff[word1.charAt(right) - 'a'] == 0) {
      cnt--;
    }
    while (true) {
      while (cnt != 0) {
        if (right + 1 < word1.length()) {
          //如果不满足 right右移
          right++;
          diff[word1.charAt(right) - 'a']--;
          if(diff[word1.charAt(right) - 'a'] == 0) {
            cnt--;
          }
        } else {
          return res;
        }
      }

      while (cnt == 0 && left <= right) {
        //满足条件时更新res
        res = res + word1.length() - right;
        //left左移直到不满足条件
        diff[word1.charAt(left) - 'a']++;
        if (diff[word1.charAt(left) - 'a'] == 1) {
          cnt++;
        }
        left++;
      }
    }
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
    //最大workTime
    int max = workerTimes[0];
    for (int time : workerTimes) {
      max = Math.max(max, time);
    }
    //左边界
    long left = 1;
    long right = (long) ((1 + 1e5) * (1e5) * max / (2L * workerTimes.length)) + 1;
    return leftBoundary(left, right);
  }

  public boolean checkMed(long med) {
    //统计med时间各个工人完成的高度
    int sum = 0;
    for(int w : workerTimes) {
      sum += (int) (Math.sqrt(2.0 * med / w + 0.25) -0.5);
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
    Set<String> set = Arrays.stream(bannedWords).collect(Collectors.toSet());
    return Arrays.stream(message).filter(set::contains).count() >= 2;
  }
  public boolean reportSpamV1(String[] message, String[] bannedWords) {
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
