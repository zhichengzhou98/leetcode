package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 3174. 清除数字
 * @create 2024-09-05 9:13
 */
public class ClearDigits {
  public String clearDigits(String s) {
    int needDeleteCnt = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      char current = s.charAt(i);
      if (Character.isDigit(current)) {
        //当前字符是数字
        needDeleteCnt++;
      } else {
        //是字母
        if (needDeleteCnt > 0) {
          //跳过
          needDeleteCnt--;
        } else {
          //当前字符加入
          sb.append(current);
        }
      }
    }
    return sb.reverse().toString();
  }
}
