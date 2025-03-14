package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description [3340]检查平衡字符串
 * @create 2025-03-14 8:51
 */
public class IsBalanced {
  public boolean isBalanced(String num) {
    int even = 0;
    int odd = 0;
    for (int i = 0; i < num.length(); i++) {
      int tmp = num.charAt(i) - '0';
      if (i % 2 == 0) {
        even += tmp;
      } else {
        odd += tmp;
      }
    }
    return even == odd;
  }
}
