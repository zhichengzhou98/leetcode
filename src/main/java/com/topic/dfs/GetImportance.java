package com.topic.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-26 9:18
 */
public class GetImportance {
  Map<Integer, Employee> map;
  public int getImportance(List<Employee> employees, int id) {
    map = new HashMap<>();
    for (Employee e:employees) {
      map.put(e.id, e);
    }
    return dfs(id);
  }

  private int dfs(int root) {
    if (!map.containsKey(root)) {
      return 0;
    }
    Employee employee = map.get(root);
    int res = employee.importance;
    for (Integer subordinate : employee.subordinates) {
      res = res + dfs(subordinate);
    }
    return res;
  }
}

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
}