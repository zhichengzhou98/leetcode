package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-25 9:16
 */
public class MinimumOperations {
  @Test
  void testFun() {
    System.out.println(minimumOperations("25"));
  }

  public int minimumOperations(String num) {
    int res = num.length();
    for (int i = 0; i < num.length(); i++) {
      if (num.charAt(i) == '0') {
        res--;
        break;
      }
    }
    String[] strings = {"00", "25", "50", "75"};
    for (String str : strings) {
      res = Math.min(res, minCount(num, str));
    }
    return res;
  }

  public int minCount(String source, String target) {
    //没匹配上时直接返回整个字符串得长度，最终结果不会超过这个值
    int res = source.length();
    char first = target.charAt(0);
    char last = target.charAt(1);
    int moveCount1 = moveCount(source, last);
    //moveCount1 == source.length() -1至少得保证还剩下以为字符用于first匹配
    if (moveCount1 == source.length() || moveCount1 == source.length() - 1) {
      //last没匹配上
      return res;
    }

    //计算新得source特殊值法, moveCount1==0时, 只需要取source的 [0, source.length() - 1)
    //source.length() - 1表示最后一位，不应该取到，因为该位已经被匹配占用了
    source = source.substring(0, source.length() - 1 - moveCount1);
    int moveCount2 = moveCount(source, first);
    if (moveCount2 == source.length()) {
      //first没匹配上
      return res;
    }
    return moveCount1 + moveCount2;
  }

  //从最后一位开始向前匹配字符，计算移动了多少位
  public int moveCount(String source, char c) {
    //字符串长度
    int len = source.length();
    //从最后一个字符开始向前匹配
    int right = source.length() - 1;
    while (right >= 0 && source.charAt(right) != c) {
      right--;
    }
    if (right < 0) {
      return len;
    }
    //特殊值法，当移到0位时
    return len - 1 - right;
  }
}
