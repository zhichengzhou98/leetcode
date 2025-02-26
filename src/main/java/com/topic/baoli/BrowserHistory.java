package com.topic.baoli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description [1472]设计浏览器历史记录
 * @create 2025-02-26 15:31
 */
public class BrowserHistory {
  List<String> pages;
  // 当前位置
  int p;
  public BrowserHistory(String homepage) {
    pages = new ArrayList<>();
    pages.add(homepage);
    p = 0;
  }

  public void visit(String url) {
    // 把p以后的元素都移除
    for (int i = pages.size() - 1; i > p ; i--) {
      pages.remove(i);
    }
    pages.add(url);
    p++;
  }

  public String back(int steps) {
    p = Math.max(0, p - steps);
    return pages.get(p);
  }

  public String forward(int steps) {
    p = Math.min(p + steps, pages.size()-1);
    return pages.get(p);
  }
}
