package com.topic.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 3144
 * @create 2024-08-28 9:19
 */
public class MinimumSubstringsInPartition {
  @Test
  void testFun() {
    System.out.println(minimumSubstringsInPartitionV3("abababaccddb"));
  }
  public int minimumSubstringsInPartition(String s) {
    int len = s.length();
    //二分+dfs
    //1 2 3 ... len

    return 0;
  }

  Map<String, Integer> map;
  Map<String, Set<Integer>> mapSet;

  //dfs 超时
  public int minimumSubstringsInPartitionV3(String s) {
    int len = s.length();
    map = new HashMap<>();
    mapSet = new HashMap<>();
    return dfs(0, len - 1, s);
  }

  private int dfs(int left, int right, String s) {
    String key = left + "," + right;
    if (right == left) {
      return 1;
    }
    if (map.containsKey(key)) {
      return map.get(key);
    }
    String subStr = s.substring(left, right + 1);
    //判断cnts不为0的值是否全相等
    Set<Integer> set = new HashSet<>();
    if (mapSet.containsKey(subStr)) {
      set = mapSet.get(subStr);
    } else {
      //检查l 到 r是否满足
      int[] cnts = new int[26];
      //统计s中每个字符串出现的次数
      for (int i = left; i <= right; i++) {
        int cIndex = s.charAt(i) - 'a';
        cnts[cIndex]++;
      }
      for (int j = 0; j < cnts.length; j++) {
        if (cnts[j] > 0) {
          set.add(cnts[j]);
        }
        if (set.size() > 1) {
          //次此不满足
          //依次缩小s的长度
          break;
        }
      }
      mapSet.put(subStr, set);
    }
    if (set.size() == 1) {
      map.put(key, 1);
      return 1;
    }
    int res = Integer.MAX_VALUE;
    for (int i = left; i <= right - 1; i++) {
      res = Math.min(dfs(left, i, s) + dfs(i + 1, right, s), res);
    }
    map.put(key, res);
    return res;
  }

  //dp
  public int minimumSubstringsInPartitionV2(String s) {
    int len = s.length();
    int[] dp = new int[len];
    dp[0] = 1;

    return 0;
  }

  //贪心 答案错误
  //abababaccddb -> ababab ac cd db
  //abababaccddb -> abab abaccddb
  public int minimumSubstringsInPartitionV1(String s) {
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    int[] cnts = new int[26];
    //统计s中每个字符串出现的次数
    for (int i = 0; i < len; i++) {
      int cIndex = s.charAt(i) - 'a';
      cnts[cIndex]++;
    }
    //判断cnts不为0的值是否全相等
    Set<Integer> set = new HashSet<>();
    for (int j = 0; j < cnts.length; j++) {
      if (cnts[j] > 0) {
        set.add(cnts[j]);
      }
      if (set.size() > 1) {
        //次此不满足
        //依次缩小s的长度
        break;
      }
    }
    if (set.size() == 1) {
      return 1;
    }
    for (int i = len - 1; i >= 0; i--) {
      //移除当前字符
      char c = s.charAt(i);
      cnts[c - 'a']--;
      //判断cnts不为0的值是否全相等
      set = new HashSet<>();
      for (int j = 0; j < cnts.length; j++) {
        if (cnts[j] > 0) {
          set.add(cnts[j]);
        }
        if (set.size() > 1) {
          //次此不满足
          break;
        }
      }
      if (set.size() == 1) {
        String subStr = s.substring(i);
        return 1 + minimumSubstringsInPartitionV1(subStr);
      }
    }
    return 0;
  }
}
