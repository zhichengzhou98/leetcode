package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-27 09:59
 */
public class GetSmallestString {
  @Test
  void testFun() {
    System.out.println('k' - 'a');
    System.out.println(getSmallestString("zbbz", 3));
  }
  public String getSmallestString(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char oldChar = chars[i];
      //要让res尽可能小
      //k > 0 时才能继续换字符
      if (k > 0) {
        for (int j = 0; j < 26; j++) {
          int temp = Math.abs(oldChar - 'a' - j) % 26;
          //z到a的距离为1
          int delt = Math.min(temp, 26 -temp);
          if (k >= delt) {
            chars[i] = (char) (j + 'a');
            k -= delt;
            break;
          }
        }
      } else {
        break;
      }
    }
    return new String(chars);
  }
}
