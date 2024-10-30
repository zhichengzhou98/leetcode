package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3216. 交换后字典序最小的字符串
 * @create 2024-10-30 19:00
 */
public class GetSmallestString {
  public String getSmallestString(String s) {
    char[] chars = s.toCharArray();
    for (int i = 1; i < chars.length; i++) {
      int before = chars[i-1] - '0';
      int cur = chars[i] - '0';
      if ((cur + before) % 2 == 0 && before > cur) {
        chars[i-1] = (char) (cur + '0');
        chars[i] = (char) (before + '0');
        break;
      }
    }
    return new String(chars);
  }
}
