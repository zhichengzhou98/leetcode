package com.topic.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zc.zhou
 * @Description [1963]使字符串平衡的最小交换次数
 * @create 2025-03-17 13:59
 */
public class MinSwaps {
  public int minSwaps(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return (stack.size() / 2 + 1) / 2;
  }
}
