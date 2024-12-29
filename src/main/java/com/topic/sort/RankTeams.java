package com.topic.sort;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 1366. 通过投票对团队排名
 * @create 2024-12-29 17:26
 */
public class RankTeams {
  public String rankTeams(String[] votes) {
    int len = votes[0].length();
    int[][] voteCnt = new int[26][len + 1];
    for (String vote : votes) {
      for (int i = 0; i < vote.length(); i++) {
        int index = vote.charAt(i) - 'A';
        voteCnt[index][i]++;
        voteCnt[index][len] = index;
      }
    }
    Arrays.sort(voteCnt, (a, b) -> {
      for (int i = 0; i < len; i++) {
        if (a[i] != b[i]) {
          return b[i] - a[i];
        }
      }
      return a[len] - b[len];
    });
    StringBuilder sb = new StringBuilder();
    for (int[] v : voteCnt) {
      char c = (char) (v[len] + 'A');
      sb.append(c);
    }
    return sb.substring(0, len + 1);
  }
}
