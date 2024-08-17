package com.topic.baoli;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-17 15:40
 */
public class MinimumOperationsToMakeKPeriodic {
  public int minimumOperationsToMakeKPeriodic(String word, int k) {
    Map<String, Integer> strCnts = new HashMap<>();
    //将word k个一组 统计每个字符串出现的次数
    int cnts = word.length() / k;
    int begin = 0;
    for (int i = 0; i < cnts; i++) {
      String sub = word.substring(begin, begin + k);
      strCnts.put(sub, strCnts.getOrDefault(sub, 0) + 1);
      begin += k;
    }
    Integer maxValue = strCnts.values().stream().max(Integer::compareTo).get();
    return cnts - maxValue;
  }
}
