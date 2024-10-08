package com.topic.baoli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 1436. 旅行终点站
 * @create 2024-10-08 08:30
 */
public class DestCity {
  public String destCity(List<List<String>> paths) {
    Set<String> start = new HashSet<>();
    Set<String> end = new HashSet<>();
    for(List<String> path : paths) {
      start.add(path.get(0));
      end.add(path.get(1));
    }
    end.removeAll(start);
    return end.stream().findFirst().get();
  }
}
