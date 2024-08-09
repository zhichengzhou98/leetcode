package com.topic.enumerate;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-09 17:15
 */
public class MinimizeResult {
  @Test
  void testFun() {
    String exp = "247+38";
    System.out.println(minimizeResult(exp));
  }
  public String minimizeResult(String expression) {
    String[] nums = expression.split("\\+");
    //123   +    456
    String n1 = nums[0];
    String n2 = nums[1];
    //记录括号的位置
    String resStr = "(" + expression + ")";
    int res = formatNum(n1) + formatNum(n2);
    //左括号的位置 0，1，2
    //右括号的位置 1，2，3
    for (int i = 0; i < n1.length(); i++) {
      String num1 = n1.substring(0, i);
      String num2 = n1.substring(i);
      for (int j = 1; j <= n2.length(); j++) {
        String num3 = n2.substring(0, j);
        String num4 = n2.substring(j);
        int newRes = formatNum(num1) * formatNum(num4) * (formatNum(num2) + formatNum(num3));
        if (res > newRes) {
          res = newRes;
          resStr = num1 + "(" + num2 + "+" + num3 + ")" + num4;
        }
      }
    }
    return resStr;
  }

  private int formatNum(String str) {
    if ("".equals(str)) {
      return 1;
    }
    return Integer.parseInt(str);
  }
}
