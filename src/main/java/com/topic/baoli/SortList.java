package com.topic.baoli;

import com.topic.dfs.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 148. 排序链表 TODO 归并排序
 * @create 2024-12-11 20:33
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    List<ListNode> list = new ArrayList<>();
    ListNode cur = head;
    if (cur == null || cur.next == null) {
      return cur;
    }
    while (cur != null) {
      list.add(cur);
      cur = cur.next;
    }
    list.sort((a, b) -> b.val - a.val);
    for (int i = 0; i < list.size(); i++) {
      ListNode pre = list.get(i);
      if (i == list.size() - 1) {
        pre.next = null;
      } else {
        pre.next = list.get(i + 1);
      }
    }
    return list.get(0);
  }
}
