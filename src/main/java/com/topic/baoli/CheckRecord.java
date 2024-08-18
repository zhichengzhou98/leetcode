package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-18 10:27
 */
public class CheckRecord {
  public boolean checkRecord(String s) {
    int cnts = 0;
    for (int i = 0; i <  s.length(); i++) {
      if (s.charAt(i) == 'A') {
        cnts++;
      }
      if (cnts >= 2) {
        return false;
      }
    }
    return !s.contains("LLL");
  }
}
