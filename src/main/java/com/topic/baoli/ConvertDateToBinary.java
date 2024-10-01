package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-08 22:03
 */
public class ConvertDateToBinary {
  public String convertDateToBinary(String date) {
    String[] strs = date.split("-");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs.length; i++) {
      int tmp = Integer.parseInt(strs[i]);
      sb.append(Integer.toBinaryString(tmp));
      if (i != strs.length - 1) {
        sb.append("-");
      }
    }
    return sb.toString();
  }
}
