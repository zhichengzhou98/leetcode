package com.topic.dfs;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-09 9:05
 */
public class MergeNodes {
  public ListNode mergeNodes(ListNode head) {
    return dfs(head);
  }

  private ListNode dfs(ListNode head) {
    if (head.next == null) {
      return null;
    }
    int tmp = 0;
    ListNode cur = head.next;
    while (cur.val != 0) {
      tmp += cur.val;
      cur = cur.next;
    }
    ListNode newHead = new ListNode(tmp);
    newHead.next = dfs(cur);
    return newHead;
  }
}
