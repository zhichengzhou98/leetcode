package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-29 23:17
 */
public class AlertNames {
  @Test
  void testFun() {
    String[] names = {"john","john","john"};
    String[] times = {"23:58","23:59","00:01"};
    System.out.println(alertNames(names, times));
  }
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<String>> nameTime = new HashMap<>();
    for (int i = 0; i < keyName.length; i++) {
      String name = keyName[i];
      String time = keyTime[i];

      if (nameTime.containsKey(name)) {
        nameTime.get(name).add(time);
      } else {
        List<String> times = new ArrayList<>();
        times.add(time);
        nameTime.put(name, times);
      }
    }
    List<String> res = nameTime.entrySet().stream().filter(entry -> {
      if (filterName(entry.getValue())) {
        return true;
      }
      return false;
    }).map(Map.Entry::getKey).collect(Collectors.toList());
    Collections.sort(res);
    return res;
  }

  //一小时内打卡3次的员工
  private boolean filterName(List<String> times) {
    if (times == null || times.isEmpty()) {
      return false;
    }

    if (times.size() <= 2) {
      return false;
    }
    Collections.sort(times);
    for (int i = 2; i < times.size(); i++) {
      if (isOverOneHour(times.get(i), times.get(i - 2))) {
        return true;
      }
    }
    return false;
  }

  //是否超过一小时
  private boolean isOverOneHour(String last, String before) {
    String[] splitLast = last.split(":");
    String[] splitBefore = before.split(":");
    //把splitBefore+1小时
    splitBefore[0] = String.valueOf(Integer.parseInt(splitBefore[0]) + 1);
    if(Integer.parseInt(splitBefore[0]) > Integer.parseInt(splitLast[0])) {
      return true;
    }else if (Integer.parseInt(splitBefore[0]) == Integer.parseInt(splitLast[0])) {
      return Integer.parseInt(splitBefore[1]) >= Integer.parseInt(splitLast[1]);
    }
    return false;
  }
}
