package com.topic.twopointer;

import com.topic.dfs.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 142. 环形链表 II
 * @create 2024-12-11 20:49
 */
public class DetectCycle {
  public ListNode detectCycleV1(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    ListNode cur = head;
    if (cur == null) {
      return null;
    }
    while (cur != null) {
      if (set.contains(cur.next)) {
        return cur.next;
      }
      set.add(cur);
      cur = cur.next;
    }
    return null;
  }

  // TODO： 快慢指针
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    if (fast.next == null || fast.next.next == null) {
      return null;
    }
    fast = fast.next.next;
    slow = slow.next;
    // cnt为环的长度
    int cnt = 1;
    // 链表的总长度
    while (slow != fast) {
      if (fast.next == null || fast.next.next == null) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;
      cnt++;
    }
    for (int i = 0; i < cnt; i++) {
      slow = slow.next;
    }
    return slow;
  }
}
