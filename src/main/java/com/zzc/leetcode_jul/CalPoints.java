package com.zzc.leetcode_jul;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-29 00:04
 */
public class CalPoints {
  public int calPoints(String[] operations) {
    List<Integer> scores = new ArrayList<>();
    for(String str : operations) {
      switch (str) {
        case "C" -> scores.remove(scores.size() - 1);
        case "D" -> scores.add(scores.get(scores.size() - 1) * 2);
        case "+" -> scores.add(scores.get(scores.size() - 1) +  scores.get(scores.size() - 2));
        default -> scores.add(Integer.parseInt(str));
      }
    }
    return scores.stream().reduce(0, Integer::sum);
  }
}
