package com.topic.slidwindow;

/**
 * @author zc.zhou
 * @Description 3325. 字符至少出现 K 次的子字符串 I 滑动窗口
 * @create 2024-10-21 20:52
 */
public class NumberOfSubstrings {
  public int numberOfSubstrings(String s, int k) {
    int[] cnts = new int[26];
    int left = 0;
    int res = 0;
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      int curIndex = s.charAt(right) - 'a';
      cnts[curIndex]++;
      //满足条件 left左移 直到不满足
      while (left < s.length() && cnts[curIndex] >= k) {
        cnts[s.charAt(left) - 'a']--;
        left++;
      }
      //left - 1 满足条件 0 - left - 1
      res += left;
    }
    return res;
  }

  public int numberOfSubstringsV1(String s, int k) {
    int[] cnts = new int[26];
    int left = 0;
    int res = 0;
    //枚举右端点
    for (int right = 0; right < s.length(); right++) {
      cnts[s.charAt(right) - 'a']++;
      //满足条件 left左移 直到不满足
      while (left < s.length() && checkCnts(cnts, k)) {
        cnts[s.charAt(left) - 'a']--;
        left++;
      }
      //left - 1 满足条件 0 - left - 1
      res += left;
    }
    return res;
  }

  private boolean checkCnts(int[] cnts, int k) {
    for (int cnt : cnts) {
      if (cnt >= k) {
        return true;
      }
    }
    return false;
  }
}
