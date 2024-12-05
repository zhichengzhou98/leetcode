package com.topic.baoli;

import com.topic.dfs.ListNode;

/**
 * @author zc.zhou
 * @Description 24. 两两交换链表中的节点
 * @create 2024-12-05 21:08
 */
public class SwapPairs {
  public ListNode swapPairs(ListNode head) {
    ListNode newHead = new ListNode();
    ListNode point = newHead;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      ListNode tmp = cur.next.next;
      point.next = cur.next;
      cur.next.next = cur;
      point = cur;
      cur = tmp;
    }
    point.next = cur;
    return newHead.next;
  }
}
