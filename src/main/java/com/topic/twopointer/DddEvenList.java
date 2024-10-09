package com.topic.twopointer;

import com.topic.dfs.ListNode;
import com.zzc.utils.ListNodeUtils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 328 奇偶链表
 * @create 2024-10-09 17:26
 */
public class DddEvenList {

  //时间 o(n) 空间 o(n)
  public ListNode oddEvenListV1(ListNode head) {
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

  @Test
  void testFun() throws Exception {
    ListNode listNode = ListNodeUtils.generate(ListNode.class);
    oddEvenList(listNode);
    System.out.println(listNode);
  }

  //时间 o(n) 空间 o(1)
  public ListNode oddEvenList(ListNode head) {
    //奇数链表的当前节点
    ListNode oddCur = head;
    if (oddCur == null) {
      return oddCur;
    }
    //偶数链表的当前节点
    ListNode evenCur = head.next;
    ListNode tmp = head.next;
    if(evenCur == null || evenCur.next == null) {
      return head;
    }
    while (oddCur.next != null && evenCur.next != null) {
      oddCur.next = evenCur.next;
      oddCur = oddCur.next;
      evenCur.next = oddCur.next;
      evenCur = evenCur.next;
    }
    oddCur.next = tmp;
    return head;
  }
}
