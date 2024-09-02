package com.topic.slidwindow;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 2024 滑动窗口 求最长
 * @create 2024-09-02 9:14
 */
public class MaxConsecutiveAnswers {
  @Test
  void testFun() {
    String str = "TTFTTTTTFT";
    System.out.println(fun(str, 1, 'F'));
  }

  public int maxConsecutiveAnswers(String answerKey, int k) {
    return Math.max(fun(answerKey, k, 'T'), fun(answerKey, k, 'F'));
  }


  //转成目标字符后的最长长度target：T, F
  private int fun(String answerKey, int k, char target) {
    int res = 0;
    int left = 0;
    int right = 0;
    int len = answerKey.length();
    //target == T
    //统计窗口中target的个数cnt cnt < k, right 右移直到不满足
    int cnt = 0;
    if (answerKey.charAt(right) == target) {
      cnt++;
    }
    while (left <= right) {
      while (cnt <= k) {
        //满足条件时更新res
        //求最大值
        res = Math.max(right + 1 - left, res);
        //res = right + 1 -left;
        if (right + 1 < len) {
          //如果满足 right右移
          right++;
          if (answerKey.charAt(right) == target) {
            cnt++;
          }
        } else {
          return res;
        }
      }
      while (cnt > k && left <= right) {
        //left左移直到不满足条件
        if (answerKey.charAt(left) == target) {
          cnt--;
        }
        left++;
      }
    }
    return res;
  }
}
