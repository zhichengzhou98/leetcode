package com.topic.dfs;

import com.zzc.utils.ListNodeUtils;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 25 K个一组翻转链表
 * @create 2024-08-23 15:25
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  @Test
  void testFnu() throws Exception {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    ListNode listNode = reverseKGroup(l1, 3);
    ListNode nodes2 = ListNodeUtils.generate(ListNode.class);
    System.out.println(ListNodeUtils.printListNode(nodes2));
    System.out.println(ListNodeUtils.printListNode(listNode));
  }
  public ListNode reverseKGroup(ListNode head, int k) {
    int len = 0;
    //统计链表的长度
    ListNode current = head;
    while (current != null) {
      current = current.next;
      len++;
    }
    return reverse(head, k, len);
  }
  //反转链表
  //len为当前链表的长度
  private ListNode reverse(ListNode head, int k, int len) {
    if (len < k) {
      return head;
    }
    // 1 -> 2 -> 3 -> 4
    //head为反转后的尾节点
    //反转链表的前k个节点
    ListNode res = head;//res表示反转后的头节点
    ListNode current = head.next;
    int cnt = 1;
    while (cnt < k) {
      //取下一个节点
      ListNode next = current.next;
      current.next = res;
      res = current;
      current = next;
      cnt++;
    }
    head.next = reverse(current, k, len - k);
    return res;
  }
}
