package com.zzc.leetcode_jul;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author zc.zhou
 * @Description 2424
 * 1 <= n <= 10⁵
 * 1 <= video <= 10⁵
 * video 中所有值 互不相同 。
 * upload 和 longest 总调用 次数至多不超过 2 * 10⁵ 次。
 * 至少会调用 longest 一次。
 * @create 2024-07-24 16:23
 */

//使用普通set
public class LUPrefix {
  HashSet<Integer> set;
  //n 为最长上传前缀
  int n;

  int res = 1;

  public LUPrefix(int n) {
    set = new HashSet<>();
    this.n = n;
    for (int i = 1; i <= n; i++) {
      set.add(i);
    }
  }

  public void upload(int video) {
    set.remove(video);
  }

  public int longest() {
    if (set.isEmpty()) {
      return n;
    }
    while (!set.contains(res)) {
      res++;
    }
    return res - 1;
  }
}

class LUPrefix1 {
  TreeSet<Integer> set;
  int n;

  public LUPrefix1(int n) {
    set = new TreeSet<>();
    this.n = n;
    for (int i = 1; i <= n; i++) {
      set.add(i);
    }
  }

  public void upload(int video) {
    set.remove(video);
  }

  public int longest() {
    if (set.isEmpty()) {
      return n;
    }
    return set.first() - 1;
  }
}