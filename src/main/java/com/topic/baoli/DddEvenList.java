package com.topic.baoli;

import com.topic.dfs.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 328 奇偶链表
 * @create 2024-10-09 17:26
 */
public class DddEvenList {

  //时间 o(n) 空间 o(n)
  public ListNode oddEvenList(ListNode head) {
    ListNode cur = head;
    int index = 1;
    List<Integer> jishuList = new ArrayList<>();
    List<Integer> oushuList = new ArrayList<>();
    while (cur != null) {
      if (index % 2 == 0) {
        oushuList.add(cur.val);
      } else {
        jishuList.add(cur.val);
      }
      index++;
      cur = cur.next;
    }
    cur = head;
    jishuList.addAll(oushuList);
    index = 0;
    while (cur != null) {
      cur.val = jishuList.get(index);
      index++;
      cur = cur.next;
    }
    return head;
  }
}
